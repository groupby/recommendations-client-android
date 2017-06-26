package groupbyinc.models;

import com.groupbyinc.common.util.exception.GroupByException;

public class GroupByParseException extends GroupByException {

  public GroupByParseException(String key) {
    super(key);
  }

  public GroupByParseException(String key, Throwable throwable) {
    super(key, throwable);
  }

  public GroupByParseException(String key, String message) {
    super(key, message);
  }

  public GroupByParseException(String key, String message, Throwable throwable) {
    super(key, message, throwable);
  }
}

