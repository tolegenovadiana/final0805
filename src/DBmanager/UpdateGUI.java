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

public class UpdateGUI extends JFrame {
    JLabel textLabel = new JLabel("Update the Price");
    JLabel idLabel = new JLabel("Enter ID");
    JLabel priceLabel = new JLabel("Enter Price");
    JTextField textid = new JTextField();
    JTextField textprice = new JTextField();
    JButton addbutton = new JButton("Update");

    public UpdateGUI() throws ClassNotFoundException, SQLException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 340);
        setLayout(null);
        setTitle("UpdateGUI");

        JLabel im = new JLabel("");
        idLabel.setBounds(170, 150, 180, 20);
        add(idLabel);
        idLabel.setOpaque(true);
        idLabel.setBackground(Color.RED);
        idLabel.setForeground(Color.WHITE);

        priceLabel.setBounds(170, 180, 180, 20);
        add(priceLabel);
        priceLabel.setOpaque(true);
        priceLabel.setBackground(Color.RED);
        priceLabel.setForeground(Color.WHITE);

        textLabel.setBounds(170, 50, 150, 40);
        add(textLabel);
        textLabel.setOpaque(true);
        textLabel.setBackground(Color.RED);
        textLabel.setForeground(Color.WHITE);

        textid.setBounds(310, 150, 150, 20);
        add(textid);

        textprice.setBounds(310, 180, 150, 20);
        add(textprice);


        JButton back = new JButton("BACK");

        addbutton.setBounds(310, 210, 150, 30);
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
                            "UPDATE  krustykrab.menu SET price=? WHERE id=?");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String price = textprice.getText();
                String id = textid.getText();



                try {
                    preparedStatement.setString(1, price);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    preparedStatement.setString(2, id);
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

        back.setBounds(355, 250, 70, 30);
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

