package com.heptabargames.a7isEnough.QRcode;

import com.skrymer.qrbuilder.QRCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.skrymer.qrbuilder.decorator.ImageOverlay.*;
import static com.skrymer.qrbuilder.decorator.ColoredQRCode.colorizeQRCode;

public class CreateQRCode {

        public static final float TRANSPARENCY = 1f;
        public static final float OVERLAY_RATIO = 0.25f;
        public static final int WIDTH = 260;
        public static final int HEIGHT = 260;

        public static void main(String[] args) throws Exception {
            QRCode.ZXingBuilder.build(builder ->
                    builder.withSize(WIDTH, HEIGHT)
                            .and()
                            .withData("Il est née le divin enfant")
                            .and()
                            .withDecorator(colorizeQRCode(Color.blue.darker()))
                            .and()
                            .withDecorator(addImageOverlay(readImage("QRcode/src/main/resources/Logo_reduit.png"), TRANSPARENCY, OVERLAY_RATIO))
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
