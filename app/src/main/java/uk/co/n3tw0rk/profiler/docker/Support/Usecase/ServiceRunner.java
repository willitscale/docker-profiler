package uk.co.n3tw0rk.profiler.docker.Support.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import uk.co.n3tw0rk.profiler.docker.Stats.Runners.StatsThread;

import java.util.concurrent.Executor;

@Service
public class ServiceRunner {

    private Executor executor;
    private StatsThread statsThread;

    @Autowired
    public ServiceRunner(
            ThreadPoolTaskExecutor threadPoolTaskExecutor,
            StatsThread statsThread
    ) {
        this.executor = threadPoolTaskExecutor;
        this.statsThread = statsThread;
    }

    public void start() {
        this.executor.execute(this.statsThread);
    }
}
