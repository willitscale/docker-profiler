package uk.co.n3tw0rk.profiler.docker.Stats.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class BaseStats {
    private String id;
    private String name;
}
