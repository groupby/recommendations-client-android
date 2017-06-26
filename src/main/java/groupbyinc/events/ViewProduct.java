package groupbyinc.events;

import groupbyinc.events.components.Product;

public class ViewProduct extends Event{
  private Product product;

  public ViewProduct(Product product) {
    this.product = product;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
