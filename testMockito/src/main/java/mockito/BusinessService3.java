package mockito;

/**
 * Dependency for {@link AggregatorService}
 */
public interface BusinessService3 {

    /**
     * @param temporaryData
     * @throws RuntimeException when w is 10 with message "bad luck, client does not like 10"
     */
    void businessMethod3(TemporaryData temporaryData) throws RuntimeException;

}
