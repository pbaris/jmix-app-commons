package gr.netmechanics.jmix.appcommons.flowui.datatype;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import io.jmix.core.metamodel.annotation.DatatypeDef;
import io.jmix.core.metamodel.annotation.Ddl;
import io.jmix.core.metamodel.datatype.Datatype;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author Panos Bariamis (pbaris)
 */
@DatatypeDef(id = "setString", javaClass = Set.class)
@Ddl("varchar")
public class SetStringDatatype implements Datatype<Set<String>>  {

    @NonNull
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public String format(@Nullable final Object value) {
        if (value instanceof Set set) {
            return toString(set);
        }

        return "";
    }

    @NonNull
    @Override
    public String format(@Nullable final Object value, final @NonNull Locale locale) {
        return format(value);
    }

    @Override
    public Set<String> parse(@Nullable final String value) throws ParseException {
        if (value == null) {
            return new HashSet<>();
        }

        return toSet(value);
    }

    @Override
    public Set<String> parse(@Nullable final String value, @NonNull final Locale locale) throws ParseException {
        return parse(value);
    }

    public static String toString(@NonNull final Set<String> set) {
        return set.isEmpty() ? "" : String.join("|", set);
    }

    public static Set<String> toSet(@NonNull final String value) {
        if (StringUtils.isBlank(value)) {
            return new HashSet<>();
        }

        return Arrays.stream(value.split("\\|")).collect(Collectors.toSet());
    }
}
