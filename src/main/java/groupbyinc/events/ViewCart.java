package groupbyinc.events;

import groupbyinc.events.components.Cart;

public class ViewCart extends CartEvent {

  public ViewCart(Cart cart) {
    super(cart);
    setEventType(EventType.VIEW_CART);
  }
}
