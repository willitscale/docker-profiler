package uk.co.n3tw0rk.profiler.docker.Stats.Models;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Container extends BaseStats {
    private ContainerStats currentContainerStats;
    private ConcurrentMap<String, ContainerStats> containerStatsHistory = Maps.newConcurrentMap();
}
