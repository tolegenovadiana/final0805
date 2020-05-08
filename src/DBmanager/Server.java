package DBmanager;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8899);

            while(true){
                System.out.println("waiting for client");
                Socket socket = ss.accept();
                System.out.println("new client connected");

                Client sth = new Client(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
