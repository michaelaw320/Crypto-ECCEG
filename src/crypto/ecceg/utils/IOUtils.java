/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.utils;

import crypto.ecceg.logic.ECCEG;
import crypto.ecceg.logic.EllipticalCurve;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Michael
 * Only used in Input/Output tools (Read file, write file, etc.)
 */
public class IOUtils {
    
    public static String getStringData(String address) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(address));
        return new String(encoded, Charset.defaultCharset());
    }
    
    public static long getFilesize(String address) throws IOException {
        File file = new File(address);
        if (file.exists()) {
            return file.length();
        } else {
            return 0;
        }
    }
    
    public static BigInteger getData(String address) throws IOException {
        Path path = Paths.get(address);
        byte[] data = Files.readAllBytes(path);
        return new BigInteger(data);
    }
    
    public static ArrayList<BigInteger> getDataArray(String address) throws IOException {
        ArrayList<BigInteger> ret = new ArrayList<>();
        Path path = Paths.get(address);
        byte[] data = Files.readAllBytes(path);
        byte[][] matData = transformToTwoD(data, 16);
        for (byte[] matData1 : matData) {
            ret.add(new BigInteger(matData1));
        }
        return ret;
    }
    
    private static byte[][] transformToTwoD(byte[] oneD, int width) {
        int len = oneD.length;
        int height = (len/width) + 1;
        byte[][] ret = new byte[height][width];
        int count=0;
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                if(count==oneD.length) break;
                ret[i][j]=oneD[count];
                count++;
            }
        }
        return ret;
    }
    
    public static void writeData(String address, BigInteger toWrite) throws IOException {
        Path path = Paths.get(address);
        byte[] data = toWrite.toByteArray();
        Files.write(path, data);
    }
    
    public static void writeDataFromList(String address, ArrayList<BigInteger> toWrite) throws IOException {
        ArrayList<Byte[]> data = new ArrayList<>();
        for(BigInteger bi : toWrite) {
            byte[] byteArr = bi.toByteArray();
            Byte[] ByteArr = new Byte[byteArr.length];
            for(int i = 0; i < byteArr.length; i++) ByteArr[i] = byteArr[i];
            data.add(ByteArr);
        }
        int lastElLen = 0;
        for(lastElLen = 0; lastElLen < data.get(data.size()-1).length; lastElLen++) {
            if (data.get(data.size()-1)[lastElLen] == 0) {
                break;
            }
        }
        byte[] combinedArr = new byte[((data.size()-1) * data.get(0).length) + lastElLen];
        int j = 0;
        for(Byte[] arr : data) {
            for (Byte arrEl : arr) {
                combinedArr[j] = arrEl;
                j++;
                if (j == combinedArr.length) break;
            }
        }
        BigInteger combined = new BigInteger(combinedArr);
        writeData(address, combined);
    }
    
    public static String formattedOutput(BigInteger data) {
        String str = data.toString(16);
        str = str.replaceAll("(.{64})", "$1\n");
        str = str.replaceAll("..(?=.)", "$0 ");
        return str;
    }
    
    public static void writeCipherFile(String address, ArrayList<ECCEG.CipherPair> toWrite) throws IOException {
        /*PrintWriter pw = new PrintWriter(new FileWriter(address));
        for(ECCEG.CipherPair pairpoint:toWrite){
            EllipticalCurve.Point p1=pairpoint.getP1();
            EllipticalCurve.Point p2=pairpoint.getP2();
            pw.write(p1.getX().toString()+","+p1.getY().toString()+";"+p2.getX().toString()+","+p2.getY().toString()+"\n");
        }
        pw.close();*/
        FileOutputStream fos = new FileOutputStream(address);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(toWrite);
    }
    
    public static ArrayList<ECCEG.CipherPair> readCipherFile(String address) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(address);
        ObjectInputStream in = new ObjectInputStream(fis);
        return (ArrayList<ECCEG.CipherPair>) in.readObject();
        /*BufferedReader br = new BufferedReader(new FileReader(new File(address)));
        ArrayList<ECCEG.CipherPair> ret = new ArrayList<>();
	String line = null;
	while ((line = br.readLine()) != null) {
		System.out.println(line);
                String[] split1 = line.split(";");
                String[] splitPoint1 = split1[0].split(",");
                String[] splitPoint2 = split1[0].split(",");
                EllipticalCurve.Point tPoint1 = new EllipticalCurve.Point(new BigInteger(splitPoint1[0]), new BigInteger(splitPoint1[1]));
                EllipticalCurve.Point tPoint2 = new EllipticalCurve.Point(new BigInteger(splitPoint2[0]), new BigInteger(splitPoint2[1]));
                ECCEG.CipherPair temp = new ECCEG.CipherPair(tPoint1, tPoint2);
                ret.add(temp);
	}
	br.close();
        return ret;*/
    }
}
