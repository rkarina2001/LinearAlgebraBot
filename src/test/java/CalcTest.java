
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalcTest {

    Calculator calc;

    @BeforeAll
    private void setCalc(){
        calc = new Calculator();
        System.out.println("new calc");
    }

   @Test
    public void addTest(){
        assertEquals(12.0, calc.add(5.0, 7.00005),
                0.0001, ()->"two double numbers addition");
   }

    @ParameterizedTest
    public void addTest2(){
        assertEquals(13.0, calc.add(5.0, 8.0000521313),
                0.0001, ()->"two double numbers addition");
    }

    @ParameterizedTest
    @ValueSource(doubles = { 10.0, 22.1, 12.3, -23.1})
    public void positiveTest(Double d){
        assertTrue(calc.isPositive(d));
    }

    @ParameterizedTest
    @MethodSource("doubleList")
    public void positiveListTest(Double d){
        assertTrue(calc.isPositive(d));
    }

    private List<Double> doubleList(){
        return Arrays.asList(10.0, 22.1, 12.3, -23.1);
    }

    @Test
    //@DisabledOnOs(value = OS.WINDOWS, disabledReason = "Not working on Win")
    public void divisionTest(){
        assumeTrue(false);
        assertThrows(Exception.class,
               ()-> calc.division(10, 0), "Arithmetic exception!");
    }


}


class Calculator {
    public double add(double a, double b){
        return a+b;
    }

    public double division(int a, int b){
        return a/b;
    }

    public boolean isPositive(double num) {
        return Math.abs(num)==num;
    }
}