package ru.ncedu.java.tasks;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Антон on 25.03.2017.
 */
public class ArrayVectorImplTest {
    @Test
    public void testSetGet() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        assertArrayEquals(array,obj.get(),0.1);
    }

    @Test
    public void testClone() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        ArrayVector obj2 = obj.clone();
        assertArrayEquals(obj.get(),obj2.get(),0.1);
    }

    @Test
    public void getSize() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        assertEquals(obj.getSize(),3);
    }

    @Test
    public void testSetIndex() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        obj.set(5,10.5);
       obj.set(1,10.5);
        assertArrayEquals(obj.get(),new double[] {1.5,10.5,10,0,0,10.5},0.1);
    }

    @Test
    public void testGetIndex() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        assertEquals(obj.get(0),1.5,0.1);
    }

    @Test
    public void getMax() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        assertEquals(obj.getMax(),10,0.1);
    }

    @Test
    public void getMin() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        assertEquals(obj.getMin(),1,0.1);
    }

    @Test
    public void sortAscending() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        obj.sortAscending();
        assertArrayEquals(obj.get(),new double[] {1,1.5,10},0.1);
    }

    @Test
    public void mult() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        obj.mult(2);
        assertArrayEquals(obj.get(),new double[] {3,2,20},0.1);
    }

    @Test
    public void sum() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
        obj.sum(obj);
        assertArrayEquals(obj.get(),new double[] {3,2,20},0.1);
    }

    @Test
    public void scalarMult() throws Exception {
        double[] array = new double[] {1.5,1,10};
        ArrayVectorImpl obj = new ArrayVectorImpl();
        obj.set(array);
    }

    @Test
    public void getNorm() throws Exception {
    }

}