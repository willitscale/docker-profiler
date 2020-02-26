package uk.co.n3tw0rk.profiler.docker.Stats.Repositories;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import uk.co.n3tw0rk.profiler.docker.Containers.Repository.ContainerRepository;
import uk.co.n3tw0rk.profiler.docker.Stats.Models.ContainerStats;
import uk.co.n3tw0rk.profiler.docker.Containers.Models.Container;

import java.util.concurrent.ConcurrentMap;

@Component
public class StatsRepository {

    private SimpMessagingTemplate simpMessagingTemplate;
    private ContainerRepository containerRepository;

    @Autowired
    public StatsRepository(SimpMessagingTemplate simpMessagingTemplate, ContainerRepository containerRepository) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.containerRepository = containerRepository;
    }

    public Container getOrCreateStatsContainer(
            String id,
            String name,
            String cpuPercentage,
            String memoryUsage,
            String memoryPercentage,
            String netIo,
            String blockIo,
            int pids
    ) {
        Container container = this.containerRepository.getOrCreateContainer(id, name);

        if (null == container) {
            container = new Container();
            container.setId(id);
            container.setName(name);
            container.setCurrentContainerStats(new ContainerStats());
        }

        container.getCurrentContainerStats().setCpuPercentage(cpuPercentage);
        container.getCurrentContainerStats().setMemoryUsage(memoryUsage);
        container.getCurrentContainerStats().setMemoryPercentage(memoryPercentage);
        container.getCurrentContainerStats().setNetIo(netIo);
        container.getCurrentContainerStats().setBlockIo(blockIo);
        container.getCurrentContainerStats().setPids(pids);

        try {
            container.getContainerStatsHistory().put(
                    "",
                    (ContainerStats) container.getCurrentContainerStats().clone())
            ;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        this.simpMessagingTemplate.convertAndSend("/topic/docker/stats", container.getCurrentContainerStats());

        return container;
    }
}
