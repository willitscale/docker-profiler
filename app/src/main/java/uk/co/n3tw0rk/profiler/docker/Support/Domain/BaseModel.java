package uk.co.n3tw0rk.profiler.docker.Support.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    private String id;
    private String name;
}
