package specials;

import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Optional;

public class ClassIsUtilityClass extends ArchCondition<JavaClass> {

    public ClassIsUtilityClass() {
        super("is utility class");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {

        if (!item.getModifiers().contains(JavaModifier.FINAL))
            events.add(new SimpleConditionEvent(null, false, "utility class is not final"));

        Optional<JavaConstructor> constructor = item.getConstructors()
                .stream()
                .filter(JavaConstructor::isConstructor)
                .filter(javaConstructor -> javaConstructor.getModifiers().contains(JavaModifier.PRIVATE))
                .filter(javaConstructor -> javaConstructor.getRawParameterTypes().isEmpty())
                .findFirst();
        if (constructor.isEmpty())
            events.add(new SimpleConditionEvent(null, false, "expected 1 private no argument constructor"));

        Optional<JavaField> field = item.getFields().stream()
                .filter(javaField -> !javaField.getModifiers().contains(JavaModifier.STATIC))
                .filter(javaField -> javaField.getModifiers().contains(JavaModifier.FINAL))
                .findFirst();
        field.ifPresent(javaField -> events.add(new SimpleConditionEvent(null, false, "found non static non final field " + javaField.getFullName())));

        Optional<JavaMethod> method = item.getMethods().stream()
                .filter(javaField -> !javaField.getModifiers().contains(JavaModifier.STATIC))
                .findFirst();
        method.ifPresent(javaMethod -> events.add(new SimpleConditionEvent(null, false, "found non static method " + javaMethod.getFullName())));
    }
}
