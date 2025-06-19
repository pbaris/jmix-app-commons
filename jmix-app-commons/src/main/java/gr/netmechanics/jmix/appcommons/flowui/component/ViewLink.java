package gr.netmechanics.jmix.appcommons.flowui.component;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import io.jmix.flowui.component.UiComponentUtils;
import io.jmix.flowui.view.StandardListView;
import io.jmix.flowui.view.View;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewInfo;
import io.jmix.flowui.view.ViewRegistry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

/**
 * @author Panos Bariamis (pbaris)
 */
public class ViewLink extends Composite<RouterLink> implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;
    private ViewRegistry viewRegistry;

    private final HorizontalLayout layout = new HorizontalLayout();

    @Override
    protected RouterLink initContent() {
        layout.setSpacing(false);
        layout.addClassName("gap-s");
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        RouterLink routerLink = super.initContent();
        routerLink.add(layout);
        return routerLink;
    }

    @Override
    protected void onAttach(final AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        boolean lookupMode = false;

        View<?> view = UiComponentUtils.findView(this);
        if (view instanceof StandardListView<?> listView) {
            lookupMode = listView.getSelectionHandler().isPresent()
                         && UiComponentUtils.findComponent(listView, "lookupActions").isPresent();
        }

        setVisible(!lookupMode);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        viewRegistry = applicationContext.getBean(ViewRegistry.class);
    }

    @Override
    public void setApplicationContext(@NonNull final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setText(final String text) {
        getContent().add(new Span(text));
    }

    public void setViewId(final String viewId) {
        getContent().setRoute(getViewClass(viewId));
    }

    public void setIcon(final Component icon) {
        if (icon != null) {
            if (layout.getComponentCount() == 2) {
                layout.remove(layout.getComponentAt(0));
            }

            if (icon instanceof Icon ic) {
                ic.setSize("1em");
            }

            layout.addComponentAsFirst(icon);
        }
    }

    private Class<? extends View<?>> getViewClass(final String viewId) {
        ViewInfo viewInfo = viewRegistry.getViewInfo(viewId);
        Class<? extends View<?>> viewClass = viewInfo.getControllerClass();
        if (!isSupportedView(viewClass)) {
            throw new IllegalArgumentException("View class '%s' is not supported".formatted(viewClass.getSimpleName()));
        }
        return viewClass;
    }

    private boolean isSupportedView(final Class<?> targetView) {
        return View.class.isAssignableFrom(targetView) && targetView.getAnnotation(ViewController.class) != null;
    }
}
