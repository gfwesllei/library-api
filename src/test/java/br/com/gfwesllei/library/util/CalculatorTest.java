package br.com.gfwesllei.library.util;

import br.com.gfwesllei.library.exceptions.DividePerZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author weslleiferreira
 * @project library
 */
class CalculatorTest {

    public Calculator calculator;

    @BeforeEach
    void  setup(){
        calculator = new Calculator();
    }

    @Test
    void  shouldSum2Values() {
        //cenary
        double value1=5,value2=10;
        double expectedResult=15;
        //execution
        double result=calculator.sum(value1,value2);
        //assertions
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void  shouldSubtract2Values(){
        double value1=5,value2=10;
        double expectedResult=-5;

        double result=calculator.minus(value1,value2);
        //assertions
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void  sholdDivide2Values(){
        double value1=10,value2=5;
        double expectedResult=2;

        double result=calculator.divide(value1,value2);
        //assertions
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void  sholdThrowDivisionPerZeroException(){
        double value1=10,value2=0;
        //assertions
        assertThatThrownBy(()->{
            calculator.divide(value1,value2);
        }).isInstanceOf(DividePerZeroException.class);
    }

    @Test
    void  sholdMultiply2Values(){
        double value1=10,value2=5;
        double expectedResult=50;

        double result=calculator.multiply(value1,value2);
        //assertions
        assertThat(result).isEqualTo(expectedResult);
    }
}