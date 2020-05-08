package DBmanager;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class BasketGUI extends JFrame {
    JLabel label=new JLabel("Order is: ");
    JLabel price=new JLabel("Total sum is: ");
    JLabel nameLabel = new JLabel("Enter Your Name");
    JLabel datelabel = new JLabel("Enter Date of Order");
    JButton show=new JButton("Show");
    JTextField uname=new JTextField();
    JTextField date=new JTextField();
    JLabel im = new JLabel("");
    public BasketGUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,500,380);
        setLayout(null);
        setTitle("BasketGUI");
        JButton back=new JButton("Back");

        nameLabel.setBounds(50, 240, 100, 20);
        add(nameLabel);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(Color.RED);
        nameLabel.setForeground(Color.WHITE);

        datelabel.setBounds(50, 270, 120, 20);
        add(datelabel);
        datelabel.setOpaque(true);
        datelabel.setBackground(Color.RED);
        datelabel.setForeground(Color.WHITE);

        price.setBounds(300,270,100,20);
        add(price);
        price.setOpaque(true);
        price.setBackground(Color.RED);
        price.setForeground(Color.WHITE);


        label.setBounds(300,240,100,20);
        add(label);
        label.setOpaque(true);
        label.setBackground(Color.RED);
        label.setForeground(Color.WHITE);

        uname.setBounds(180,240,70,20);
        add(uname);
        date.setBounds(180,270,70,20);
        add(date);


        show.setBounds(180,300,70,30);
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                String log = "f";
                String pass = "a";
                String username=uname.getText();
                String userdate=date.getText();
                Connection connection = null;
                Connection connection1 = null;

                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/krustykrab?useTimezone=true&serverTimezone=UTC", "root", "root");
                    connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/krustykrab?useTimezone=true&serverTimezone=UTC", "root", "root");


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Statement statement = null;
                Statement statement1 = null;

                try {
                    statement = connection.createStatement();
                    statement1 = connection1.createStatement();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ResultSet resultSet = null;
                ResultSet resultSet1 = null;
                try {
                    resultSet = statement.executeQuery("SELECT Food  FROM krustykrab.orders WHERE Full_Name = '"+username+"' AND Date='"+userdate+"'   ");
                    resultSet1 = statement1.executeQuery("SELECT Price , Food_Name FROM krustykrab.menu ");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                String a="a";
                int id=0;
                ArrayList<String> list=new ArrayList<String>();
                while (true) {
                    try {
                        if (!resultSet.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        a = resultSet.getString(1);
                        list.add(id, a);
                        id++;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                label.setText(String.valueOf(list));
                int p = 0;
                while (true) {
                    String pr = "0";
                    String fn = "a";
                    try {
                        if (!resultSet1.next()) break;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    try {
                        pr = resultSet1.getString(1);
                        fn = resultSet1.getString(2);
                        for (int i = 0; i <list.size(); i++) {
                            if (list.get(i).equals(fn)) {
                                p =p+ Integer.parseInt(pr);
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                price.setText(String.valueOf(p));
            }
        });
        add(show);

        back.setBounds(315, 300, 70, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserGUI userGUI=new UserGUI();
                userGUI.setVisible(true);
                setVisible(false);
            }
        });
        add(back);

        im.setBounds(0,0,500,380);
        add(im);
        ImageIcon image = new ImageIcon("C:\\Users\\Диана\\untitled3\\src\\com\\company\\9.jpg");
        im.setIcon(image);
        add(im);
    }
}