package groupbyinc.models;

import com.groupbyinc.common.util.exception.GroupByException;

/**
 * Created by tahir on 23/06/17.
 */
public class TrackerException extends GroupByException {

  public TrackerException(String key) {
    super(key);
  }

  public TrackerException(String key, Throwable throwable) {
    super(key, throwable);
  }

  public TrackerException(String key, String message) {
    super(key, message);
  }

  public TrackerException(String key, String message, Throwable throwable) {
    super(key, message, throwable);
  }
}
