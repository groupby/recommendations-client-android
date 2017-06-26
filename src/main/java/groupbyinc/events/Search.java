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

}
