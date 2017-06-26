package groupbyinc.events;

import groupbyinc.events.components.Cart;

public class AddToCart extends CartEvent {

  public AddToCart() {
    super();
    setEventType(EventType.ADD_TO_CART);
  }

  public AddToCart(Cart cart) {
    super(cart);
    setEventType(EventType.ADD_TO_CART);
  }

}
