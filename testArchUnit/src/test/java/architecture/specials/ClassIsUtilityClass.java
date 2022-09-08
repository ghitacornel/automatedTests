package architecture.specials;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class ClassIsUtilityClass extends ArchCondition<JavaClass> {

    public ClassIsUtilityClass() {
        super("is utility class");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {

        if (!item.getModifiers().contains(JavaModifier.FINAL)) {
            events.add(new SimpleConditionEvent(null, false, "utility class is not final"));
        }

        if (item.getConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(o -> o.getModifiers().contains(JavaModifier.PRIVATE))
                .filter(o -> o.getRawParameterTypes().isEmpty())
                .findAny()
                .isEmpty()) {
            events.add(new SimpleConditionEvent(null, false, "expected exactly 1 private no argument constructor"));
        }

        item.getFields().stream()
                .filter(o -> !o.getModifiers().contains(JavaModifier.STATIC))
                .filter(o -> o.getModifiers().contains(JavaModifier.FINAL))
                .findAny()
                .ifPresent(javaField -> events.add(new SimpleConditionEvent(null, false, "found non static non final field " + javaField.getFullName())));

        item.getMethods().stream()
                .filter(o -> !o.getModifiers().contains(JavaModifier.STATIC))
                .findAny()
                .ifPresent(javaMethod -> events.add(new SimpleConditionEvent(null, false, "found non static method " + javaMethod.getFullName())));
    }
}
