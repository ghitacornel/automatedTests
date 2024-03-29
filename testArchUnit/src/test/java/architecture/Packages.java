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
    String MODEL = ROOT + ".model";
    String CONTROLLER = ROOT + ".controller";
    String CONTROLLER_ADVICE = ROOT + ".controller.handler";
    String SERVICE = ROOT + ".service";
    String PERSISTENCE = ROOT + ".persistence";
    String PERSISTENCE_ENTITY = PERSISTENCE + ".entity";
    String PERSISTENCE_CONVERTER = PERSISTENCE + ".converter";
    String PERSISTENCE_LISTENER = PERSISTENCE + ".listener";
    String PERSISTENCE_REPOSITORY = PERSISTENCE + ".repository";

    String SCHEDULER = ROOT + ".scheduler";

}
