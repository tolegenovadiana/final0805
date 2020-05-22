package DBmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddGUI extends JFrame {

        JLabel nameLabel = new JLabel("Enter Food_Name");
        JLabel pricelabel = new JLabel("Price");
        JTextField textname = new JTextField();
        JTextField textprice = new JTextField();

        JButton addbutton = new JButton("ADD");


        public AddGUI() throws ClassNotFoundException, SQLException, IOException {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 500, 340);
            setLayout(null);
            setTitle("MenuGUI");

            JLabel im = new JLabel("");
            nameLabel.setBounds(170, 50, 180, 20);
            add(nameLabel);
            nameLabel.setOpaque(true);
            nameLabel.setBackground(Color.RED);
            nameLabel.setForeground(Color.WHITE);
            pricelabel.setBounds(170, 80, 180, 20);
            add(pricelabel);
            pricelabel.setOpaque(true);
            pricelabel.setBackground(Color.RED);
            pricelabel.setForeground(Color.WHITE);


            textname.setBounds(310, 50, 150, 20);
            add(textname);
            textprice.setBounds(310, 80, 150, 20);
            add(textprice);

            JButton back = new JButton("BACK");

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
                                "INSERT INTO krustykrab.menu(id,Food_Name, Price )"
                                        + "VALUES(NULL,? , ?) ");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    String name = textname.getText();
                    String price = textprice.getText();

                    try {
                        preparedStatement.setString(1, name);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        preparedStatement.setString(2, price);
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
                    AdminGUI adminGUI = new AdminGUI();
                    adminGUI.setVisible(true);
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

