package groupbyinc.models;

import groupbyinc.events.Event;

import java.net.MalformedURLException;
import java.net.URL;

public class BeaconRequest {

  private final static String DEFAULT_BEACON_PATH = ".groupbycloud.com/beacon";
  private URL requestUrl;

  private Event event;

  public BeaconRequest(Event e) throws TrackerException {
    try {
      String url = "http://" + e.getCustomer()
          .getId() + DEFAULT_BEACON_PATH;
      this.requestUrl = new URL(url);
      this.event = e;
    } catch (MalformedURLException err) {
      throw(new TrackerException("Invalid URL", err));
    }
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public URL getRequestUrl() {
    return requestUrl;
  }

  public void setRequestUrl(URL requestUrl) {
    this.requestUrl = requestUrl;
  }

}
