package uk.co.n3tw0rk.profiler.docker.Stats.Repositories;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import uk.co.n3tw0rk.profiler.docker.Stats.Models.ContainerStats;

import java.util.concurrent.ConcurrentMap;

@Component
public class StatsRepository {

    private ConcurrentMap<String, ContainerStats> containerMap = Maps.newConcurrentMap();

    public StatsRepository() {

    }

    public ContainerStats getOrCreateStatsContainer(
            String id,
            String name,
            String cpuPercentage,
            String memoryUsage,
            String memoryPercentage,
            String netIo,
            String blockIo,
            int pids
    ) {
        ContainerStats containerStats = this.containerMap.get(id);
        if (null == containerStats) {
            containerStats = new ContainerStats();
        }

        containerStats.setId(id);
        containerStats.setName(name);
        containerStats.setCpuPercentage(cpuPercentage);
        containerStats.setMemoryUsage(memoryUsage);
        containerStats.setMemoryPercentage(memoryPercentage);
        containerStats.setNetIo(netIo);
        containerStats.setBlockIo(blockIo);
        containerStats.setPids(pids);

        return containerStats;
    }
}
