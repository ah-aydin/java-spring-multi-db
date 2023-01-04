package com.kebab.multidb.configuration;

import com.kebab.multidb.college.entity.College;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.kebab.multidb.college.repository",
    entityManagerFactoryRef = "collegeEntityManagerFactory",
    transactionManagerRef = "collegeTransactionManager"
)
public class CollegeDataSourceConfiguration {
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.college")
    public DataSourceProperties collegeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource collegeDataSource() {
        return collegeDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "collegeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean collegeEntityManagerFactoryBean(
        EntityManagerFactoryBuilder builder
    ) {
        return builder.dataSource(collegeDataSource()).packages(College.class).build();
    }

    @Primary
    @Bean(name = "collegeTransactionManager")
    public PlatformTransactionManager collegeTransactionManager(
        final @Qualifier("collegeEntityManagerFactory") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
    ) {
        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
    }
}
