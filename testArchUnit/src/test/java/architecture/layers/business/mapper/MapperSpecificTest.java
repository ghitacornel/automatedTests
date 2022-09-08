package architecture.layers.business.mapper;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.Test;
import thirdpartydependencies.Mapper;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class MapperSpecificTest {

    private final JavaClasses classes = new ClassFileImporter().importPackages(Packages.MAPPER);

    @Test
    public void specific() {
        classes().that().areAnnotatedWith(Mapper.class)
                .or().haveSimpleNameEndingWith("Map")
                .or().haveSimpleNameEndingWith("Mapper")
                .should().beTopLevelClasses()
                .check(classes);
    }

}
