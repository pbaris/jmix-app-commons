package gr.netmechanics.jmix.appcommons.validation;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

class Iso639Set1Validator implements ConstraintValidator<Iso639Set1, String> {

    private static final Set<String> ISO_639_SET1 = Stream.of(Locale.getISOLanguages())
        .map(String::toLowerCase)
        .collect(Collectors.toUnmodifiableSet());

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (value == null || value.isBlank()) {
            return true;
        }

        String code = value.trim().toLowerCase();
        return code.length() == 2 && ISO_639_SET1.contains(code);
    }
}
