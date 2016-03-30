/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
}
