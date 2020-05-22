package com.company;
import DBmanager.Client;
import DBmanager.LoginGUI;
import java.io.IOException;
import java.sql.Connection;

import static javax.imageio.ImageIO.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Connection connection = null;
        Thread myThready = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                System.out.println("Hello!");
                LoginGUI myfirst = new LoginGUI();
                myfirst.setVisible(true);
            }
        });

        myThready.start();	//Запуск потока

        System.out.println("Main Thread is completed...");

    }
    }
