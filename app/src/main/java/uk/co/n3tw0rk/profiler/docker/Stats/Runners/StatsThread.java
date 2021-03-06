package uk.co.n3tw0rk.profiler.docker.Stats.Runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.n3tw0rk.profiler.docker.Stats.Usecase.StatsParser;
import uk.co.n3tw0rk.profiler.docker.Support.Usecase.Formatter;
import uk.co.n3tw0rk.profiler.docker.Support.Usecase.Sleeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class StatsThread implements Runnable {

    private final static String[] FIELDS = new String[]{
            "ID",
            "Name",
            "CPUPerc",
            "MemUsage",
            "MemPerc",
            "NetIO",
            "BlockIO",
            "PIDs"
    };

    private StatsParser statsParser;
    private Sleeper sleeper;
    private Formatter formatter;

    @Autowired
    public StatsThread(StatsParser statsParser, Sleeper sleeper, Formatter formatter) {
        this.statsParser = statsParser;
        this.sleeper = sleeper;
        this.formatter = formatter;
    }

    @Override
    public void run() {

        String command = "docker stats --no-trunc --format " + formatter.getFormat(FIELDS);

        //while(true) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            String str;

            while ((str = reader.readLine()) != null) {
                this.statsParser.parseStatsLine(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.sleeper.sleep(500);
        //}
    }
}
