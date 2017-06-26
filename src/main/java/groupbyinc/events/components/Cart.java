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

}
