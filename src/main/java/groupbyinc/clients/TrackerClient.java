package groupbyinc.clients;

import com.groupbyinc.common.apache.http.client.config.RequestConfig;
import com.groupbyinc.common.apache.http.impl.client.CloseableHttpClient;
import com.groupbyinc.common.apache.http.impl.client.HttpClientBuilder;
import com.groupbyinc.common.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class TrackerClient {

  private static final int CONNECT_TIMEOUT_MS = 30000;
  private static final int CONNECTION_REQUEST_TIMEOUT_MS = 60000;
  private static final int SOCKET_TIMEOUT_MS = 90000;

  protected static final RequestConfig REQUEST_CONFIG = RequestConfig.custom()
      .setConnectTimeout(CONNECT_TIMEOUT_MS)
      .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT_MS)
      .setSocketTimeout(SOCKET_TIMEOUT_MS)
      .build();

  protected CloseableHttpClient httpClient = HttpClientBuilder.create()
      .setConnectionManager(new PoolingHttpClientConnectionManager())
      .setDefaultRequestConfig(REQUEST_CONFIG)
      .build();

  public CloseableHttpClient getHttpClient() {
    return httpClient;
  }
}
