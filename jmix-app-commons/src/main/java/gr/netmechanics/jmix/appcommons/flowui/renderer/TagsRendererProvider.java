package gr.netmechanics.jmix.appcommons.flowui.renderer;

import gr.netmechanics.jmix.appcommons.entity.trait.HasTags;
import io.jmix.core.metamodel.model.MetaPropertyPath;
import io.jmix.flowui.xml.layout.ComponentLoader;
import io.jmix.flowui.xml.layout.loader.component.datagrid.RendererProvider;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

/**
 * @author Panos Bariamis (pbaris)
 */
@Component("jac_TagsRendererProvider")
public class TagsRendererProvider implements RendererProvider<TagsRenderer<? extends HasTags>> {

    public static final String NAME = "tagsRenderer";

    @Override
    public boolean supports(final String rendererName) {
        return NAME.equals(rendererName);
    }

    @Override
    public TagsRenderer<? extends HasTags> createRenderer(final Element element,
                                                          final MetaPropertyPath metaPropertyPath, final ComponentLoader.Context context) {
        return new TagsRenderer<>();
    }
}
