package layers;

public interface Config {

    String root = "layers";

    String persistence = root + ".daos";
    String entities = persistence + ".entities";
    String converters = persistence + ".converters";
    String listeners = persistence + ".listeners";
    String repositories = persistence + ".repositories";

    String business = root + ".business";
    String controller = root + ".ui";

}
