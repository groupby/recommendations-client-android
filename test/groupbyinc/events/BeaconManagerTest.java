package groupbyinc.events;

import com.groupbyinc.common.apache.http.HttpResponse;
import com.groupbyinc.common.apache.http.HttpStatus;
import com.meterware.pseudoserver.PseudoServer;
import com.meterware.pseudoserver.PseudoServlet;
import com.meterware.pseudoserver.WebResource;
import groupbyinc.events.components.Customer;
import groupbyinc.models.BeaconRequest;
import groupbyinc.models.TrackerException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class BeaconManagerTest {

//  @Rule public WireMockRule mock = new WireMockRule(FreePort.next());
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
    PseudoServer server = new PseudoServer(5000);
    server.setResource("/beacon", new PseudoServlet() {
      @Override
      public WebResource getResponse(String methodType) throws IOException {
        //        postBodys.add(new String(getBody()));
        return new WebResource("{test: 'test'}");
      }
    });

    URL requestUrl = new URL("http://localhost:" + Integer.toString(server.getConnectedPort()) + "/beacon");
    System.out.println(requestUrl);
    beaconRequest.setRequestUrl(requestUrl);
//    stubWithBodyAndCode(beaconRequest, testResponseString, HttpStatus.SC_OK);

    BeaconManager manager = new BeaconManager("testapikey");
    HttpResponse response = manager.send(beaconRequest);

    // ASSERTS
    assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());



    //assertEquals(expectedObj, Mappers.readValue(response.getEntity().getContent(), Object.class, false));
//    mock.verify(postRequestedFor(urlEqualTo("/beacon")).withRequestBody(equalToJson("{\"customerIds\":[\"customer1\"]}")));
  }

//  private void stubWithBodyAndCode(BeaconRequest beaconRequest, String testResponseString, int statusCode) {
//    mock.stubFor(post(urlEqualTo("/beacon")).willReturn(aResponse().withHeader("Content-Type", "application/json")
//                                                                       .withStatus(statusCode)
//                                                                       .withBody(testResponseString)));
//  }

}
