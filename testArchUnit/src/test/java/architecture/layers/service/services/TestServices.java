package architecture.layers.service.services;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import architecture.Packages;
import org.junit.Test;
import thirdpartydependencies.Service;
import thirdpartydependencies.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TestServices {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.SERVICE);

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(Service.class)
                .should().bePublic()
                .andShould().beTopLevelClasses()
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
