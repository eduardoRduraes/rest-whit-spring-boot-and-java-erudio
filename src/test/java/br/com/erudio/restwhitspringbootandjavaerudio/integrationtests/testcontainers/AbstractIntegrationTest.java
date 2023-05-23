package br.com.erudio.restwhitspringbootandjavaerudio.integrationtests.testcontainers;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{


        static PostgreSQLContainer<?> postgreSQL = new PostgreSQLContainer<>("postgres:15.2");

        public static void startContainer(){
            Startables.deepStart(Stream.of(postgreSQL)).join();
        }

        public Map<String, String> createConnectionConfiguration(){
            return Map.of(
                    "spring.datasource.url",postgreSQL.getJdbcUrl(),
                    "spring.datasource.username",postgreSQL.getUsername(),
                    "spring.datasource.password",postgreSQL.getPassword()
            );
        }

        @SuppressWarnings({"unchecked","rawtypes"})
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            startContainer();

            ConfigurableEnvironment environment = applicationContext.getEnvironment();

            MapPropertySource testcontainers = new MapPropertySource(
                    "testcontainers",
                    (Map) createConnectionConfiguration()
            );
            environment.getPropertySources().addFirst(testcontainers);
        }
    }
}
