package ru.ncedu.java.tasks;

import java.util.Arrays;

/**
 * Created by Антон on 21.03.2017.
 */
public class ArrayVectorImpl implements ArrayVector {
    /**
     * Задает все элементы вектора (определяет длину вектора).
     * Передаваемый массив не клонируется.
     * @param elements Не равен null
     */
    double[] arrays;
    @Override
    public void set(double... elements) {
        arrays = Arrays.copyOf(elements,elements.length) ;
    }


    public double[] get() {
        return arrays;
    }

    @Override
    public ArrayVector clone()
    {
        double[] newarrays;
        ArrayVector newCopy = new ArrayVectorImpl();
        newarrays = Arrays.copyOf(arrays,arrays.length);
        newCopy.set(newarrays);
        return newCopy;
    }

    @Override
    public int getSize() {
        return arrays.length;
    }

    @Override
    public void set(int index, double value) {
        if (index<0) return;
        if (index>=arrays.length){
            arrays = Arrays.copyOf(arrays,index+1);
        }
        arrays[index]=value;
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return arrays[index];
    }

    @Override
    public double getMax() {
        double max = arrays[1];
        for (double element:arrays) {
            if (element>max)
                max=element;
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = arrays[1];
        for (double element:arrays) {
            if (element<min)
                min=element;
        }
        return min;
  }

    @Override
    public void sortAscending() {
        Arrays.sort(arrays);
    }

    @Override
    public void mult(double factor) {
        for (int i =0; i<arrays.length; i++)
        {
            arrays[i]*=factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        for (int i =0; i<arrays.length; i++)
        {
            arrays[i]+=anotherVector.get(i);
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double result=0;
        int max = 0;
        if (this.getSize()<anotherVector.getSize()) max=this.getSize();
        else max = anotherVector.getSize();
        for (int i =0; i<max; i++)
        {
            result+=this.get(i)*anotherVector.get(i);
        }
        return result;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(scalarMult(this));
    }
}
