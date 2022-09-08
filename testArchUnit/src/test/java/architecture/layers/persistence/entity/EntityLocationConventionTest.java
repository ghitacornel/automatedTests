package architecture.layers.persistence.entity;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Entity;
import thirdpartydependencies.MappedSuperclass;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class EntityLocationConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(Entity.class)
                .or().areAnnotatedWith(MappedSuperclass.class)
                .or().haveSimpleNameEndingWith("Entity")
                .or().haveSimpleNameEndingWith("EntityTemplate")
                .should().resideInAPackage(Packages.PERSISTENCE_ENTITY)
                .check(classes);
    }

}
