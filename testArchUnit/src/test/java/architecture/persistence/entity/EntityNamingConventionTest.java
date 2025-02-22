package architecture.persistence.entity;

import architecture.Packages;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

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
