package groupbyinc.events;

import groupbyinc.events.components.Cart;

public class Order extends CartEvent{

  public Order() {
    super();
    setEventType(EventType.ORDER);
  }

  public Order(Cart cart) {
    super(cart);
    setEventType(EventType.ORDER);
  }
}
