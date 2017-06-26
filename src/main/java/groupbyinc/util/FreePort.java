package groupbyinc.util;

public class FreePort {

    private static final int MIN_PORT = 10000;
    private static final int MAX_PORT = 60000;

    public static int next() {
        return SocketUtils.findAvailableTcpPort(MIN_PORT, MAX_PORT);
    }
}