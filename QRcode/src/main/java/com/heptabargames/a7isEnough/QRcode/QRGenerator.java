package com.heptabargames.a7isEnough.QRcode;

import com.sun.javafx.iio.ImageStorage;
import net.glxn.qrgen.core.image.ImageType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

public class QRGenerator extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton generateButton;
    private BufferedImage image;

    public QRGenerator() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String nomFichier = fileChooser.getSelectedFile().toString();
                    if (!nomFichier.endsWith(".png")){
                        nomFichier = nomFichier + ".png";
                    }
                    File file = new File(nomFichier);
                    System.out.println(nomFichier);
                    try {
                        BufferedImage image = ImageIO.read(new File("qrCode.png"));
                        ImageIO.write(image,"PNG", file);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String hash =  CreateQRCode.generateQRcode();
            contentPane.setLayout(new FlowLayout());
            JLabel label = new JLabel(hash);
            contentPane.add(label);
            contentPane.updateUI();
                /*try {
                    ImagePanelTest image2 = new ImagePanelTest();
                    image2.paintComponent(image2.getGraphics());
                    } catch (IOException e2) {
                    e2.printStackTrace();
                }*/
            }


        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        QRGenerator dialog = new QRGenerator();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
