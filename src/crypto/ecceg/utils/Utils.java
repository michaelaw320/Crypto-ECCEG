/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.utils;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Michael
 */
public class Utils {
    public static BigInteger generateK(BigInteger p) {
        boolean stop = false;
        BigInteger ret = null;
        while (!stop) {
            Random rnd = new Random();
            int len = rnd.nextInt(p.bitLength());
            len += 1;
            ret = new BigInteger(len, new Random());
            if (ret.compareTo(p) == -1 && ret.compareTo(BigInteger.ZERO) == 1) { // ret < p && ret > 0
                stop = true;
            }
        }
        return ret;
    }
    public static BigInteger generateP(int digit) {
        Random rnd = new Random();
        return BigInteger.probablePrime(digit*8, rnd);
    }
}
