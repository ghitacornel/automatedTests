package architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class LayersAccessTest {

    private final JavaClasses classes = Packages.allClassesWithoutTests;

    @Test
    public void testLayersDependencies() {
        layeredArchitecture()
                .layer("Controller").definedBy(Packages.CONTROLLER, Packages.CONTROLLER_ADVICE)
                .layer("Service").definedBy(Packages.SERVICE + "..")
                .layer("Repository").definedBy(Packages.PERSISTENCE + "..", Packages.PERSISTENCE_CONVERTER, Packages.PERSISTENCE_LISTENER, Packages.PERSISTENCE_ENTITY, Packages.PERSISTENCE_REPOSITORY)
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                .check(classes);
    }

    @Test
    public void testAllLayersDependencies() {
        layeredArchitecture()
                .layer("Config").definedBy(Packages.CONFIG)
                .layer("Exception").definedBy(Packages.EXCEPTION)
                .layer("Mapper").definedBy(Packages.MAPPER)
                .layer("Model").definedBy(Packages.MODEL)
                .layer("ControllerAdvice").definedBy(Packages.CONTROLLER_ADVICE)
                .layer("Scheduler").definedBy(Packages.SCHEDULER)
                .layer("Controller").definedBy(Packages.CONTROLLER)
                .layer("Service").definedBy(Packages.SERVICE + "..")
                .layer("Repository").definedBy(Packages.PERSISTENCE + "..", Packages.PERSISTENCE_CONVERTER, Packages.PERSISTENCE_LISTENER, Packages.PERSISTENCE_ENTITY, Packages.PERSISTENCE_REPOSITORY)
                .whereLayer("ControllerAdvice").mayNotBeAccessedByAnyLayer()
                .whereLayer("Scheduler").mayNotBeAccessedByAnyLayer()
                .whereLayer("Mapper").mayOnlyBeAccessedByLayers("Service")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                .check(classes);
    }

}
