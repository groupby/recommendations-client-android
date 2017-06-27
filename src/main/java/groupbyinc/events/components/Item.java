package groupbyinc.events.components;

public class Item {
  private Product product;
  private int quantity;

  public Item(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public Item setProduct(Product product) {
    this.product = product;
    return this;
  }

  public int getQuantity() {
    return quantity;
  }

  public Item setQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }
}
