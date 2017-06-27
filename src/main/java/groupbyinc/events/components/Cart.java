package groupbyinc.events.components;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private List<Item> items = new ArrayList<>();
  private String id;
  private List<Metadata> metadata;

  public Cart(String id) {
    this.id = id;
  }


  public List<Item> getItems() {
    return items;
  }

  protected Cart setItems(List<Item> items) {
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

  public Cart addItem (Item item){
    for (Item p : this.items) {
      if (p.getProduct().equals(item.getProduct())) {
        p.setQuantity(p.getQuantity() + item.getQuantity());
        return this;
      }
    }
    this.items.add(item);
    return this;
  }

//  public Cart removeItem (Item item) {
//    for (Item p : this.items) {
//      if (p.getProduct().equals(item.getProduct())) {
//        p.setQuantity(p.getQuantity() - item.getQuantity());
//        return this;
//      }
//    }
//    return this;
//  }
}
