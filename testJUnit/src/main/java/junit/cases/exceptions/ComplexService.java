package junit.cases.exceptions;

public class ComplexService {

    /**
     * complex business method, tons of if/then/else, exceptions raised, etc
     *
     * @param a
     * @param b
     * @return a + b when a > 0 and b > 0; -1 when either a == 0 or b == 0
     * @throws Exception when using negative numbers
     */
    public int complexBusinessMethod(int a, int b) throws Exception {

        if (a == 0 || b == 0)
            return -1;

        if (a == -3 && b == -4)
            throw new CustomBusinessException();

        if (a == -1 || b == -1)
            throw new RuntimeException("minus one");

        if (a < 0 || b < 0)
            throw new Exception();

        return a + b;
    }

}
