package org.framework.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QR_Coder {
	private static final int FRONTCOLOR = 0xFFFF0000; //二维码图形的颜色
	private static final int BLACKCOLOR = 0xFFFFFFFF; //背景色
	//0xFF0000FF  蓝色
	//0xFF000000     白色 
	//0xFFFF0000     红色 
	private QR_Coder() {}
	
	//这个方法是给二维码图形添加相同的颜色，可以改里面的代码，实现你想要的效果
		public static BufferedImage toBufferedImage(BitMatrix matrix){
			int width = matrix.getWidth();
			int height = matrix.getHeight();
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
			for (int x = 0; x < width; x++) { 
				for (int y = 0; y < height; y++) { 
					image.setRGB(x, y, matrix.get(x, y) ? FRONTCOLOR : BLACKCOLOR); 
				}
			}
			return image;
		}

		public static void writeToFile(BitMatrix matrix, String format, File file)throws IOException { 
			BufferedImage image = toBufferedImage(matrix); 
			if (!ImageIO.write(image, format, file)) { 
				throw new IOException("Could not write an image of format " + format + " to " + file); 
			} 
		}
	/**
	 * 编码
	 * 
	 * @param contents
	 * @param width
	 * @param height
	 * @param imgPath
	 */
	public void encode(String contents, int width, int height, String imgPath) {
		Hashtable<Object, Object> hints = new Hashtable<Object, Object>();
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		// 指定编码格式
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(new String(contents.getBytes("UTF-8"), "ISO-8859-1"), BarcodeFormat.QR_CODE, width, height);
			QR_Coder.writeToFile(bitMatrix, "png", new File(imgPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /**
	  * 解码
	  * 
     * @param  imgPath   
     * @return String   
     */    
    public String decode(String imgPath) {   
        BufferedImage image = null ;   
        Result result = null ;   
        try  {   
            image = ImageIO.read(new  File(imgPath));   
            if  (image ==  null ) {   
                System.out.println("the decode image may be not exit." );   
            }   
            LuminanceSource source = new  BufferedImageLuminanceSource(image);   
            BinaryBitmap bitmap = new  BinaryBitmap( new  HybridBinarizer(source));   
            Hashtable<Object, Object> hints = new  Hashtable<Object, Object>();   
            hints.put(DecodeHintType.CHARACTER_SET, "utf-8" );   
            result = new  MultiFormatReader().decode(bitmap);   
            return  result.getText();   
        } catch  (Exception e) {   
            e.printStackTrace();   
        }   
        return   null ;   
    } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String imgPath = "C:\\Users\\ly\\Desktop\\aa.png";
		String contents = 
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"Hello Michael(大大),welcome to Zxing!" +
		"\nWeb [ http://sjsky.iteye.com ]" +
		"\nEMail [ sjsky007@gmail.com ]" + 
		"\nTwitter [ @suncto ]";
		int width = 300, height = 300;
		QR_Coder handler = new QR_Coder();
		handler.encode(contents, width, height, imgPath);
		System.out.println("生成完成。。。。。。");
		
		
        String decodeContent = handler.decode("c:\\qrcode.png");   
        System.out.println("解码内容如下：" );   
        System.out.println(decodeContent);   
        System.out.println("解码完成。。。。。。" );  
	}
}