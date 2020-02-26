package uk.co.n3tw0rk.profiler.docker.Containers.Usecase;

import com.google.common.base.Strings;
import org.springframework.stereotype.Component;
import uk.co.n3tw0rk.profiler.docker.Support.Usecase.Formatter;

@Component
public class ContainerParser {

    public ContainerParser() {

    }

    public void parseContainer(String line) {
        if (Strings.isNullOrEmpty(line)) {
            return null;
        }

        String[] parts = line.split(Formatter.SPLITTER);

        if (0 == parts.length) {
            return null;
        }

    }

}
