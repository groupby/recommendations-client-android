package groupbyinc.events;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.groupbyinc.common.apache.http.HttpResponse;
import com.groupbyinc.common.apache.http.HttpStatus;
import groupbyinc.events.components.Cart;
import groupbyinc.events.components.Customer;
import groupbyinc.events.components.Item;
import groupbyinc.events.components.Product;
import groupbyinc.models.BeaconRequest;
import groupbyinc.models.TrackerException;
import groupbyinc.util.FreePort;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

public class BeaconManagerTest {

  @Rule public WireMockRule mock = new WireMockRule(FreePort.next());
  private BeaconRequest beaconRequest;

  @Before
  public void setUpRequestAndClient() throws MalformedURLException {
    try {
      Cart cart = new Cart("cartId");
      AddToCart event = new AddToCart(cart, new Item(new Product("sku", "prod"), 1));
      event.setId("testId")
          .setCustomer(new Customer("custid", "custarea"));
      beaconRequest = new BeaconRequest(event);
      beaconRequest.setRequestUrl(new URL("http", "localhost", mock.port(), "/beacon"));
    } catch (TrackerException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSendAddToCart() throws Throwable {
    String testResponseString = "Test";

    stubWithBodyAndCode(testResponseString, HttpStatus.SC_OK);

    BeaconManager manager = new BeaconManager("testapikey");
    HttpResponse response = manager.send(beaconRequest);

    // ASSERTS
    assertEquals(HttpStatus.SC_OK, response.getStatusLine()
        .getStatusCode());

    mock.verify(postRequestedFor(urlEqualTo("/beacon")).withHeader("authorization", equalTo("testapikey"))
                    .withHeader("Content-Type", equalTo("application/json"))
                    .withRequestBody(equalToJson("{\"customerIds\":[\"customer1\",\"customer2\"]}")));
  }

  private void stubWithBodyAndCode(String testResponseString, int statusCode) {
    mock.stubFor(post(urlEqualTo("/beacon")).willReturn(aResponse().withHeader("Content-Type", "application/json")
                                                            .withStatus(statusCode)
                                                            .withBody(testResponseString)));
  }
}
