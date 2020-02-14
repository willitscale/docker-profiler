package uk.co.n3tw0rk.profiler.docker.Support.Usecase;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import uk.co.n3tw0rk.profiler.docker.Support.Domain.ThreadConfiguration;

@Log4j2
@Configuration
public class ThreadPool {
    private ThreadConfiguration threadConfiguration;

    @Autowired
    public ThreadPool(ThreadConfiguration threadConfiguration) {
        this.threadConfiguration = threadConfiguration;
    }

    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadConfiguration.getCoreSize());
        executor.setMaxPoolSize(threadConfiguration.getMaxSize());
        executor.setQueueCapacity(threadConfiguration.getQueueCapacity());
        executor.setThreadNamePrefix(threadConfiguration.getPrefix());
        executor.initialize();
        return executor;
    }
}
