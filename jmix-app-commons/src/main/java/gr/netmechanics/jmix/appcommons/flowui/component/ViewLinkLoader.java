package gr.netmechanics.jmix.appcommons.flowui.component;

import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;
import io.jmix.flowui.xml.layout.support.IconLoaderSupport;
import org.springframework.lang.NonNull;

/**
 * @author Panos Bariamis (pbaris)
 */
public class ViewLinkLoader extends AbstractComponentLoader<ViewLink> {

    private IconLoaderSupport iconLoaderSupport;

    @Override
    @NonNull
    protected ViewLink createComponent() {
        return factory.create(ViewLink.class);
    }

    @Override
    public void loadComponent() {
        getLoaderSupport().loadString(element, "size", resultComponent::setSize);
        getLoaderSupport().loadResourceString(element, "text", context.getMessageGroup(), resultComponent::setText);
        getLoaderSupport().loadString(element, "view", resultComponent::setViewId);

        componentLoader().loadClassNames(resultComponent, element);
        iconLoaderSupport().loadIcon(element, resultComponent::setIcon);
    }

    protected IconLoaderSupport iconLoaderSupport() {
        if (iconLoaderSupport == null) {
            iconLoaderSupport = applicationContext.getBean(IconLoaderSupport.class, context);
        }

        return iconLoaderSupport;
    }
}
