package com.heptabargames.a7isEnough.QRcode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanelTest extends JPanel {
    private BufferedImage image;

    public ImagePanelTest() throws IOException {
        image = ImageIO.read(new File("qrCode.png"));
    }
    protected void paintComponent(Graphics g, JButton jButton) {
       // jButton.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
    }
