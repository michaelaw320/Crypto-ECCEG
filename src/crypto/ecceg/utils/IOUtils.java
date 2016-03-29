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
