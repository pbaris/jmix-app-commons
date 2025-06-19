package gr.netmechanics.jmix.appcommons;

import gr.netmechanics.jmix.appcommons.flowui.component.ViewLink;
import gr.netmechanics.jmix.appcommons.flowui.xml.layout.loader.component.ViewLinkLoader;
import io.jmix.core.annotation.JmixModule;
import io.jmix.core.annotation.MessageSourceBasenames;
import io.jmix.eclipselink.EclipselinkConfiguration;
import io.jmix.flowui.FlowuiConfiguration;
import io.jmix.flowui.sys.registration.ComponentRegistration;
import io.jmix.flowui.sys.registration.ComponentRegistrationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@ConfigurationPropertiesScan
@JmixModule(dependsOn = {EclipselinkConfiguration.class, FlowuiConfiguration.class})
@PropertySource(name = "gr.netmechanics.jmix.appcommons", value = "classpath:/gr/netmechanics/jmix/appcommons/module.properties")
@MessageSourceBasenames("gr/netmechanics/jmix/appcommons/countries_messages")
public class JmixAppCommonsConfiguration {

    @Bean
    public ComponentRegistration viewLink() {
        return ComponentRegistrationBuilder.create(ViewLink.class)
            .withComponentLoader("viewLink", ViewLinkLoader.class)
            .build();
    }
}
