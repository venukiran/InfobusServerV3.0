package com.slt.infobus;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
@PropertySource(value="classpath:infobus.properties")
public class IBConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
    	.allowedOrigins("*")
    	.allowedMethods("GET", "POST", "OPTIONS", "PUT","DELETE")
        .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                "Access-Control-Request-Headers")
        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
        .allowCredentials(true).maxAge(3600);
    }

	@Value("${ib.datasource.driver}")
	private String dbDriver;
	
	@Value("${ib.datasource.url}")
	private String dbUrl;
	
	@Value("${ib.datasource.username}")
	private String dbUser;
	
	@Value("${ib.datasource.password}")
	private String dbPassword;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl;
	
	@Value("${ib.video.path}")
	private String vidPath;
	
	@Value("${ib.server.loc.id}")
	private String locId;
	
	@Value("${server.sync.time}")
	private Integer syncTime;
	
	@Value("${ib.dreamstep.url}")
	private String dreamStepurl;
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*@Bean
	DataSource getDataSource(){
	    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	    return dataSourceLookup.getDataSource("java:comp/env/jdbc/InfoBus");
	}*/
	
	
	public String getDbDriver() {
		return dbDriver;
	}

	public String getDreamStepurl() {
		return dreamStepurl;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public String getDialect() {
		return dialect;
	}

	public String getShowSql() {
		return showSql;
	}

	public String getHbm2ddl() {
		return hbm2ddl;
	}

	public String getVidPath() {
		return vidPath;
	}

	public String getLocId() {
		return locId;
	}
	
	public int getSyncTime() {
		return syncTime;
	}

	@Bean
	public JpaTransactionManager jpaTransactionManager(){
		JpaTransactionManager jtManager = new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
		return jtManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		    
		    entityManagerFactory.setDataSource(dataSource());
		    // Classpath scanning of @Component, @Service, etc annotated class
		    entityManagerFactory.setPackagesToScan("com.slt.infobus");
		    entityManagerFactory.setPersistenceUnitName("InfobusUnit");
		  //  entityManagerFactory.setPersistenceXmlLocation("META-INF/");		    
		    return entityManagerFactory;
	}
	/**
	   * DataSource definition for database connection. Settings are read from
	   * the application.properties file (using the env object).
	   */
	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(dbDriver);
	    dataSource.setUrl(dbUrl);
	    dataSource.setUsername(dbUser);
	    dataSource.setPassword(dbPassword);
	    return dataSource;
	  }

	 	  /**
	   * PersistenceExceptionTranslationPostProcessor is a bean post processor
	   * which adds an advisor to any bean annotated with Repository so that any
	   * platform-specific exceptions are caught and then rethrown as one
	   * Spring's unchecked data access exceptions (i.e. a subclass of 
	   * DataAccessException).
	   */
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }
}