package com.company;
import DBmanager.LoginGUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LoginGUI myfirst = new LoginGUI();
        myfirst.setVisible(true);

    }
}