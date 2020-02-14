package uk.co.n3tw0rk.profiler.docker.Support.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class ThreadConfiguration {
    private int coreSize = 1;
    private int maxSize = 1;
    private int queueCapacity = 1;
    private String prefix = "app__";
}