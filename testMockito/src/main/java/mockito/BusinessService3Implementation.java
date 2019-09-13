package mockito;

public class BusinessService3Implementation implements BusinessService3 {

    @Override
    public void businessMethod3(TemporaryData temporaryData) {
        if (temporaryData.getW() == 10) throw new RuntimeException("bad luck, client does not like 10");
    }

}
