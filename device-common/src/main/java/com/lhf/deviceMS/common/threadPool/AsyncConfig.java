package com.lhf.deviceMS.common.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步任务配置
 */
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {
    @Autowired
    private AsyncProperties asyncProperties;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(asyncProperties.getCorePoolSize());
        executor.setMaxPoolSize(asyncProperties.getMaxPoolSize());
        executor.setQueueCapacity(asyncProperties.getQueueCapacity());
        executor.setKeepAliveSeconds(asyncProperties.getKeepAliveSeconds());
        executor.setThreadNamePrefix(asyncProperties.getThreadNamePrefix());
        /*
            线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy
            AbortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常
            CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度
            DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行
            DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行
        */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable e, Method method, Object... params) {
                logger.error("error method={},error param = {},error msg={}",method,params,e);
            }
        };
    }
}
