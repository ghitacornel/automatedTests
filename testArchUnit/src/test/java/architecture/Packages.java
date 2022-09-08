package architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

public interface Packages {

    String ROOT = "architecture";
    JavaClasses allClasses = new ClassFileImporter().importPackages(Packages.ROOT);
    JavaClasses allClassesWithoutTests = new ClassFileImporter().withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS).importPackages(Packages.ROOT);

    String CONFIG = ROOT + ".config";
    String EXCEPTION = ROOT + ".exception";
    String MAPPER = ROOT + ".mapper";
    String CONTROLLER = ROOT + ".controller";
    String HANDLER = ROOT + ".controller.handler";
    String PERSISTENCE = ROOT + ".persistence";
    String PERSISTENCE_ENTITY = PERSISTENCE + ".entity";
    String PERSISTENCE_CONVERTER = PERSISTENCE + ".converter";
    String PERSISTENCE_LISTENER = PERSISTENCE + ".listener";
    String PERSISTENCE_REPOSITORY = PERSISTENCE + ".repository";

    String BUSINESS = ROOT + ".business";
    String BUSINESS_COMPONENTS = BUSINESS + ".components";
    String BUSINESS_MODEL = BUSINESS + ".model";
    String BUSINESS_SERVICES = BUSINESS + ".services";
    String BUSINESS_CONFIGURATION = BUSINESS + ".configs";
    String BUSINESS_JSON = BUSINESS + ".jsons";

}
