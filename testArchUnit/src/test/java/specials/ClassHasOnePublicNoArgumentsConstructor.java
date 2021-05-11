package specials;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Optional;

public class ClassHasOnePublicNoArgumentsConstructor extends ArchCondition<JavaClass> {

    public ClassHasOnePublicNoArgumentsConstructor() {
        super("have 1 public no argument constructor");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {
        Optional<JavaConstructor> constructor = item.getAllConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(javaConstructor -> javaConstructor.getModifiers().contains(JavaModifier.PUBLIC))
                .filter(javaConstructor -> javaConstructor.getRawParameterTypes().isEmpty())
                .findFirst();
        if (constructor.isEmpty())
            events.add(new SimpleConditionEvent(null, false, "expected 1 public no argument constructor"));
    }
}
