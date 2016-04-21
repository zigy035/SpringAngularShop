package com.spring.angular.shop.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.spring.angular.shop.dao.CartDAO;
import com.spring.angular.shop.dao.ProductDAO;

@Configuration
public class AppConfig {
	
	@Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3306/coolshop");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
      SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
      sqlSessionFactory.setDataSource(dataSource());
      sqlSessionFactory.setTypeAliasesPackage("com.spring.angular.shop.model");
      SqlSessionFactory factory = (SqlSessionFactory) sqlSessionFactory.getObject();
      factory.getConfiguration().addMapper(CartDAO.class);
      factory.getConfiguration().addMapper(ProductDAO.class);
      return factory;
      
    }
    
    @Bean 
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
    	return new SqlSessionTemplate(sqlSessionFactory());
    }
    
    @Bean
	public CartDAO cartDAO() throws Exception {
        return sqlSessionTemplate().getMapper(CartDAO.class);
	}
	
	@Bean
	public ProductDAO productDAO() throws Exception {
        return sqlSessionTemplate().getMapper(ProductDAO.class);
	}
	
}
