package uk.co.n3tw0rk.profiler.docker.Stats.Usecase;

import com.google.common.base.Strings;
import org.springframework.stereotype.Component;
import uk.co.n3tw0rk.profiler.docker.Containers.Models.Container;
import uk.co.n3tw0rk.profiler.docker.Stats.Repositories.StatsRepository;
import uk.co.n3tw0rk.profiler.docker.Support.Usecase.Formatter;

@Component
public class StatsParser {

    private StatsRepository statsRepository;

    public StatsParser(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public Container parseStatsLine(String line) {
        if (Strings.isNullOrEmpty(line)) {
            return null;
        }

        String[] parts = line.split(Formatter.SPLITTER);

        if (0 == parts.length) {
            return null;
        }

        return this.statsRepository.getOrCreateStatsContainer(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                parts[5],
                parts[6],
                Integer.parseInt(parts[7])
        );
    }
}
