package br.com.gfwesllei.library.Util;

import br.com.gfwesllei.library.exception.DividePerZeroException;

/**
 * @author weslleiferreira
 * @project library
 */
public class Calculator {


    public double sum(double value1, double value2) {
        return value1 +value2;
    }

    public double minus(double value1, double value2) {
        return value1 -value2;
    }

    public double divide(double value1, double value2) {
        if(value2==0){
            throw new DividePerZeroException("Can't division per zero");
        }
        return value1/value2;
    }

    public double multiply(double value1, double value2) {

        return value1*value2;
    }
}
