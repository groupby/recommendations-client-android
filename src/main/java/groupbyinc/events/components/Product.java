package groupbyinc.events.components;

import java.util.List;

public class Product {

  private String sku;
  private String productId;
  private String title;
  private String collection;
  private String parentId;
  private Double margin;
  private Double price;
  private List<Metadata> metadata;

  public String getSku() {
    return sku;
  }

  public Product setSku(String sku) {
    this.sku = sku;
    return this;
  }

  public String getProductId() {
    return productId;
  }

  public Product setProductId(String productId) {
    this.productId = productId;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Product setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getCollection() {
    return collection;
  }

  public Product setCollection(String collection) {
    this.collection = collection;
    return this;
  }

  public String getParentId() {
    return parentId;
  }

  public Product setParentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

  public Double getMargin() {
    return margin;
  }

  public Product setMargin(Double margin) {
    this.margin = margin;
    return this;
  }

  public Double getPrice() {
    return price;
  }

  public Product setPrice(Double price) {
    this.price = price;
    return this;
  }

  public List<Metadata> getMetadata() {
    return metadata;
  }

  public Product setMetadata(List<Metadata> metadata) {
    this.metadata = metadata;
    return this;
  }

  public Product(String sku, String productId) {
    this.sku = sku;
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }

    Product product = (Product) o;

    if (getSku() != null ? !getSku().equals(product.getSku()) : product.getSku() != null) {
      return false;
    }
    return getProductId() != null ? getProductId().equals(product.getProductId()) : product.getProductId() == null;
  }
}
