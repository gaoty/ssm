package configuration;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author gaoty
 * @version V1.0
 * @decription
 * @create on 2018/3/23 14:35
 */
@Slf4j
@Configuration
public class DBConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws SQLException{
        log.info("----------配置datasource信息开始");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("jdbc.url"));
        druidDataSource.setUsername(environment.getProperty("jdbc.username"));
        druidDataSource.setPassword(environment.getProperty("jdbc.password"));
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxActive(50);
        druidDataSource.setMinIdle(0);
        druidDataSource.setMaxWait(5000);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //用来检测连接是否有效的sql，要求是一个查询语句。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
        druidDataSource.setValidationQuery("select 1");
        //建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setDefaultAutoCommit(false);
        //打开PSCache，并且指定每个连接上PSCache的大小
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //自动清除无用连接
        druidDataSource.setRemoveAbandoned(true);
        //清除无用连接的等待时间
        druidDataSource.setRemoveAbandonedTimeout(7200);
        druidDataSource.setFilters("stat");
        druidDataSource.setConnectionInitSqls(Arrays.asList("set names utf8mb4"));
        log.info("----------配置datasource信息结束");
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws SQLException,IOException{
        log.info("----------配置sqlSessionFactory信息开始");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:spring/mybatis-config.xml"));
        log.info("----------配置sqlSessionFactory信息结束");
        return sqlSessionFactoryBean;
    }

    /**
     * 配置事务管理器
     * @return
     * @throws Exception
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws Exception{
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
