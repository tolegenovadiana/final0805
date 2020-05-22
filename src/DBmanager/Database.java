package DBmanager;
import java.sql.*;
import java.util.Date;

public class Database {
    public Database() throws ClassNotFoundException, SQLException { }
    Connection connection;
    String log = "f";
    String pass = "a";

    public void newuser(String login, String password, String name, String role) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krustykrab?useTimezone=true&serverTimezone=UTC", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO krustykrab.users(id,login, password ,fullname , role)"
                        + "VALUES(NULL,? , ? , ? , ? ) ");
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, role);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("You registered successfully");
    }

    public int login(String login1, String password1) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krustykrab?useTimezone=true&serverTimezone=UTC", "root", "root");
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT login,password FROM krustykrab.users WHERE login=? ");
        preparedStatement.setString(1,login1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            log = resultSet.getString(1);
            pass = resultSet.getString(2);

        }
        int k = 0;
        if (log.compareTo(login1) == 0 && pass.compareTo(password1) == 0) {
            System.out.println("good");
            k = 1;
        }
        return k;
    }


}