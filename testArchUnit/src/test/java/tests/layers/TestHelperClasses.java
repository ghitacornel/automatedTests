package tests.layers;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import specials.ClassIsHelperClass;
import specials.ClassIsUtilityClass;
import thirdpartydependencies.business.Utility;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.services.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

public class TestHelperClasses {

    JavaClasses classes = new ClassFileImporter().importPackages("layers");

    @Test
    public void testHelperClasses() {
        classes()
                .that().haveSimpleNameEndingWith("Helper")
                .should().notBePublic()
                .andShould(new ClassIsHelperClass())
                .check(classes);

    }
}
