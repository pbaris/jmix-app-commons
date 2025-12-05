package gr.netmechanics.jmix.appcommons.validation;

import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

class Iso3166Set1Alpha2Validator implements ConstraintValidator<Iso3166Set1Alpha2, String> {

    private static final Set<String> ISO_3166_ALPHA2 = Stream.of(Locale.getISOCountries())
        .map(String::toLowerCase)
        .collect(Collectors.toUnmodifiableSet());

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (value == null || value.isBlank()) {
            return true;
        }

        String code = value.trim().toLowerCase();
        return code.length() == 2 && ISO_3166_ALPHA2.contains(code);
    }
}
