/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.test;
import crypto.ecceg.logic.ECCEG;
import crypto.ecceg.logic.EllipticalCurve;
import crypto.ecceg.utils.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
        System.out.println("Plain");
        ArrayList<BigInteger> messages=testArrayInput();
        System.out.println("=======================");
        ECCEG elgamal=new ECCEG(EllipticalCurve.P192.Prime);
        ArrayList<ECCEG.CipherPair> result=elgamal.encrypt(messages);
        for(ECCEG.CipherPair pairpoint:result){
            EllipticalCurve.Point p1=pairpoint.getP1();
            EllipticalCurve.Point p2=pairpoint.getP2();
            System.out.println("[("+p1.getX()+","+p1.getY()+")"+", ("+p2.getX()+","+p2.getY()+")]");
        }
        System.out.println("Decrypt-print plain text");
        List<BigInteger> plain=elgamal.decrypt(result);
        for(BigInteger pm:plain){
            System.out.println(pm);
        }
//        EllipticalCurve.Point p1=new EllipticalCurve.Point(new BigInteger("22"),new BigInteger("17"));
//        EllipticalCurve.Point p2=new EllipticalCurve.Point(new BigInteger("14"),new BigInteger("7"));
//        EllipticalCurve elgamal=new EllipticalCurve(new BigInteger("29"));
//        EllipticalCurve.Point res=elgamal.substract(p1,p2);
//        System.out.println("("+res.getX()+","+res.getY()+")");
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
    
    public static ArrayList<BigInteger> testArrayInput() {
        ArrayList<BigInteger> result=new ArrayList<>();
        String filepath = "testfile.txt";
        ArrayList<BigInteger> data;
        try {
            data = IOUtils.getDataArray(filepath);
            //System.out.println(data.toString(16));
            for(BigInteger bi : data) {
                result.add(bi);
                System.out.println(bi);
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
