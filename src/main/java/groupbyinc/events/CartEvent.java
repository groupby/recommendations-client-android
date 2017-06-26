package groupbyinc.events;

import groupbyinc.events.components.Cart;

public abstract class CartEvent extends Event {
  private Cart cart;

  public CartEvent(){}

  public CartEvent(Cart cart) {
    this.cart = cart;
  }

  public Cart getCart() {
    return cart;
  }

  public CartEvent setCart(Cart cart) {
    this.cart = cart;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CartEvent)) {
      return false;
    }

    CartEvent cartEvent = (CartEvent) o;

    return getCart() != null ? getCart().equals(cartEvent.getCart()) : cartEvent.getCart() == null;
  }
}
