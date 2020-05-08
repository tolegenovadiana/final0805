package DBmanager;
import java.io.*;
import java.net.*;
import java.sql.*;

public class Client {
    private final Connection connection;
    private final Socket socket;
    ObjectInputStream input;
    ObjectOutputStream output;

    public Client(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            input = new ObjectInputStream(this.socket.getInputStream());
            output = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}