package groupbyinc.events;

public enum EventType {
  ADD_TO_CART("addToCart"), VIEW_PRODUCT("viewProduct"), ORDER("order"), SEARCH("search"), VIEW_CART("viewCart");

  private final String eventType;

  public String toString() {
    return eventType;
  }

  EventType(String value){
    this.eventType = value;
  }


}

