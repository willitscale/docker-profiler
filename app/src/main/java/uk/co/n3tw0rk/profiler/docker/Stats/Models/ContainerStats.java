package uk.co.n3tw0rk.profiler.docker.Stats.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainerStats {
    private String id;
    private String name;
    private String cpuPercentage;
    private String memoryUsage;
    private String memoryPercentage;
    private String netIo;
    private String blockIo;
    private int pids;
}
