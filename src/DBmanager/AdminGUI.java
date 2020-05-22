package DBmanager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class AdminGUI extends JFrame {
    JLabel im = new JLabel("");
    JLabel helloLabel = new JLabel("What would you like to see?");
    JButton add=new JButton("Add");
    JButton basket =new JButton("Update");
    JButton delete =new JButton("Delete");
    JButton back=new JButton("Back");
    public AdminGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150,100,415,200);
        setLayout(null);
        setTitle("AdminGUI");


        helloLabel.setBounds(120, 20, 400, 20);

        add(helloLabel);
        add.setBounds(60,60,70,30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddGUI addGUI= null;
                try {
                    addGUI = new AddGUI();
                    addGUI.setVisible(true);
                    setVisible(false);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        add(add);
        delete.setBounds(280, 60, 100, 30);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete delete= null;
                try {
                    delete = new Delete();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                delete.setVisible(true);
                setVisible(false);
            }
        });
        add(delete);
        basket.setBounds(155, 60, 100, 30);
        basket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateGUI updateGUI= null;
                try {
                    updateGUI = new UpdateGUI();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                updateGUI.setVisible(true);
                setVisible(false);
            }
        });
        add(basket);
        back.setBounds(170, 100, 70, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI=new LoginGUI();
                loginGUI.setVisible(true);
                setVisible(false);
            }
        });
        add(back);

        im.setBounds(0,0,400,200);
        add(im);
        ImageIcon image = new ImageIcon("C:\\Users\\Диана\\untitled3\\src\\com\\company\\4.jpg");
        im.setIcon(image);
        add(im);
    }

}
