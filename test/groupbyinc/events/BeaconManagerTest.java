package groupbyinc.events;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.groupbyinc.common.apache.http.HttpResponse;
import com.groupbyinc.common.apache.http.HttpStatus;
import groupbyinc.events.components.Customer;
import groupbyinc.models.BeaconRequest;
import groupbyinc.models.TrackerException;
import groupbyinc.util.FreePort;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

public class BeaconManagerTest {

  @Rule public WireMockRule mock = new WireMockRule(FreePort.next());
  BeaconRequest beaconRequest;

  @Before
  public void setUpRequestAndClient() throws MalformedURLException {
    try {
      AddToCart event = (AddToCart)(new AddToCart().setId("testId").setCustomer(new Customer("custId", "custArea")));
      beaconRequest = new BeaconRequest(event);
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
    assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
  }

  private void stubWithBodyAndCode(String testResponseString, int statusCode) {
    mock.stubFor(post(urlEqualTo("/someAddToCart/URL")).willReturn(aResponse().withHeader("Content-Type", "application/json")
                                                                       .withStatus(statusCode)
                                                                       .withBody(testResponseString)));
  }

}
