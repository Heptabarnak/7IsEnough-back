package com.heptabargames.a7isEnough.QRcode;

import com.skrymer.qrbuilder.QRCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import static com.skrymer.qrbuilder.decorator.ColoredQRCode.colorizeQRCode;
import static com.skrymer.qrbuilder.decorator.ImageOverlay.addImageOverlay;

public class CreateQRCode {

    private static final float TRANSPARENCY = 1f;
    private static final float OVERLAY_RATIO = 0.25f;
    private static final int WIDTH = 260;
    private static final int HEIGHT = 260;

    private static String GenerateToken() throws NoSuchAlgorithmException {
        byte[] bytes = new byte[60];
        SecureRandom.getInstanceStrong().nextBytes(bytes);
        String token = Base64.getEncoder().encodeToString(bytes);
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = md.digest(token.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : hashBytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            hash = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        generateImage(token);
        return hash;

    }

    public static void generateImage(String token) {
        QRCode.ZXingBuilder.build(builder ->
                builder.withSize(WIDTH, HEIGHT)
                        .and()
                        .withData(token)
                        .and()
                        .withDecorator(colorizeQRCode(Color.magenta.darker()))
                        .and()
                        .withDecorator(addImageOverlay(readImage("QRcode/src/main/resources/Logo_seul(1).png"), TRANSPARENCY, OVERLAY_RATIO))
                        .and()
                        .verify(true)

        ).toFile("./qrCode.png", "PNG");
    }


    public static String generateQRCode() {
        try {
            return GenerateToken();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedImage readImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
