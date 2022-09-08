package architecture.layers.persistence.entity;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;
import thirdpartydependencies.AttributeConverter;
import thirdpartydependencies.Converter;
import thirdpartydependencies.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class EntityNamingConventionTest {

    private final JavaClasses classes = Packages.allClasses;

    @Test
    public void basedOnPackage() {
        // none
    }

    @Test
    public void basedOnAnnotation() {
        // none
    }

}
