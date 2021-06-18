package layers;

public interface Config {

    String ROOT = "layers";

    String PERSISTENCE = ROOT + ".persistence";
    String ENTITIES = PERSISTENCE + ".entities";
    String CONVERTERS = PERSISTENCE + ".converters";
    String LISTENERS = PERSISTENCE + ".listeners";
    String REPOSITORIES = PERSISTENCE + ".repositories";

    String BUSINESS = ROOT + ".business";
    String COMPONENTS = BUSINESS + ".components";
    String MODEL = BUSINESS + ".model";
    String SERVICES = BUSINESS + ".services";
    String CONFIGURATION = BUSINESS + ".configs";

    String REST = ROOT + ".ui";
    String CONTROLLERS = REST + ".controllers";
    String JSONS = REST + ".jsons";
    String MAPPERS = REST + ".mappers";

}
