package com.netcracker.edu.java.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Антон on 25.03.2017.
 */
public class ComplexNumberImplTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getRe() throws Exception {
    }

    @Test
    public void getIm() throws Exception {
    }

    @Test
    public void isReal() throws Exception {
    }

    @Test
    public void set() throws Exception {
        ComplexNumberImpl obj = new ComplexNumberImpl();
        obj.set("-5+2i");
        Assert.assertEquals(obj.getRe(),-5,0.1);
        Assert.assertEquals(obj.getIm(),2,0.1);
        obj.set("1+52i");
        Assert.assertEquals(obj.getRe(),1,0.1);
        Assert.assertEquals(obj.getIm(),52,0.1);
        obj.set("+4-i");
        Assert.assertEquals(obj.getRe(),4,0.1);
        Assert.assertEquals(obj.getIm(),-1,0.1);
        obj.set("i");
        Assert.assertEquals(obj.getRe(),0,0.1);
        Assert.assertEquals(obj.getIm(),1,0.1);
        obj.set("-3i");
        Assert.assertEquals(obj.getRe(),0,0.1);
        Assert.assertEquals(obj.getIm(),-3,0.1);
        obj.set("3");
        Assert.assertEquals(obj.getRe(),3,0.1);
        Assert.assertEquals(obj.getIm(),0,0.1);
    }

    @Test
    public void set1() throws Exception {
    }

    @Test
    public void copy() throws Exception {
    }

    @Test
    public void testclone() throws Exception {
    }

    @Test
    public void compareTo() throws Exception {
    }

    @Test
    public void sort() throws Exception {
        ComplexNumberImpl obj1 = new ComplexNumberImpl();
        obj1.set(1,-1);
        ComplexNumberImpl obj2 = new ComplexNumberImpl();
        obj2.set(50,50);
        ComplexNumberImpl obj3 = new ComplexNumberImpl();
        obj3.set(25,25);
        ComplexNumberImpl[] arr = new ComplexNumberImpl[]{obj1,obj2,obj3};
        obj1.sort(arr);

    }

    @Test
    public void negate() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void multiply() throws Exception {
    }
    @Test
    public void testToString() throws Exception {
        ComplexNumberImpl obj = new ComplexNumberImpl();
        obj.set(50,-1);
        Assert.assertEquals(obj.toString(),"50.0-1.0i");
    }
}