package gr.netmechanics.jmix.appcommons.flowui.xml.layout.loader.component;

import gr.netmechanics.jmix.appcommons.flowui.component.ViewLink;
import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;
import org.springframework.lang.NonNull;

/**
 * @author Panos Bariamis (pbaris)
 */
public class ViewLinkLoader extends AbstractComponentLoader<ViewLink> {
    @Override
    @NonNull
    protected ViewLink createComponent() {
        return factory.create(ViewLink.class);
    }

    @Override
    public void loadComponent() {
        componentLoader().loadClassNames(resultComponent, element);
        componentLoader().loadIcon(element, resultComponent::setIcon);

        getLoaderSupport().loadString(element, "size", resultComponent::setSize);
        getLoaderSupport().loadResourceString(element, "text", context.getMessageGroup(), resultComponent::setText);
        getLoaderSupport().loadString(element, "view", resultComponent::setViewId);
    }
}
