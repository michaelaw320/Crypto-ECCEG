/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ecceg.logic;

import crypto.ecceg.utils.Utils;
import java.io.Serializable;

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
    private long timeTaken;

    public ECCEG(BigInteger prime){
        this.prime=prime;
        this.ecc=new EllipticalCurve(prime);
        ecc.eccEquation= EllipticalCurve.P192.equation;
    }
    public ECCEG(BigInteger prime, BigInteger _privateKey){
        this.prime=prime;
        this.ecc=new EllipticalCurve(prime);
        ecc.eccEquation= EllipticalCurve.P192.equation;
        privateKey = _privateKey;
    }
    public ECCEG(BigInteger prime, EllipticalCurve.Point _publicKey){
        this.prime=prime;
        this.ecc=new EllipticalCurve(prime);
        ecc.eccEquation= EllipticalCurve.P192.equation;
        publicKey = _publicKey;
    }
    
    public long getTimeTakenInMs() {
        return timeTaken;
    }

    public void generatePublicPrivateKeys(){
        privateKey=Utils.generateK(prime);
        publicKey= ecc.coefMultiply(privateKey,EllipticalCurve.P192.basePoint);
    }
    public BigInteger getPrivateKey() {
        return privateKey;
    }
    public EllipticalCurve.Point getPublicKey() {
        return publicKey;
    }

    private EllipticalCurve.Point encodeMessage(BigInteger input){
        boolean found=false;
        BigInteger satu=new BigInteger("1");
        BigInteger dua=new BigInteger("2");
        BigInteger empat=new BigInteger("4");
        BigInteger x=null,y=null,iterator;
        iterator=BigInteger.ZERO;
        while(!found){
            iterator=iterator.add(satu);
            x=input.multiply(kstatic).add(iterator).mod(prime);
            BigInteger a= x.pow(3).multiply(ecc.eccEquation[0]).
                    add(x.pow(2).multiply(ecc.eccEquation[1])).
                    add(x.multiply(ecc.eccEquation[2])).
                    add(ecc.eccEquation[3]).mod(prime);
            //System.out.println(ecc.eccEquation[0]+"x^3+"+ecc.eccEquation[1]+"x^2+"+ecc.eccEquation[2]+"x+"+ecc.eccEquation[3]);
            //Find Y
            if(a.modPow(prime.subtract(satu).divide(dua),prime).compareTo(satu)==0){//Ada solusi Y
                y=a.modPow(prime.add(satu).divide(empat),prime);
                found=true;
            }
        }
        return new EllipticalCurve.Point(x,y);
    }

    private BigInteger decodeMessage(EllipticalCurve.Point p, BigInteger k){
        return p.getX().subtract(new BigInteger("1")).divide(k);
    }

    public static class CipherPair implements Serializable{
        EllipticalCurve.Point p1,p2;
        public CipherPair(EllipticalCurve.Point p1,EllipticalCurve.Point p2){this.p1=p1;this.p2=p2;}
        public EllipticalCurve.Point getP1(){return p1;}
        public EllipticalCurve.Point getP2(){return p2;}
    }

    public ArrayList<CipherPair> encrypt(ArrayList<BigInteger> messages) {
        timeTaken = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<CipherPair> result = new ArrayList<>();
        //Pilih suatu kb [0,P-1]
        //privateKey=Utils.generateK(prime);
        //publicKey= ecc.coefMultiply(privateKey,EllipticalCurve.P192.basePoint);
        //System.out.println("private-key:"+privateKey+"\n"+"public-key:("+publicKey.getX()+","+publicKey.getY()+")");
        //convert each message to point
        System.out.println("Encrypted");
        for(BigInteger m : messages){
            BigInteger k=Utils.generateK(prime);
            EllipticalCurve.Point pm = encodeMessage(m);
            //System.out.println(m+"-->"+"("+pm.getX()+","+pm.getY()+")");
            result.add(new CipherPair(ecc.coefMultiply(k,EllipticalCurve.P192.basePoint),ecc.add(pm,ecc.coefMultiply(k,publicKey))));
        }
        long endTime = System.currentTimeMillis();
        timeTaken = endTime-startTime;
        return result;
    }
    
    public ArrayList<BigInteger> decrypt(ArrayList<CipherPair> cipher) {
//        BigInteger k=new BigInteger("20");
//        EllipticalCurve.Point p=new EllipticalCurve.Point(new BigInteger("201"),new BigInteger("228"));
//        BigInteger result=decodeMessage(p,k);
//        System.out.println(result);
        timeTaken = 0;
        long startTime = System.currentTimeMillis();
        ArrayList<BigInteger> result=new ArrayList<>();
        for(CipherPair c:cipher){
            EllipticalCurve.Point bi=ecc.coefMultiply(privateKey,c.getP1());
            EllipticalCurve.Point m=ecc.substract(c.getP2(),bi);
            //System.out.println("("+m.getX()+","+m.getY()+")");
            result.add(decodeMessage(m,kstatic).mod(prime));
        }
        long endTime = System.currentTimeMillis();
        timeTaken = endTime-startTime;
        return result;
    }

    
}
