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
      AddToCart event = (AddToCart)(new AddToCart().setId("testId").setCustomer(new Customer("custid", "custarea")));
      beaconRequest = new BeaconRequest(event);
    } catch (TrackerException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testSendAddToCart() throws Throwable {
//    PseudoServer server = new PseudoServer(5000);
//    server.setResource("", new PseudoServlet() {
//      @Override
//      public WebResource getResponse(String methodType) throws IOException {
////        postBodys.add(new String(getBody()));
//        return new WebResource("{test: 'test'}");
//      }
//    });
    String testResponseString = "Test";

    stubWithBodyAndCode(beaconRequest, testResponseString, HttpStatus.SC_OK);

    BeaconManager manager = new BeaconManager("testapikey");
    HttpResponse response = manager.send(beaconRequest);

    // ASSERTS
    assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
  }

  private void stubWithBodyAndCode(BeaconRequest beaconRequest, String testResponseString, int statusCode) {
//    try {
//      beaconRequest.setRequestUrl(new URL("/beacon"));
//    } catch (Exception e) {
//      System.out.println("bad url here");
//    }
    mock.stubFor(post(urlEqualTo("custid.groupbyinc.com/beacon")).willReturn(aResponse().withHeader("Content-Type", "application/json")
                                                                       .withStatus(statusCode)
                                                                       .withBody(testResponseString)));
  }

}
