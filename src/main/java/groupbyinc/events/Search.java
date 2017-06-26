package groupbyinc.events;

import com.groupbyinc.api.model.Results;

public class Search extends Event {

  private Results search;
  private String responseId;

  public Search(Results search, String responseId) {
    this.search = search;
    this.responseId = responseId;
  }

  public Results getSearch() {
    return search;
  }

  public Search setSearch(Results search) {
    this.search = search;
    return this;
  }

  public String getResponseId() {
    return responseId;
  }

  public Search setResponseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Search)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    Search search1 = (Search) o;

    if (getSearch() != null ? !getSearch().equals(search1.getSearch()) : search1.getSearch() != null) {
      return false;
    }
    return getResponseId() != null ? getResponseId().equals(search1.getResponseId()) : search1.getResponseId() == null;
  }
}
