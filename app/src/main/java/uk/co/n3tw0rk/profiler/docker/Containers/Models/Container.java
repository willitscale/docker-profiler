package uk.co.n3tw0rk.profiler.docker.Containers.Models;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uk.co.n3tw0rk.profiler.docker.Support.Domain.BaseModel;
import uk.co.n3tw0rk.profiler.docker.Stats.Models.ContainerStats;

import java.util.concurrent.ConcurrentMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Container extends BaseModel {
    private ContainerStats currentContainerStats;
    private ContainerAttributes containerAttributes;
    private ConcurrentMap<String, ContainerStats> containerStatsHistory = Maps.newConcurrentMap();
}
