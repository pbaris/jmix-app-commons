package gr.netmechanics.jmix.autoconfigure.appcommons;

import gr.netmechanics.jmix.appcommons.JmixAppCommonsConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({JmixAppCommonsConfiguration.class})
public class JmixAppCommonsAutoConfiguration {
}

