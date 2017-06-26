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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ViewProduct)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    ViewProduct that = (ViewProduct) o;

    return getProduct() != null ? getProduct().equals(that.getProduct()) : that.getProduct() == null;
  }
}
