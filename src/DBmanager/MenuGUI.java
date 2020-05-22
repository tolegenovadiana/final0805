package DBmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.IOException;

public class MenuGUI extends JFrame {

    JLabel orderlabel = new JLabel("Place your order:");
    JLabel nameLabel = new JLabel("Enter Name");
    JLabel addresslabel = new JLabel("Enter Your Address");
    JLabel phonelabel = new JLabel("Enter Phone Number");
    JLabel datelabel = new JLabel("Enter Today's Date");
    JComboBox comboBoxFood;
    JTextField textname = new JTextField();
    JTextField textadress = new JTextField();
    JTextField textphone = new JTextField();
    JTextField textdate = new JTextField();

    JButton addbutton = new JButton("ADD");


    public MenuGUI() throws ClassNotFoundException, SQLException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 340);
        setLayout(null);
        setTitle("AdminMenu");

        JLabel im = new JLabel("");
        orderlabel.setBounds(270, 20, 100, 20);
        add(orderlabel);
        orderlabel.setOpaque(true);
        orderlabel.setBackground(Color.RED);
        orderlabel.setForeground(Color.WHITE);
        nameLabel.setBounds(170, 50, 180, 20);
        add(nameLabel);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.RED);
        nameLabel.setForeground(Color.WHITE);
        addresslabel.setBounds(170, 80, 180, 20);
        add(addresslabel);
        addresslabel.setOpaque(true);
        addresslabel.setBackground(Color.RED);
        addresslabel.setForeground(Color.WHITE);
        phonelabel.setBounds(170, 110, 180, 20);
        add(phonelabel);
        phonelabel.setOpaque(true);
        phonelabel.setBackground(Color.RED);
        phonelabel.setForeground(Color.WHITE);
        datelabel.setBounds(170, 140, 180, 20);
        add(datelabel);
        datelabel.setOpaque(true);
        datelabel.setBackground(Color.RED);
        datelabel.setForeground(Color.WHITE);

        textname.setBounds(310, 50, 150, 20);
        add(textname);
        textadress.setBounds(310, 80, 150, 20);
        add(textadress);
        textphone.setBounds(310, 110, 150, 20);
        add(textphone);
        textdate.setBounds(310, 140, 150, 20);
        add(textdate);

        JButton back = new JButton("BACK");

        Class.forName("com.mysql.jdbc.Driver");
        String log = "f";
        String pass = "a";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krustykrab?useTimezone=true&serverTimezone=UTC", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT Food_Name FROM krustykrab.menu");
        String[] m = new String[10];
        int i = 0;
        while (resultSet.next()) {
            m[i] = resultSet.getString(1);
            i++;
        }

        String[] title = {"id", "Name", "Price"};
        comboBoxFood = new JComboBox(m);
        comboBoxFood.setBounds(270, 170, 200, 30);
        add(comboBoxFood);

        addbutton.setBounds(370, 210, 70, 30);
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krustykrab?useTimezone=true&serverTimezone=UTC", "root", "root");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement(
                            "INSERT INTO krustykrab.orders(id,Full_Name, Food, Address, Phone, Date )"
                                    + "VALUES(NULL,? , ?, ?, ?, ? ) ");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String food = (String) comboBoxFood.getSelectedItem();
                String name = textname.getText();
                String address = textadress.getText();
                String phone = textphone.getText();
                String date = textdate.getText();
                try {
                    preparedStatement.setString(1, name);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    preparedStatement.setString(2, food);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    preparedStatement.setString(3, address);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    preparedStatement.setString(4, phone);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    preparedStatement.setString(5, date);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    preparedStatement.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        });
        add(addbutton);

        back.setBounds(370, 250, 70, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserGUI userGUI = new UserGUI();
                userGUI.setVisible(true);
                setVisible(false);
            }
        });
        add(back);
        im.setBounds(0, 0, 500, 300);
        add(im);
        ImageIcon image = new ImageIcon("C:\\Users\\Диана\\untitled3\\src\\com\\company\\6.jpg");
        im.setIcon(image);
        add(im);

    }
}