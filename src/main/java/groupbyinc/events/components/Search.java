package groupbyinc.events.components;

public class Search {
  private Boolean sayt, dym, search, autosearch, navigation, collectionSwitcher;

  public Search() {
  }

  public Boolean getSayt() {
    return sayt;
  }

  public Search setSayt(Boolean sayt) {
    this.sayt = sayt;
    return this;
  }

  public Boolean getDym() {
    return dym;
  }

  public Search setDym(Boolean dym) {
    this.dym = dym;
    return this;
  }

  public Boolean getSearch() {
    return search;
  }

  public Search setSearch(Boolean search) {
    this.search = search;
    return this;
  }

  public Boolean getAutosearch() {
    return autosearch;
  }

  public Search setAutosearch(Boolean autosearch) {
    this.autosearch = autosearch;
    return this;
  }

  public Boolean getNavigation() {
    return navigation;
  }

  public Search setNavigation(Boolean navigation) {
    this.navigation = navigation;
    return this;
  }

  public Boolean getCollectionSwitcher() {
    return collectionSwitcher;
  }

  public Search setCollectionSwitcher(Boolean collectionSwitcher) {
    this.collectionSwitcher = collectionSwitcher;
    return this;
  }
}
