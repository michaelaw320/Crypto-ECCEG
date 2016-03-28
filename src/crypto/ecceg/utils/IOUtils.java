/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Michael
 * Only used in Input/Output tools (Read file, write file, etc.)
 */
public class IOUtils {
    
    public IOUtils() {

    }
    
    public BigInteger getData(String address) throws IOException {
        Path path = Paths.get(address);
        byte[] data = Files.readAllBytes(path);
        return new BigInteger(data);
    }
    
    public void writeData(String address, BigInteger toWrite) throws IOException {
        Path path = Paths.get(address);
        byte[] data = toWrite.toByteArray();
        Files.write(path, data);
    }
}
