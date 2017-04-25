package com.lips.web.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by qiang on 2017/4/24.
 */
@Configuration
@AutoConfigureAfter({ DruidDataSourceConfiguration.class })
@MapperScan(basePackages={"com.lips.dao.lipsAdmin"})
public class MybatisConfiguration implements TransactionManagementConfigurer,EnvironmentAware {
    private static Log logger = LogFactory.getLog(MybatisConfiguration.class);
    private RelaxedPropertyResolver propertyResolver;
    @Resource(name="dataSource")
    private DataSource dataSource;

    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "mybatis.");
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(dataSource);
            bean.setTypeAliasesPackage(propertyResolver.getProperty("type-aliases-package"));
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            bean.setMapperLocations(resolver.getResources(propertyResolver.getProperty("mapperLocations")));
            bean.setConfigLocation(resolver.getResource(propertyResolver.getProperty("configLocation")));
            return bean.getObject();
            } catch (Exception e) {
                logger.error(e);
                return null;
            }
    }
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
