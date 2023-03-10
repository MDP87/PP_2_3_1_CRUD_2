package web.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class HibernateConfig {
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
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
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
