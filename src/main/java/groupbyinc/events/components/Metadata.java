package groupbyinc.events.components;

public class Metadata {

  private String key;
  private String value;

  public Metadata(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public Metadata setKey(String key) {
    this.key = key;
    return this;
  }

  public String getValue() {
    return value;
  }

  public Metadata setValue(String value) {
    this.value = value;
    return this;
  }
}
