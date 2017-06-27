package groupbyinc.events.components;

import junit.framework.TestCase;

public class CartTest extends TestCase {

  public void testAddItemToEmptyCart() throws Exception {
    final int ADDED_QUANTITY = 1;
    Cart cart = new Cart("cartId");
    Product product = new Product("sku1", "prod1");
    Item item = new Item(product, ADDED_QUANTITY);
    cart.addItem(item);


    assertEquals(1, cart.getItems().size());
    assertEquals(ADDED_QUANTITY, cart.getItems().get(0).getQuantity());
    assertEquals("sku1", cart.getItems().get(0).getProduct().getSku());
    assertEquals("prod1", cart.getItems().get(0).getProduct().getProductId());
  }

  public void testAddDuplicateItem() throws Exception {
    final int ADDED_QUANTITY = 1;
    Cart cart = new Cart("cartId");
    Product product = new Product("sku1", "prod1");
    Item item = new Item(product, ADDED_QUANTITY);
    cart.addItem(item);

    Product product2 = new Product("sku1", "prod1");
    Item item2 = new Item(product2, ADDED_QUANTITY + 1);
    cart.addItem(item2);

    assertEquals(1, cart.getItems().size());
    assertEquals(ADDED_QUANTITY* 2 + 1, cart.getItems().get(0).getQuantity());
    assertEquals("sku1", cart.getItems().get(0).getProduct().getSku());
    assertEquals("prod1", cart.getItems().get(0).getProduct().getProductId());
  }

  public void testAddToNonemptyCart() throws Exception {
    final int ADDED_QUANTITY = 1;
    Cart cart = new Cart("cartId");
    Product product = new Product("sku1", "prod1");
    Item item = new Item(product, ADDED_QUANTITY);
    cart.addItem(item);

    Product product2 = new Product("sku2", "prod2");
    Item item2 = new Item(product2, ADDED_QUANTITY+1);
    cart.addItem(item2);

    assertEquals(2, cart.getItems().size());
    assertEquals(ADDED_QUANTITY, cart.getItems().get(0).getQuantity());
    assertEquals("sku1", cart.getItems().get(0).getProduct().getSku());
    assertEquals("prod1", cart.getItems().get(0).getProduct().getProductId());
    assertEquals(ADDED_QUANTITY + 1, cart.getItems().get(1).getQuantity());
    assertEquals("sku2", cart.getItems().get(1).getProduct().getSku());
    assertEquals("prod2", cart.getItems().get(1).getProduct().getProductId());
  }
}