package com.heptabargames.a7isEnough.QRcode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class QrCode {
    private JButton generateButton;
    private JButton saveInButton;
    private JTextArea generateQrCodeAndSaveTextArea;


    public QrCode() {

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateQRCode.generateQRcode();
            }
        });
        saveInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("qrCode.png");
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    fileChooser.setSelectedFile(file);
                    // save to file
                }
            }



        });

    }
}
