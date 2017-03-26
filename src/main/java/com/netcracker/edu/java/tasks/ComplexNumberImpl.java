package com.netcracker.edu.java.tasks;

import java.util.Arrays;

/**
 * Created by Антон on 25.03.2017.
 */
public class ComplexNumberImpl implements ComplexNumber
{
    private double realPart;
    private double imaginaryPart;
ComplexNumberImpl(){
    realPart = 0;
    imaginaryPart =0;
}
    @Override
    public double getRe() {
        return realPart;
    }

    @Override
    public double getIm() {
        return imaginaryPart;
    }

    @Override
    public boolean isReal() {
    if (imaginaryPart==0) return true;
        return false;
    }

    @Override
    public void set(double re, double im) {
    realPart = re;
    imaginaryPart = im;

    }

    @Override
    public void set(String value) throws NumberFormatException {
        String real = "";
        String im = "";
        String buf = "";
        boolean flag = false;
    for (int i=0; i<value.length();i++)
    {

        char c = value.charAt(i);
        if (c=='+' || c=='-')
        {
            if (flag==true || !(value.charAt(0)=='+' || value.charAt(0)=='-'))
            {
                real = real.concat(buf);
                buf="";
            }
            flag=true;
        }
            if (c=='i')
            {
                if (value.length()==1) buf="1";
                else
                if (buf.length()==0 || value.charAt(i-1)=='+') buf="1";
                else if ((buf.length()==0 || value.charAt(i-1)=='-')) buf="-1";
                im = im.concat(buf);
                buf="";
            }
            buf+=c;
    }
    if (!(buf.equals("+")||buf.equals("-")||buf.equals("i")))real = real.concat(buf);
        if (value == "") throw  new NumberFormatException();
       if (real.length()==0) realPart=0; else realPart = Double.parseDouble(real);
       if (im.length()==0) imaginaryPart=0; else imaginaryPart = Double.parseDouble(im);
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumberImpl copyObj = new ComplexNumberImpl();
        copyObj.set(realPart,imaginaryPart);
        return copyObj;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        try {
            return (ComplexNumber)super.clone();
        }
        catch( CloneNotSupportedException ex ) {
            throw new InternalError();
        }
    }

    @Override
    public int compareTo(ComplexNumber other) {
    int result;
      double re = other.getRe();
      double im = other.getIm();
      double module1 = re*re+im*im;
      double module2 = realPart*realPart+imaginaryPart*imaginaryPart;
      if (Math.abs(module2-module1)<0.01) result = 0;
      else if ((module1-module2)>0.01) result = -1;
      else result=1;
    return result;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array,ComplexNumber::compareTo);
    }

    @Override
    public ComplexNumber negate() {
    realPart*=-1;
    imaginaryPart*=-1;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
    realPart+=arg2.getRe();
    imaginaryPart+=arg2.getIm();
    return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double newReal = 0;
        double newIm =0;
        newReal += realPart*arg2.getRe()-imaginaryPart*arg2.getIm();
        newIm += imaginaryPart*arg2.getRe()+realPart*arg2.getIm();
        realPart = newReal;
        imaginaryPart = newIm;
        return this;
    }
    public String toString()
    {
        String result="";
        if (realPart!=0)
        result+=Double.toString(realPart);
        else
        if (imaginaryPart==0) return Double.toString(0);
        if(imaginaryPart<0) result+=Double.toString(imaginaryPart)+"i";
        else result+="+"+Double.toString(imaginaryPart)+"i";
        return result;
    }
    public boolean equals(Object other)
    {
        return this==other;
    }
}
