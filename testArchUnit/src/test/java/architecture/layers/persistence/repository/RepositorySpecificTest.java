package architecture.layers.persistence.repository;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Repository;
import thirdpartydependencies.JpaRepository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class RepositorySpecificTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.PERSISTENCE_REPOSITORY);

    @Test
    public void testClasses() {

        classes()
                .should().bePublic()
                .andShould().beTopLevelClasses()
                .andShould().haveSimpleNameEndingWith("Repository")
                .check(classes);

        classes().that().areNotInterfaces().and().areNotAssignableFrom(JpaRepository.class)
                .should().beAnnotatedWith(Repository.class)
                .check(classes);

        classes().that().areNotInterfaces().and().implement(JpaRepository.class)
                .should().beAnnotatedWith(Repository.class)
                .check(classes);

        classes().that().areInterfaces()
                .should().beAssignableTo(JpaRepository.class)
                .check(classes);
    }

}
