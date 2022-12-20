package exercise;

import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection {
    private final String IP_ADRESS;
    private final int PORT;
    private Connection state;
    private final StringBuffer buffer;

    public TcpConnection(String IP_ADRESS, int PORT) {
        this.state = new Disconnected(this);
        this.IP_ADRESS = IP_ADRESS;
        this.PORT = PORT;
        this.buffer = new StringBuffer();
    }

    public void connect() {
        state.connect();
    }

    public void disconnect() {
        state.disconnect();
    }


    public void write(String text) {
        state.write(text);
    }

    public String getCurrentState() {
        return state.getCurrentState();
    }

    public void setState(Connection state) {
        this.state = state;
    }

    public String getIpAdress() {
        return IP_ADRESS;
    }

    public int getPort() {
        return PORT;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }
}
// END
