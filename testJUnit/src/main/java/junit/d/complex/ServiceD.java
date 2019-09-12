package junit.d.complex;

/**
 * Note that methods implemented by this service have a 'static'/'stateless'/'no
 * context holder' flavor hence no special context is needed in order to test it
 *
 * @author CornelGhita
 */
public class ServiceD {

    /**
     * complex business method, tons of if/then/else, exceptions raised, etc
     *
     * @param a
     * @param b
     * @return a + b when a > 0 and b > 0; -1 when either a == 0 or b == 0
     * @throws Exception when using negative numbers
     */
    public int businessSum(int a, int b) throws Exception {

        if (a == 0 || b == 0)
            return -1;

        if (a == -3 && b == -4)
            throw new VerySpecialBusinessException();
        if (a < 0 || b < 0)
            throw new Exception();

        return a + b;
    }

}
