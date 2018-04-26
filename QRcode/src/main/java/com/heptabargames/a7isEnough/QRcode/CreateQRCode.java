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

        public static final float TRANSPARENCY = 0.25f;
        public static final float OVERLAY_RATIO = 1f;
        public static final int WIDTH = 250;
        public static final int HEIGHT = 250;

        public static void main(String[] args) throws Exception {
            QRCode.ZXingBuilder.build(builder ->
                    builder.withSize(WIDTH, HEIGHT)
                            .and()
                            .withData("Il est née le divin enfant")
                            .and()
                            .withDecorator(colorizeQRCode(Color.blue.darker()))
                            .and()
                            .withDecorator(addImageOverlay(readImage("7isEnough/QRcode/src/main/resources/skull.png"), TRANSPARENCY, OVERLAY_RATIO))

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
