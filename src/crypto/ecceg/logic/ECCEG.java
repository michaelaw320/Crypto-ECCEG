/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.logic;

import crypto.ecceg.utils.Utils;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class ECCEG {
    BigInteger privateKey,prime;
    EllipticalCurve.Point publicKey;
    EllipticalCurve ecc;
    BigInteger kstatic=new BigInteger("1000");

    public ECCEG(BigInteger prime){
        this.prime=prime;
        this.ecc=new EllipticalCurve(prime);
        ecc.eccEquation= EllipticalCurve.P192.equation;
    }

//    public void generatePublicPrivateKeys(){
//        kA= Utils.generateK(EllipticalCurve.P192.Prime); //private kA
//        publicKey= ecc.coefMultiply(kA,EllipticalCurve.P192.basePoint);
//    }


    private EllipticalCurve.Point encodeMessage(BigInteger input){
        boolean found=false;
        BigInteger satu=new BigInteger("1");
        BigInteger dua=new BigInteger("2");
        BigInteger empat=new BigInteger("4");
        BigInteger y=null;
        while(!found){
            input=input.multiply(kstatic).add(satu).mod(prime);
            BigInteger a= input.pow(3).multiply(ecc.eccEquation[0]).
                    add(input.pow(2).multiply(ecc.eccEquation[1])).
                    add(input.multiply(ecc.eccEquation[2])).
                    add(input.multiply(ecc.eccEquation[3])).mod(prime);
            //Find Y
            if(a.modPow(prime.subtract(satu).divide(dua),prime).compareTo(satu)==0){//Ada solusi Y
                y=a.modPow(prime.add(satu).divide(empat),prime);
                found=true;
            }
        }
        return new EllipticalCurve.Point(input,y);
    }

    private BigInteger decodeMessage(EllipticalCurve.Point p, BigInteger k){
        return p.getX().subtract(new BigInteger("1")).divide(k);
    }

    public class CipherPair{
        EllipticalCurve.Point p1,p2;
        public CipherPair(EllipticalCurve.Point p1,EllipticalCurve.Point p2){this.p1=p1;this.p2=p2;}
        public EllipticalCurve.Point getP1(){return p1;}
        public EllipticalCurve.Point getP2(){return p2;}
    }

    public ArrayList<CipherPair> encrypt(ArrayList<BigInteger> messages) {
        ArrayList<CipherPair> result = new ArrayList<>();
        //Pilih suatu kb [0,P-1]
        privateKey=Utils.generateK(prime);
        publicKey= ecc.coefMultiply(privateKey,EllipticalCurve.P192.basePoint);
        System.out.println("private-key:"+privateKey+"\n"+"public-key:("+publicKey.getX()+","+publicKey.getY()+")");
        //convert each message to point
        for(BigInteger m : messages){
            BigInteger k=Utils.generateK(prime);
            EllipticalCurve.Point pm = encodeMessage(m);
            result.add(new CipherPair(ecc.coefMultiply(k,EllipticalCurve.P192.basePoint),ecc.add(pm,publicKey)));
        }
        return result;
    }
    
    public ArrayList<BigInteger> decrypt(ArrayList<CipherPair> cipher) {
//        BigInteger k=new BigInteger("20");
//        EllipticalCurve.Point p=new EllipticalCurve.Point(new BigInteger("201"),new BigInteger("228"));
//        BigInteger result=decodeMessage(p,k);
//        System.out.println(result);
        ArrayList<BigInteger> result=new ArrayList<>();
        for(CipherPair c:cipher){
            EllipticalCurve.Point bi=ecc.coefMultiply(privateKey,c.getP1());
            EllipticalCurve.Point m=ecc.substract(c.getP2(),bi);
            result.add(decodeMessage(m,kstatic).mod(prime));
        }
        return result;
    }

    
}
