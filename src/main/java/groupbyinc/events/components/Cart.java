package groupbyinc.events.components;

import java.util.List;

public class Cart {

  private List<Item> items;
  private String id;
  private List<Metadata> metadata;

  public Cart() {
  }

  public Cart(String id) {
    this.id = id;
  }

  public Cart(List<Item> items, String id) {
    this.items = items;
    this.id = id;
  }

  public List<Item> getItems() {
    return items;
  }

  public Cart setItems(List<Item> items) {
    this.items = items;
    return this;
  }

  public String getId() {
    return id;
  }

  public Cart setId(String id) {
    this.id = id;
    return this;
  }

  public List<Metadata> getMetadata() {
    return metadata;
  }

  public Cart setMetadata(List<Metadata> metadata) {
    this.metadata = metadata;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cart)) {
      return false;
    }

    Cart cart = (Cart) o;

    if (getItems() != null ? !getItems().equals(cart.getItems()) : cart.getItems() != null) {
      return false;
    }
    if (getId() != null ? !getId().equals(cart.getId()) : cart.getId() != null) {
      return false;
    }
    return getMetadata() != null ? getMetadata().equals(cart.getMetadata()) : cart.getMetadata() == null;
  }
}
