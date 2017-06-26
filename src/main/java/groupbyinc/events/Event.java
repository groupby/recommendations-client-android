package groupbyinc.events;

import groupbyinc.events.components.ClientVersion;
import groupbyinc.events.components.Customer;
import groupbyinc.events.components.Metadata;
import groupbyinc.events.components.Visit;

import java.util.List;

public abstract class Event {
  private EventType eventType;
  private String id;
  private Visit visit;
  private Customer customer;
  private List<Metadata> metadata;
  private ClientVersion clientVersion;

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  public String getId() {
    return id;
  }

  public Event setId(String id) {
    this.id = id;
    return this;
  }

  public Visit getVisit() {
    return visit;
  }

  public Event setVisit(Visit visit) {
    this.visit = visit;
    return this;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Event setCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }

  public List<Metadata> getMetadata() {
    return metadata;
  }

  public Event setMetadata(List<Metadata> metadata) {
    this.metadata = metadata;
    return this;
  }

  public ClientVersion getClientVersion() {
    return clientVersion;
  }

  public Event setClientVersion(ClientVersion clientVersion) {
    this.clientVersion = clientVersion;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Event)) {
      return false;
    }

    Event event = (Event) o;

    if (getEventType() != event.getEventType()) {
      return false;
    }
    if (getId() != null ? !getId().equals(event.getId()) : event.getId() != null) {
      return false;
    }
    if (getVisit() != null ? !getVisit().equals(event.getVisit()) : event.getVisit() != null) {
      return false;
    }
    if (getCustomer() != null ? !getCustomer().equals(event.getCustomer()) : event.getCustomer() != null) {
      return false;
    }
    if (getMetadata() != null ? !getMetadata().equals(event.getMetadata()) : event.getMetadata() != null) {
      return false;
    }
    return getClientVersion() != null ? getClientVersion().equals(event.getClientVersion()) : event.getClientVersion() == null;
  }
}
