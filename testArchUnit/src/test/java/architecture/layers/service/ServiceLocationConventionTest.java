package architecture.layers.service;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ServiceLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(Service.class)
                .or().haveSimpleNameEndingWith("Service")
                .or().haveSimpleNameEndingWith("ServiceImpl")
                .should().resideInAPackage(Packages.SERVICE)
                .check(classes);
    }

}
