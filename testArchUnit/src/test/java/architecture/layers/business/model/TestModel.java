package architecture.layers.business.model;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Config;
import org.junit.Test;
import thirdpartydependencies.business.services.Transactional;

import java.io.Serializable;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noMethods;

public class TestModel {

    JavaClasses classes = new ClassFileImporter().importPackages(Config.BUSINESS_MODEL);

    @Test
    public void testClasses() {
        classes().should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().implement(Serializable.class)
                .check(classes);
    }

    @Test
    public void testMethods() {
        noMethods().should().beAnnotatedWith(Transactional.class)
                .check(classes);
    }

}
