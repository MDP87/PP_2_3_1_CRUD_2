package web.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
@EnableJpaRepositories("web.repository")
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class HibernateConfig {

/*
  @Resource
  private Environment env;

  public HibernateConfig(Environment environment) {
      this.env = environment;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(getDataSource());
    em.setPackagesToScan("web.model");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setJpaProperties(getHibernateProperties());
    return em;
  }

  @Bean
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
    dataSource.setUrl(env.getRequiredProperty("db.url"));
    dataSource.setUsername(env.getRequiredProperty("db.username"));
    dataSource.setPassword(env.getRequiredProperty("db.password"));
    dataSource.setInitialSize(Integer.valueOf(env.getRequiredProperty("db.initialSize")));
    dataSource.setMaxIdle(Integer.valueOf(env.getRequiredProperty("db.maxIdle")));
    dataSource.setMinIdle(Integer.valueOf(env.getRequiredProperty("db.minIdle")));
    dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("db.timeBetweenEvictionRunsMillis")));
    dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("db.minEvictableIdleTimeMillis")));
    dataSource.setValidationQuery(env.getRequiredProperty("db.validationQuery"));

    return dataSource;
  }
  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public Properties getHibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dial");
    return hibernateProperties;
  }
*/

  private final Environment env;

  public HibernateConfig(Environment env) {
    this.env = env;
  }

  @Bean
  public DataSource dataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(env.getProperty("db.driver"));
    dataSource.setJdbcUrl(env.getProperty("db.url"));
    dataSource.setUser(env.getProperty("db.username"));
    dataSource.setPassword(env.getProperty("db.password"));
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean(); // HibernateExceptions, PersistenceExceptions... to DataAccessException
    em.setDataSource(dataSource());
    em.setPackagesToScan("web.model");
    em.setJpaVendorAdapter(vendorAdapter);
    return em;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

}
