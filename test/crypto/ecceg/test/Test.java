/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.test;
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
        testIO();
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
}
