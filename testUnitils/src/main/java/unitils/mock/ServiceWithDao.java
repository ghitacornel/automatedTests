package unitils.mock;

public class ServiceWithDao {

    // this field must be injected or mocked
    private DAO dao;

    public void callDatabase() {
        dao.callDatabase();
    }

}
