package com.wjc.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ReadQRCode {

	public static void main(String[] args) {
		try {
			MultiFormatReader formatReader = new MultiFormatReader();
			File file = new File("E:/eclipse/workspace/zxing/src/erweima");
			BufferedImage image = ImageIO.read(file);
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

			// 定义二维码的参数
			HashMap hints = new HashMap();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符集编码
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 修正等级
			hints.put(EncodeHintType.MARGIN, 2);// 边距
			Result result = formatReader.decode(binaryBitmap, hints);
			
			System.out.println("解析结果"+result.toString());
			System.out.println("二维码格式"+result.getBarcodeFormat());
			System.out.println("二维码格式"+result.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
