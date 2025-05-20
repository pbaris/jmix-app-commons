package gr.netmechanics.jmix.appcommons.flowui.converter;

import java.util.List;

import gr.netmechanics.jmix.appcommons.flowui.datatype.ListStringDatatype;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.Nullable;

/**
 * @author Panos Bariamis (pbaris)
 */
@Converter
public class ListStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(@Nullable final List<String> strings) {
        if (CollectionUtils.isEmpty(strings)) {
            return null;
        }

        return ListStringDatatype.toString(strings);
    }

    @Override
    public List<String> convertToEntityAttribute(@Nullable final String s) {
        if (s == null) {
            return null;
        }

        return ListStringDatatype.toList(s);
    }
}
