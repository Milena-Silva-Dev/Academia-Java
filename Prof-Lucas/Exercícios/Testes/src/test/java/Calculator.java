import Calculator.Calc;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    double a;
    double b;
    double res;
    Calc calc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        // Executado antes de todos os testes
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        // Executado após todos os testes
    }

    @BeforeEach
    void setUp() {
        calc = new Calc();
        a = 5;
        b = 2;
        res = 0;
    }

    @AfterEach
    void tearDown() {
        calc = null;
    }

    @Test
    void testAdd() {
        res = calc.add(a, b);
        assertEquals(7, res);
    }

    @Test
    void testSub() {
        res = calc.sub(a, b);
        assertEquals(3, res);
    }

    @Test
    void testMul() {
        res = calc.mul(a, b);
        assertEquals(10, res);
    }

    @Test
    void testDiv() {
        res = calc.div(a, b);
        assertEquals(2.5, res);
    }

    @Test
    void testDivByZero() {
        b = 0;
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calc.div(a, b));
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void testPow() {
        res = calc.pow(a, b);
        assertEquals(25, res);
    }

    @Test
    void testSqrt() {
        a = 4;
        res = calc.sqrt(a);
        assertEquals(2, res);
    }

    @Test
    void testSqrtNegative() {
        a = -1;
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calc.sqrt(a));
        assertEquals("Cannot take square root of a negative number", exception.getMessage());
    }
}
