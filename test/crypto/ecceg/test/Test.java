/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.test;
import crypto.ecceg.logic.EllipticalCurve;
import crypto.ecceg.utils.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testIO();
        EllipticalCurve.Point p=new EllipticalCurve.Point(new BigInteger("5"),new BigInteger("7"));
        EllipticalCurve ecc=new EllipticalCurve(new BigInteger("29"));
        EllipticalCurve.Point result=ecc.coefMultiply(new BigInteger("2"),p);
        System.out.println("("+result.getX()+","+result.getY()+")");
    }
    
    public static void testIO() {
        String filepath = "C:\\Users\\Michael\\Documents\\GitHub\\Crypto-ECCEG\\testfile.mkv";
        String outputPath = "C:\\Users\\Michael\\Documents\\GitHub\\Crypto-ECCEG\\testfile2.mkv";
        BigInteger data;
        try {
            data = IOUtils.getData(filepath);
            //System.out.println(data.toString(16));
            BigInteger kali = new BigInteger("32156546876354687435746876543138576546354313854354");
            data = data.multiply(kali);
            IOUtils.writeData(outputPath, data);
            data = data.divide(kali);
            IOUtils.writeData(outputPath+"x", data);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testUtils() {
        int digit = 2;
        BigInteger res = Utils.generateP(2);
        System.out.println(res.toString(16));
        BigInteger ran = Utils.generateK(res);
        System.out.println(ran.toString(16));
    }
}
