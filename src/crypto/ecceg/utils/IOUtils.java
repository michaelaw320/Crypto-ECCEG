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
        int len = data.length;
        int padding = 8 - len%8;
        for(int i = 0; i < len; i+=8) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < 8 && (i+j < len); j++) {
                sb.append(data[i+j]);
            }
            ret.add(new BigInteger(sb.toString()));
        }
//        if(padding != 0 && padding != 8) {
//            BigInteger lastInt = ret.get(ret.size()-1);
//            ret.remove(ret.size()-1);
//            String lastStr = lastInt.toString();
//            StringBuilder sb = new StringBuilder(lastStr);
//            for(int i = len; i < len+padding; i++) {
//                sb.append("00");
//            }
//            ret.add(new BigInteger(sb.toString()));
//        }
        return ret;
    }
    
    public static void writeData(String address, BigInteger toWrite) throws IOException {
        Path path = Paths.get(address);
        byte[] data = toWrite.toByteArray();
        Files.write(path, data);
    }
    
    public static String formattedOutput(BigInteger data) {
        String str = data.toString(16);
        str = str.replaceAll("(.{64})", "$1\n");
        str = str.replaceAll("..(?=.)", "$0 ");
        return str;
    }
}
