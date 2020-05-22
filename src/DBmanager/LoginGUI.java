package DBmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginGUI extends JFrame {

    JLabel helloLabel = new JLabel("Authorization");
    JLabel loginlabel = new JLabel("Enter Login");
    JLabel passwordlabel = new JLabel("Enter Password");
    JLabel reglabel = new JLabel("If you do not have account ---->");
    JTextField textFieldlogin = new JTextField("");
    JButton buttonlogin = new JButton("Log In");
    JTextField textFieldpassword = new JTextField("");
    JButton buttonreg = new JButton("Registration");
    JLabel im = new JLabel("");

    public LoginGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 405, 270);
        setLayout(null);
        setTitle("LoginGUI");
        helloLabel.setBounds(150, 20, 180, 20);
        add(helloLabel);
        helloLabel.setOpaque(true);
        helloLabel.setBackground(Color.BLUE);
        helloLabel.setForeground(Color.WHITE);
        loginlabel.setBounds(100, 50, 180, 20);
        add(loginlabel);
        loginlabel.setForeground(Color.WHITE);
        loginlabel.setOpaque(true);
        loginlabel.setBackground(Color.BLUE);
        passwordlabel.setBounds(100, 80, 180, 20);
        add(passwordlabel);
        passwordlabel.setForeground(Color.WHITE);
        passwordlabel.setOpaque(true);
        passwordlabel.setBackground(Color.BLUE);
        reglabel.setBounds(20, 175, 180, 20);
        add(reglabel);
        reglabel.setForeground(Color.WHITE);
        reglabel.setOpaque(true);
        reglabel.setBackground(Color.BLUE);
        textFieldlogin.setBounds(200, 50, 150, 20);
        add(textFieldlogin);

        textFieldpassword.setBounds(200, 80, 150, 20);
        add(textFieldpassword);

        buttonreg.setBounds(200, 170, 150, 30);
        buttonreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RegistrationGUI registrationGUI = new RegistrationGUI();
                    registrationGUI.setVisible(true);
                    setVisible(false);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        add(buttonreg);

        buttonlogin.setBounds(280, 120, 70, 30);
        buttonlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String login=textFieldlogin.getText();
                String password=textFieldpassword.getText();
                try {
                    Database database=new Database();
                    if(login.compareTo("Admin")==0 && database.login(login,password)==1){

                        helloLabel.setText("You are logged in");
                        AdminGUI adminGUI=new AdminGUI();
                        adminGUI.setVisible(true);
                        setVisible(false);
                    }
                    else if( database.login(login,password)==1){

                        helloLabel.setText("You are logged in");
                        UserGUI userGUI=new UserGUI();
                        userGUI.setVisible(true);
                        setVisible(false);
                    }

                    else{
                        helloLabel.setText("You are not logged in");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        add(buttonlogin);
        im.setBounds(-10,0,400,250);
        add(im);
        ImageIcon image = new ImageIcon("C:\\Users\\Диана\\untitled3\\src\\com\\company\\3.png");
        im.setIcon(image);
        add(im);
    }

}