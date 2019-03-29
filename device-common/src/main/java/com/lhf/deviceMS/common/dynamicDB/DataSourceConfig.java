package com.lhf.deviceMS.common.dynamicDB;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author lhf
 * @Description
 * @Date 2019/2/20 11:43
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.ds1.url}")
    private String ds1Url;
    @Value("${spring.datasource.ds2.url}")
    private String ds2Url;
    @Value("${spring.datasource.ds3.url}")
    private String ds3Url;

    @Value("${spring.datasource.ds1.username}")
    private String ds1Username;
    @Value("${spring.datasource.ds2.username}")
    private String ds2Username;
    @Value("${spring.datasource.ds3.username}")
    private String ds3Username;

    @Value("${spring.datasource.ds1.password}")
    private String ds1Password;
    @Value("${spring.datasource.ds2.password}")
    private String ds2Password;
    @Value("${spring.datasource.ds3.password}")
    private String ds3Password;

    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;

    @Value("${spring.datasource.minIdle}")
    private Integer minIdle;

    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;

    @Value("${spring.datasource.maxWait}")
    private Integer maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private Boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private Boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private Boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private Boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${mybatis.config-location}")
    private String sqlmapConfigPath;

    @Value("${mybatis.mapper-locations}")
    private String mapperLocation;


    @Bean(name = DataSourceType.MASTER)
    @Primary
    public DataSource master(){
        DruidDataSource source = new DruidDataSource();
        //基本属性 url、user、password
        source.setUrl(ds1Url);
        source.setUsername(ds1Username);
        source.setPassword(ds1Password);
        //配置初始化大小、最小、最大
        source.setInitialSize(initialSize);
        source.setMinIdle(minIdle);
        source.setMaxActive(maxActive);
        //配置获取连接等待超时的时间
        source.setMaxWait(maxWait);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        source.setValidationQuery(validationQuery);
        source.setTestWhileIdle(testWhileIdle);
        source.setTestOnBorrow(testOnBorrow);
        source.setTestOnReturn(testOnReturn);
        //打开PSCache，并且指定每个连接上PSCache的大小  如果用Oracle，则把poolPreparedStatements配置为true，mysql可以配置为false
        source.setPoolPreparedStatements(poolPreparedStatements);
        source.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            //配置监控统计拦截的filters
            source.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //超过时间限制是否回收
        source.setRemoveAbandoned(true);
        //超时时间；单位为秒。180秒=3分钟
        source.setRemoveAbandonedTimeout(180);
        //关闭abanded连接时输出错误日志
        source.setLogAbandoned(true);
        return source;
    }

    @Bean(name = DataSourceType.SLAVE1)
    public DataSource slave1(){
        DruidDataSource source = new DruidDataSource();
        //基本属性 url、user、password
        source.setUrl(ds2Url);
        source.setUsername(ds2Username);
        source.setPassword(ds2Password);
        //配置初始化大小、最小、最大
        source.setInitialSize(initialSize);
        source.setMinIdle(minIdle);
        source.setMaxActive(maxActive);
        //配置获取连接等待超时的时间
        source.setMaxWait(maxWait);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        source.setValidationQuery(validationQuery);
        source.setTestWhileIdle(testWhileIdle);
        source.setTestOnBorrow(testOnBorrow);
        source.setTestOnReturn(testOnReturn);
        //打开PSCache，并且指定每个连接上PSCache的大小  如果用Oracle，则把poolPreparedStatements配置为true，mysql可以配置为false
        source.setPoolPreparedStatements(poolPreparedStatements);
        source.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            //配置监控统计拦截的filters
            source.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //超过时间限制是否回收
        source.setRemoveAbandoned(true);
        //超时时间；单位为秒。180秒=3分钟
        source.setRemoveAbandonedTimeout(180);
        //关闭abanded连接时输出错误日志
        source.setLogAbandoned(true);
        return source;
    }

    @Bean(name = DataSourceType.SLAVE2)
    public DataSource slave2(){
        DruidDataSource source = new DruidDataSource();
        //基本属性 url、user、password
        source.setUrl(ds3Url);
        source.setUsername(ds3Username);
        source.setPassword(ds3Password);
        //配置初始化大小、最小、最大
        source.setInitialSize(initialSize);
        source.setMinIdle(minIdle);
        source.setMaxActive(maxActive);
        //配置获取连接等待超时的时间
        source.setMaxWait(maxWait);
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        source.setValidationQuery(validationQuery);
        source.setTestWhileIdle(testWhileIdle);
        source.setTestOnBorrow(testOnBorrow);
        source.setTestOnReturn(testOnReturn);
        //打开PSCache，并且指定每个连接上PSCache的大小  如果用Oracle，则把poolPreparedStatements配置为true，mysql可以配置为false
        source.setPoolPreparedStatements(poolPreparedStatements);
        source.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            //配置监控统计拦截的filters
            source.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //超过时间限制是否回收
        source.setRemoveAbandoned(true);
        //超时时间；单位为秒。180秒=3分钟
        source.setRemoveAbandonedTimeout(180);
        //关闭abanded连接时输出错误日志
        source.setLogAbandoned(true);
        return source;
    }


    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicRoutingDataSource = new DynamicDataSource();
        //配置多数据源
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceType.MASTER, master());
        dataSourceMap.put(DataSourceType.SLAVE1, slave1());
        dataSourceMap.put(DataSourceType.SLAVE2, slave2());
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        // 将 master 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(master());
        return dynamicRoutingDataSource;
    }


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);
        sqlSessionFactoryBean.setConfigLocation( new ClassPathResource(sqlmapConfigPath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperLocation;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return  sqlSessionFactoryBean;
    }

    @Bean(name = "jdbcTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dynamicDataSource());
        return manager;
    }

    /**
     * 配置事务的传播特性
     */
    @Bean(name = "txAdvice")
    public TransactionInterceptor txAdvice(){
        TransactionInterceptor interceptor = new TransactionInterceptor();
        interceptor.setTransactionManager(transactionManager());
        Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("save*","PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("add*","PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("insert*","PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("update*","PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("delete*","PROPAGATION_REQUIRED");
        transactionAttributes.setProperty("*","readOnly");
        interceptor.setTransactionAttributes(transactionAttributes);
        return interceptor;
    }

    @Bean(name = "txAdviceAdvisor")
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        String transactionExecution = "execution(* com.lhf..service.*.*(..))";
        pointcut.setExpression(transactionExecution);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

}
