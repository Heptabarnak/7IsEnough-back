package com.heptabargames.a7isEnough.QRcode;


import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.image.ImageType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QRcodeGenerator {


    File file = QRCode.from("Hello World").file();
    // get QR stream from text using defaults
    ByteArrayOutputStream stream = QRCode.from("Hello World").stream();

    static OutputStream GenerateQRcode() {
        // override the image type to be JPG
        QRCode.from("Hello World").to(ImageType.JPG).file();
        QRCode.from("Hello World").to(ImageType.JPG).stream();

        // override image size to be 250x250
        QRCode.from("Hello World").withSize(250, 250).file();
        QRCode.from("Hello World").withSize(250, 250).stream();

        QRCode.from("Hello World").withColor(0xFFFF0000, 0xFFFFFFAA).file();

        // supply own file name
        QRCode.from("Hello World").file("QRCode");

        // supply charset hint to ZXING
        QRCode.from("Hello World").withCharset("UTF-8");

// supply error correction level hint to ZXING
        QRCode.from("Hello World").withErrorCorrection(ErrorCorrectionLevel.L);

// supply any hint to ZXING
        QRCode.from("Hello World").withHint(EncodeHintType.CHARACTER_SET, "UTF-8");

        OutputStream outputStream = null;

        // supply own outputstream
        QRCode.from("Hello World").to(ImageType.PNG).writeTo(outputStream);

        return outputStream;
    }
}



