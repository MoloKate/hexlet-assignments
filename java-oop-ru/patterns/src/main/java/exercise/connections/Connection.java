package exercise.connections;

public interface Connection {
    // BEGIN
    void connect();

    String getCurrentState();

    void disconnect();

    void write(String message);
    // END
}
