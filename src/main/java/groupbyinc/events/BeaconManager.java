package groupbyinc.events;

import com.groupbyinc.common.apache.http.HttpResponse;
import com.groupbyinc.common.apache.http.client.ClientProtocolException;
import com.groupbyinc.common.apache.http.client.methods.HttpPost;
import com.groupbyinc.common.apache.http.entity.StringEntity;
import com.groupbyinc.common.jackson.Mappers;
import groupbyinc.clients.TrackerClient;
import groupbyinc.models.BeaconRequest;
import groupbyinc.models.GroupByParseException;
import groupbyinc.models.TrackerException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

public class BeaconManager {
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private String apiKey;

  public BeaconManager(String apiKey) {
     this.apiKey = apiKey;
  }

  public HttpResponse send(BeaconRequest request) throws GroupByParseException, TrackerException {
    HttpPost httpPost;
    HttpResponse response;

    try {
      httpPost = new HttpPost(request.getRequestUrl()
                                  .toURI());
    }  catch (URISyntaxException e) {
      throw new GroupByParseException("Incorrect URI syntax", e);
    }
    httpPost.setHeader("Content-Type", "application/json");
    httpPost.setHeader("Authorization", this.apiKey);
    String json = Mappers.writeValueAsString(request.getEvent());
    StringEntity entity = new StringEntity(json, UTF8);
    httpPost.setEntity(entity);
    try {
      TrackerClient trackerClient = new TrackerClient();
      response = trackerClient.getHttpClient()
          .execute(httpPost);
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != 200){
        throw new TrackerException("API Error", "Non-200 status code returned from GB Tracker: " + statusCode);
      }
    } catch (ClientProtocolException e) {
      throw new TrackerException("Client Protocol exception", e);
    } catch (IOException e) {
      throw new TrackerException("IOexception", e);
    }
    return response;
  }
}
