package architecture.persistence.repository;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.JpaRepository;
import thirdpartydependencies.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class RepositoryNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);
    }

    @Test
    public void basedOnAnnotation() {
        classes().that().areAnnotatedWith(Repository.class)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);
    }

    @Test
    public void basedOnInterface() {
        classes().that().implement(JpaRepository.class)
                .should().haveSimpleNameEndingWith("Repository")
                .check(classes);
    }

}
