package src;

import src.Controller.Controller;
import src.Model.*;
import junit.framework.TestCase;
import src.Model.Polynomial;

public class CalculatorTest extends TestCase {
    Polynomial p1;
    Polynomial p2;
    Polynomial result;
    Operations operations;
    Controller c;
    public void setUp() throws Exception{
        c = new Controller();
        p1 = new Polynomial();
        p1 = c.coeffAndPower("1x^2+3x^1");
        p2 = new Polynomial();
        p2 = c.coeffAndPower("-1x^3+2x^2");
        result = new Polynomial();
        operations = new Operations();
    }
    public void test1(){
        result = operations.addOperation(p1,p2);
        assertEquals(c.polynomToString(result),"-1x^3+3x^2+3x^1");
    }
    public void test2(){
        result = operations.subOperation(p1,p2);
        assertEquals(c.polynomToString(result),"1x^3-1x^2+3x^1");
    }
    public void test3(){
        result = operations.multiplicationOperation(p1,p2);
        assertEquals(c.polynomToString(result),"-1x^5-1x^4+6x^3");
    }
    public void test4(){
        DoublePolynomial result2 = operations.integrateOperation(p1);
        assertEquals(c.doublePolynomToString(result2), "0.3333333333333333x^3+1.5x^2");
    }
    public void test5(){
        result = operations.derivateOperation(p1);
        assertEquals(c.polynomToString(result),"2x^1+3x^0");
    }
}
