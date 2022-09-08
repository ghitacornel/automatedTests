package architecture.layers.business.mapper;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.Mapper;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class MapperLocationConventionTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void location() {
        classes().that().areAnnotatedWith(Mapper.class)
                .or().haveSimpleNameEndingWith("Map")
                .or().haveSimpleNameEndingWith("Mapper")
                .should().resideInAPackage(Packages.MAPPER)
                .check(classes);
    }

}
