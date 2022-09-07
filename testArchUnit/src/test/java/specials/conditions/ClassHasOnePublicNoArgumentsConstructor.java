package specials.conditions;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class ClassHasOnePublicNoArgumentsConstructor extends ArchCondition<JavaClass> {

    public ClassHasOnePublicNoArgumentsConstructor() {
        super("have 1 public no argument constructor");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {
        if (item.getConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(o -> o.getModifiers().contains(JavaModifier.PUBLIC))
                .filter(o -> o.getRawParameterTypes().isEmpty())
                .findAny().isEmpty()) {
            events.add(new SimpleConditionEvent(null, false, "expected 1 public no argument constructor"));
        }
    }
}
