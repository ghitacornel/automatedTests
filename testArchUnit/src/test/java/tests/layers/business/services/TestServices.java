package tests.layers.business.services;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import thirdpartydependencies.business.services.Service;
import thirdpartydependencies.business.services.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestServices {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.business");

    @Test
    public void testClasses() {
        classes().that()
                .areAnnotatedWith(Service.class)
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Service")
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that()
                .areAnnotatedWith(Transactional.class)
                .should().bePublic()
                .check(classes);
    }

}
