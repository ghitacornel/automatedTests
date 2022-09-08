package architecture.layers.persistence.repository;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.JpaRepository;
import thirdpartydependencies.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class RepositoryLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().haveSimpleNameEndingWith("Repository")
                .or().implement(JpaRepository.class)
                .or().areAnnotatedWith(Repository.class)
                .should().resideInAPackage(Packages.PERSISTENCE_REPOSITORY)
                .check(classes);
    }

}
