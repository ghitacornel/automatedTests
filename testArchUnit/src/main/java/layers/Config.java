package layers;

public interface Config {

    String ROOT = "layers";

    String PERSISTENCE = ROOT + ".daos";
    String ENTITIES = PERSISTENCE + ".entities";
    String CONVERTERS = PERSISTENCE + ".converters";
    String LISTENERS = PERSISTENCE + ".listeners";
    String REPOSITORIES = PERSISTENCE + ".repositories";

    String business = ROOT + ".business";
    String controller = ROOT + ".ui";

}
