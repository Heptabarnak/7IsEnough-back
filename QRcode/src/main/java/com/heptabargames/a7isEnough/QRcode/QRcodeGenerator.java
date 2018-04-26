package com.heptabargames.a7isEnough.QRcode;


import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.glxn.qrgen.android.QRCode;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.core.scheme.Url;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QRcodeGenerator {

    static void GenerateQRcode(String Token) {

        // override image size to be 250x250
        //QRCode.from(Token).withSize(250, 250).stream();

        //QRCode.from(Token).withColor(0xFFFF0000, 0xFFFFFFAA).stream();

        // supply charset hint to ZXING
        //QRCode.from(Token).withCharset("UTF-8");

        // supply error correction level hint to ZXING
        //QRCode.from(Token).withErrorCorrection(ErrorCorrectionLevel.L);

        // supply any hint to ZXING
        //QRCode.from(Token).withHint(EncodeHintType.CHARACTER_SET, "UTF-8");

        //initialize outputstream
        //OutputStream outputStream = null;

        QRCode.from("Hello World").file("QRCodeTest");


        // supply own outputstream
        //QRCode.from("Hello World").to(ImageType.PNG).writeTo(outputStream);

        //return outputStream;
    }

    public static void main(String[] args){

        GenerateQRcode("Coucou");
    }
}



