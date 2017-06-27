package groupbyinc.events;

import groupbyinc.events.components.Cart;
import groupbyinc.events.components.Item;
import groupbyinc.events.components.Product;
import junit.framework.TestCase;

public class AddToCartTest extends TestCase {

  public void testConstructorEmptyInitialCart() throws Exception {
    Cart cart = new Cart("cartId");
    Product product = new Product("sku1", "prod1");
    Item item = new Item(product, 1);
    AddToCart event = new AddToCart(cart, item);

    assertEquals(1 ,event.getCart().getItems().size());
    assertEquals("sku1" ,event.getCart().getItems().get(0).getProduct().getSku());
    assertEquals("prod1" ,event.getCart().getItems().get(0).getProduct().getProductId());
  }


  public void testConstructorNonEmptyInitialCart() throws Exception {
    Cart cart = new Cart("cartId");
    cart.addItem(new Item(new Product("sku1", "prod1"), 1));
    Product product = new Product("sku2", "prod2");
    Item item = new Item(product, 1);
    AddToCart event = new AddToCart(cart, item);

    assertEquals(1 ,event.getCart().getItems().size());
    assertEquals("sku2" ,event.getCart().getItems().get(0).getProduct().getSku());
    assertEquals("prod2" ,event.getCart().getItems().get(0).getProduct().getProductId());
  }
}