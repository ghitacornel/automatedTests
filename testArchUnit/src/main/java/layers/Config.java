package layers;

public interface Config {

    String ROOT = "layers";

    String PERSISTENCE = ROOT + ".persistence";
    String PERSISTENCE_ENTITIES = PERSISTENCE + ".entities";
    String PERSISTENCE_CONVERTERS = PERSISTENCE + ".converters";
    String PERSISTENCE_LISTENERS = PERSISTENCE + ".listeners";
    String PERSISTENCE_REPOSITORIES = PERSISTENCE + ".repositories";

    String BUSINESS = ROOT + ".business";
    String BUSINESS_COMPONENTS = BUSINESS + ".components";
    String BUSINESS_MODEL = BUSINESS + ".model";
    String BUSINESS_SERVICES = BUSINESS + ".services";
    String BUSINESS_CONFIGURATION = BUSINESS + ".configs";

    String REST = ROOT + ".rest";
    String REST_CONTROLLERS = REST + ".controllers";
    String REST_JSONS = REST + ".jsons";

    String MAPPERS = REST + ".mappers";

}
