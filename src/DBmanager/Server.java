package DBmanager;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(3306);

            while(true){
                System.out.println("waiting");
                Socket socket = ss.accept();
                System.out.println("connected");

                Client client = new Client(socket,connection);
                client.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
