package com.heptabargames.a7isEnough.QRcode;


import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

import java.io.*;

public class QRCodeGenerator {

    static void generateQRcode(String token, OutputStream outputStream) {

        // override image size to be 250x250
        QRCode.from(token).withSize(250, 250).stream();

        QRCode.from(token).withColor(0xFFFF0000, 0xFFFFFFAA).stream();

        // supply charset hint to ZXING
        QRCode.from(token).withCharset("UTF-8");

        // supply error correction level hint to ZXING
        QRCode.from(token).withErrorCorrection(ErrorCorrectionLevel.L);

        // supply any hint to ZXING
        QRCode.from(token).withHint(EncodeHintType.CHARACTER_SET, "UTF-8");

        // supply own outputstream
        QRCode.from(token).to(ImageType.PNG).writeTo(outputStream);

    }

    public static void main(String[] args) {
        try {
            FileOutputStream qrCodeFile = new FileOutputStream("test.png");

            generateQRcode("Test pour la librairie 1", qrCodeFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}



