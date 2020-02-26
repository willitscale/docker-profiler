package uk.co.n3tw0rk.profiler.docker.Containers.Repository;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import uk.co.n3tw0rk.profiler.docker.Containers.Models.Container;

import java.util.concurrent.ConcurrentMap;

@Component
public class ContainerRepository {

    private ConcurrentMap<String, Container> containerMap = Maps.newConcurrentMap();

    public Container getContainer(String id) {
        return this.containerMap.get(id);
    }

    public Container getOrCreateContainer(String id, String name) {
        Container container = this.getContainer(id);

        if (null == container) {
            container = new Container();
            container.setId(id);
            container.setName(name);

            this.createContainer(id, container);
        }

        return container;
    }

    public void createContainer(String id, Container container) {
        this.containerMap.put(id, container);
    }

    public Container removeContainer(String id) {
        return this.containerMap.remove(id);
    }
}
