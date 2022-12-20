package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private final String INVALID_CONNECTION = "Error: the connection already exist.";
    private final String SUCCESS_DISCONNECTION = "Connection stopped";
    private final TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return ("connected");
    }

    @Override
    public void write(String message) {
    }

    @Override
    public void connect() {
        System.out.println(INVALID_CONNECTION);
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setState(new Disconnected(this.tcpConnection));
        System.out.println(SUCCESS_DISCONNECTION + this.tcpConnection.getIpAdress() + ":" + this.tcpConnection.getPort());
    }
}
// END
