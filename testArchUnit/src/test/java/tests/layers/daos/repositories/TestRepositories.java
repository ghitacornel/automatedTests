package tests.layers.daos.repositories;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.daos.Repository;
import thirdpartydependencies.daos.TemplateRepository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class TestRepositories {

    JavaClasses classes = new ClassFileImporter().importPackages("layers.daos.repositories");

    @Test
    public void testClasses() {

        classes()
                .should().bePublic()
                .andShould().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().areNotInterfaces().and().areNotAssignableFrom(TemplateRepository.class)
                .should().beAnnotatedWith(Repository.class)
                .check(classes);

        classes().that().areNotInterfaces().and().implement(TemplateRepository.class)
                .should().beAnnotatedWith(Repository.class)
                .check(classes);

        classes().that().areInterfaces()
                .should().beAssignableTo(TemplateRepository.class)
                .check(classes);
    }

}
