package architecture.mapper;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;
import thirdpartydependencies.Mapper;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class MapperNamingConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void basedOnPackage() {
        classes().that().resideInAPackage(Packages.MAPPER)
                .should().haveSimpleNameEndingWith("Map")
                .orShould().haveSimpleNameEndingWith("Mapper")
                .check(classes);
    }

    @Test
    public void basedOnType() {
        classes().that().areAnnotatedWith(Mapper.class)
                .should().haveSimpleNameEndingWith("Mapper")
                .check(classes);
    }

}
