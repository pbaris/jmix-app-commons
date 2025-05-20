package gr.netmechanics.jmix.appcommons.flowui.xml.layout.loader.component.datagrid;

import gr.netmechanics.jmix.appcommons.flowui.renderer.BooleanRenderer;
import io.jmix.core.entity.EntityValues;
import io.jmix.core.metamodel.model.MetaPropertyPath;
import io.jmix.flowui.xml.layout.ComponentLoader;
import io.jmix.flowui.xml.layout.loader.component.datagrid.RendererProvider;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

/**
 * @author Panos Bariamis (pbaris)
 */
@Component("jac_BooleanRendererProvider")
public class BooleanRendererProvider implements RendererProvider<BooleanRenderer<?>> {
    public static final String NAME = "booleanRenderer";

    @Override
    public boolean supports(final String rendererName) {
        return NAME.equals(rendererName);
    }

    @Override
    public BooleanRenderer<?> createRenderer(final Element element,
                                            final MetaPropertyPath metaPropertyPath, final ComponentLoader.Context context) {

        return new BooleanRenderer<>(item -> EntityValues.getValueEx(item, metaPropertyPath));
    }
}
