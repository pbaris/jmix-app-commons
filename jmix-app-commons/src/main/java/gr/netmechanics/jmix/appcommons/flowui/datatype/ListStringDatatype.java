package gr.netmechanics.jmix.appcommons.flowui.datatype;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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
@DatatypeDef(id = "listString", javaClass = List.class)
@Ddl("varchar")
public class ListStringDatatype implements Datatype<List<String>>  {

    @NonNull
    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public String format(@Nullable final Object value) {
        if (value instanceof List list) {
            return toString(list);
        }

        return "";
    }

    @NonNull
    @Override
    public String format(@Nullable final Object value, final @NonNull Locale locale) {
        return format(value);
    }

    @Override
    public List<String> parse(@Nullable final String value) throws ParseException {
        if (value == null) {
            return new ArrayList<>();
        }

        return toList(value);
    }

    @Override
    public List<String> parse(@Nullable final String value, @NonNull final Locale locale) throws ParseException {
        return parse(value);
    }

    public static String toString(@NonNull final List<String> list) {
        return list.isEmpty() ? "" : String.join("|", list);
    }

    public static List<String> toList(@NonNull final String value) {
        if (StringUtils.isBlank(value)) {
            return new ArrayList<>();
        }

        return Arrays.stream(value.split("\\|")).collect(Collectors.toList());
    }
}
