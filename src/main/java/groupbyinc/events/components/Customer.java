package groupbyinc.events.components;

public class Customer {
  private String id;
  private String area;

  public Customer(String id, String area) {
    this.id = id;
    this.area = area;
  }

  public String getId() {
    return id;
  }

  public Customer setId(String id) {
    this.id = id;
    return this;
  }

  public String getArea() {
    return area;
  }

  public Customer setArea(String area) {
    this.area = area;
    return this;
  }
}
