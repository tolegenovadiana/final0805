package DBmanager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RegistrationGUI extends JFrame {
    JLabel im = new JLabel("");
    JLabel helloLabel = new JLabel("      First Time in Krusty Krab?");
    JLabel loginlabel = new JLabel("Enter Login");
    JLabel passwordlabel = new JLabel("Enter Password");
    JLabel repasswordlabel = new JLabel("Repeat Password");
    JLabel namelabel = new JLabel("Enter Name");
    JLabel rolelabel = new JLabel("Enter as ");

    JTextField textFieldlogin = new JTextField("");
    JTextField textFieldpassword = new JTextField("");
    JTextField textFieldrepassword=new JTextField();
    JTextField textFieldname = new JTextField("");
    JTextField textFieldrole = new JTextField("");
    JButton buttonreg = new JButton("Registration");
    JButton back=new JButton("BACK");

    public RegistrationGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,400,330);
        setLayout(null);
        setTitle("RegistrationGUI");
        helloLabel.setBounds(150,20,180,20);
        add(helloLabel);
        helloLabel.setOpaque(true);
        helloLabel.setBackground(Color.WHITE);
        helloLabel.setForeground(Color.BLACK);
        loginlabel.setBounds(80,50,180,20);
        add(loginlabel);
        passwordlabel.setBounds(80,80,180,20);
        add(passwordlabel);
        repasswordlabel.setBounds(80,110,180,20);
        add(repasswordlabel);
        namelabel.setBounds(80,140,180,20);
        add(namelabel);
        rolelabel.setBounds(80,170,180,20);
        add(rolelabel);

        textFieldlogin.setBounds(200,50,150,20);
        add(textFieldlogin);
        textFieldpassword.setBounds(200,80,150,20);
        add(textFieldpassword);
        textFieldrepassword.setBounds(200,110,150,20);
        add(textFieldrepassword);
        textFieldname.setBounds(200,140,150,20);
        add(textFieldname);
        textFieldrole.setBounds(200,170,150,20);
        add(textFieldrole);

        back.setBounds(240, 240, 70, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI=new LoginGUI();
                loginGUI.setVisible(true);
                setVisible(false);
            }
        });
        add(back);
        buttonreg.setBounds(200, 200, 150, 30);
        buttonreg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String login = textFieldlogin.getText();
                String password = textFieldpassword.getText();
                String name = textFieldname.getText();
                String repassword = textFieldrepassword.getText();
                String role=textFieldrole.getText();
                try {
                    if(password.compareTo(repassword)==0){
                        Database database = new Database();
                        database.newuser(login, password, name, role);
                        helloLabel.setText("You registered successfully");

                    }
                    else {
                        helloLabel.setText(" Try again");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        add(buttonreg);


        im.setBounds(0,0,500,330);
        add(im);
        ImageIcon image = new ImageIcon("C:\\Users\\Диана\\untitled3\\src\\com\\company\\4.jpg");
        im.setIcon(image);
        add(im);
    }
}
