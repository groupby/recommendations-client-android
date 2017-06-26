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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Metadata)) {
      return false;
    }

    Metadata metadata = (Metadata) o;

    if (getKey() != null ? !getKey().equals(metadata.getKey()) : metadata.getKey() != null) {
      return false;
    }
    return getValue() != null ? getValue().equals(metadata.getValue()) : metadata.getValue() == null;
  }
}
