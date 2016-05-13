package com.test.dbexpand;

import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DruidSettings.class)
public class DbConfiguration {
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(DruidSettings ds) throws Exception{
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(ds.getUsername());
        druidDataSource.setUrl(ds.getUrl());
        druidDataSource.setPassword(ds.getPassword());
        druidDataSource.setFilters(ds.getFilters());
        druidDataSource.setMaxActive(ds.getMaxActive());
        druidDataSource.setInitialSize(ds.getInitialSize());
        druidDataSource.setMaxWait(ds.getMaxWait());
        druidDataSource.setMinIdle(ds.getMinIdle());
        druidDataSource.setTimeBetweenEvictionRunsMillis(ds.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(ds.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(ds.getValidationQuery());
        druidDataSource.setTestWhileIdle(ds.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(ds.isTestOnBorrow());
        druidDataSource.setTestOnReturn(ds.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(ds.isPoolPreparedStatements());
        druidDataSource.setMaxOpenPreparedStatements(ds.getMaxOpenPreparedStatements());
        return druidDataSource;
    }

    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public WallFilter wall(){
        WallFilter wallFilter = new WallFilter();
        return wallFilter;
    }

    @Bean
    public StatFilter stat(DruidSettings ds) {
        StatFilter statFilter = new StatFilter();
        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(ds.getSlowSqlMillis());
        statFilter.setLogSlowSql(ds.isLogSlowSql());
        return statFilter;
    }

    @Bean
    public Slf4jLogFilter log(DruidSettings ds) {
        Slf4jLogFilter logFilter = new Slf4jLogFilter();
        logFilter.setResultSetLogEnabled(ds.isResultSetLogEnabled());
        logFilter.setStatementExecutableSqlLogEnable(ds.isStatementExecutableSqlLogEnable());
        return logFilter;
    }

}
