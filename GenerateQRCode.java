package demooo;

import java.io.File;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  
public class GenerateQRCode  
{  
//static function that creates QR Code  
public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException  
{  
//the BitMatrix class represents the 2D matrix of bits  
//MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.  
BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);  
MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));  
}  
//main() method  
public static void main(String args[]) throws WriterException, IOException, NotFoundException  
{  
//data that we want to store in the QR code  
//String str= "https://unsplash.com/photos/K754CADul_A";
	//String str="https://ipfs.io/ipfs/QmU7YMxFUv6bsD7EmF8HvNm9C82pP7NW4mmjeSfpgMr5Tm";
	String str="https://www.etsist.upm.es/estudios-ingenieria-sistemas-telecomunicaciones-madrid/masters-ingenieria-madrid/mwc";
//path where we want to get QR Code  
String path = "C:\\Users\\j\\Documents\\Paperback Writer\\QR.jpg";  
//Encoding charset to be used  
String charset = "UTF-8";  
Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
//generates QR code with Low level(L) error correction capability  
hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
//invoking the user-defined method that creates the QR code 
generateQRcode(str, path, charset, hashMap, 400, 400);//increase or decrease height and width accodingly   
//prints if the QR code is generated   
System.out.println("QR Code created successfully.");  
}  
}  
