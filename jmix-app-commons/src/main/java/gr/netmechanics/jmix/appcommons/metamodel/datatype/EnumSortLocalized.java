package gr.netmechanics.jmix.appcommons.metamodel.datatype;

import java.util.function.BiFunction;

import io.jmix.core.Messages;

/**
 * @author Panos Bariamis (pbaris)
 */
public interface EnumSortLocalized<E> {

    BiFunction<Messages, E, String> getLocalizedSortFunction();
}
