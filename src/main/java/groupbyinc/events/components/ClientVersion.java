package groupbyinc.events.components;

public class ClientVersion {
  private String raw, major, minor, patch, prerelease, build, version;

  public ClientVersion(String raw) {
    this.raw = raw;
  }

  public String getRaw() {
    return raw;
  }

  public ClientVersion setRaw(String raw) {
    this.raw = raw;
    return this;
  }

  public String getMajor() {
    return major;
  }

  public ClientVersion setMajor(String major) {
    this.major = major;
    return this;
  }

  public String getMinor() {
    return minor;
  }

  public ClientVersion setMinor(String minor) {
    this.minor = minor;
    return this;
  }

  public String getPatch() {
    return patch;
  }

  public ClientVersion setPatch(String patch) {
    this.patch = patch;
    return this;
  }

  public String getPrerelease() {
    return prerelease;
  }

  public ClientVersion setPrerelease(String prerelease) {
    this.prerelease = prerelease;
    return this;
  }

  public String getBuild() {
    return build;
  }

  public ClientVersion setBuild(String build) {
    this.build = build;
    return this;
  }

  public String getVersion() {
    return version;
  }

  public ClientVersion setVersion(String version) {
    this.version = version;
    return this;
  }
}
