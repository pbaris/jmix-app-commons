package gr.netmechanics.jmix.appcommons;

import java.util.Collections;

import io.jmix.core.annotation.JmixModule;
import io.jmix.core.annotation.MessageSourceBasenames;
import io.jmix.core.impl.scanning.AnnotationScanMetadataReaderFactory;
import io.jmix.eclipselink.EclipselinkConfiguration;
import io.jmix.flowui.FlowuiConfiguration;
import io.jmix.flowui.sys.ActionsConfiguration;
import io.jmix.flowui.sys.ViewControllersConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
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

}
