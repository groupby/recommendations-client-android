package groupbyinc.events.components;

public class Item {
  private Product product;
  private String quantity;

  public Item(){}

  public Item(Product product, String quantity) {
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

  public String getQuantity() {
    return quantity;
  }

  public Item setQuantity(String quantity) {
    this.quantity = quantity;
    return this;
  }
}
