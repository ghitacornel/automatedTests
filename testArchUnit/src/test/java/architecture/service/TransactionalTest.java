package architecture.service;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Service;
import thirdpartydependencies.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class TransactionalTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void testClasses() {
        classes().that().areAnnotatedWith(Transactional.class)
                .should().beAnnotatedWith(Service.class)
                .check(classes);
    }

    @Test
    public void testMethods() {
        methods().that()
                .areAnnotatedWith(Transactional.class)
                .should().beDeclaredInClassesThat().areAnnotatedWith(Service.class)
                .andShould().bePublic()
                .check(classes);
    }

}
