package gr.netmechanics.jmix.appcommons.flowui.converter;

import java.util.Set;

import gr.netmechanics.jmix.appcommons.flowui.datatype.SetStringDatatype;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.Nullable;

/**
 * @author Panos Bariamis (pbaris)
 */
@Converter
public class SetStringConverter implements AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(@Nullable final Set<String> strings) {
        if (CollectionUtils.isEmpty(strings)) {
            return null;
        }

        return SetStringDatatype.toString(strings);
    }

    @Override
    public Set<String> convertToEntityAttribute(@Nullable final String s) {
        if (s == null) {
            return null;
        }

        return SetStringDatatype.toSet(s);
    }
}
