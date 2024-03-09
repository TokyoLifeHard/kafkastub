package com.kafkastub.kafkastub.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {
    @Bean(name = "readPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("JDAsync-");
        executor.initialize();
        return executor;
    }

    @Bean(name = "writePoolTaskExecutor")
    public Executor writePoolTaskExecutor() {
        ThreadPoolTaskExecutor writeTaskExecutor = new ThreadPoolTaskExecutor();
        writeTaskExecutor.setCorePoolSize(5);
        writeTaskExecutor.setMaxPoolSize(10);
        writeTaskExecutor.setQueueCapacity(500);
        writeTaskExecutor.setThreadNamePrefix("writesync-");
        writeTaskExecutor.initialize();
        return writeTaskExecutor;
    }
}
