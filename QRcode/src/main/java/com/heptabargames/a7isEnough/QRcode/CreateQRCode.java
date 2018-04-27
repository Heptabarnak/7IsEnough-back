package com.heptabargames.a7isEnough.QRcode;

import com.skrymer.qrbuilder.QRCode;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static com.skrymer.qrbuilder.decorator.ImageOverlay.*;
import static com.skrymer.qrbuilder.decorator.ColoredQRCode.colorizeQRCode;

public class CreateQRCode {

        public static final float TRANSPARENCY = 1f;
        public static final float OVERLAY_RATIO = 0.25f;
        public static final int WIDTH = 260;
        public static final int HEIGHT = 260;

        public static String GenerateToken() throws NoSuchAlgorithmException, UnsupportedEncodingException {
            byte[] bytes = new byte[20];
            SecureRandom.getInstanceStrong().nextBytes(bytes);
            String password = new String(bytes, "UTF-8");
            String hash;

            Argon2 argon2 = Argon2Factory.create();
            try {
                // Hash password
                hash = argon2.hash(2, 65536, 1, password);

                // Verify password
                if (argon2.verify(hash, password)) {
                    // Hash matches password
                } else {
                    // Hash doesn't match password
                }
            } finally {
                // Wipe confidential data
                argon2.wipeArray(password.toCharArray());
            }
            return hash;

        }


        public static void main(String[] args) throws Exception {
            QRCode.ZXingBuilder.build(builder ->
                    builder.withSize(WIDTH, HEIGHT)
                            .and()
                            .withData("Il est née le divin enfant")
                            .and()
                            .withDecorator(colorizeQRCode(Color.black.darker()))
                            .and()
                            .withDecorator(addImageOverlay(readImage("QRcode/src/main/resources/Logo_seul_blanc.png"), TRANSPARENCY, OVERLAY_RATIO))
                            .and()
                            .verify(true)

            ).toFile("./qrCode.png", "PNG");
        }

        public static BufferedImage readImage(String path) {
            try {
                return ImageIO.read(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
