package gr.netmechanics.jmix.appcommons.util;

import java.text.Collator;
import java.util.Locale;
import java.util.function.Function;

import com.vaadin.flow.function.SerializableComparator;

/**
 * @author Panos Bariamis (pbaris)
 */
public class CollatorComparator<T> implements SerializableComparator<T> {

    private final Collator collator;

    private final Function<T, String> func;

    public CollatorComparator(final Locale locale, final Function<T, String> func) {
        this.func = func;

        collator = Collator.getInstance(locale);
        collator.setStrength(Collator.SECONDARY);
    }

    @Override
    public int compare(final T o1, final T o2) {
        return collator.compare(func.apply(o1), func.apply(o2));
    }
}
