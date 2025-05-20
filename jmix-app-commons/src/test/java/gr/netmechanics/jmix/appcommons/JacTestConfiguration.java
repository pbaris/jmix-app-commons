package gr.netmechanics.jmix.appcommons;

import javax.sql.DataSource;

import io.jmix.core.annotation.JmixModule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(JmixAppCommonsConfiguration.class)
@PropertySource("classpath:/gr/netmechanics/jmix/appcommons/test-app.properties")
@JmixModule(id = "gr.netmechanics.jmix.appcommons.test", dependsOn = JmixAppCommonsConfiguration.class)
public class JacTestConfiguration {

    @Bean
    @Primary
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }
}
