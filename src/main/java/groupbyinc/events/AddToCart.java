package groupbyinc.events;

import groupbyinc.events.components.Cart;
import groupbyinc.events.components.Item;

public class AddToCart extends CartEvent {

  public AddToCart(Cart cart, Item item) {
    this(cart);
    this.getCart().addItem(item);
  }

  private AddToCart(Cart cart) {
    super(cart);
    setEventType(EventType.ADD_TO_CART);
    setCart(new Cart(cart.getId()));
  }
}
