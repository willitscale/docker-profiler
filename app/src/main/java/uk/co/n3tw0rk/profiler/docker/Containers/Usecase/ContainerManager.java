package uk.co.n3tw0rk.profiler.docker.Containers.Usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.n3tw0rk.profiler.docker.Support.Usecase.Formatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class ContainerManager {

    private final static String[] FIELDS = new String[]{
            "ID",
            "Image",
            "Command",
            "CreatedAt",
            "Status",
            "RunningFor",
            "Ports",
            "Names",
            "Size",
            "Networks",
            "Mounts",
            "LocalVolumes"
    };

    private Formatter formatter;

    @Autowired
    public ContainerManager(Formatter formatter) {
        this.formatter = formatter;
    }

    public void getContainerList() {

        String command = "docker container ls --no-trunc --all --format " + formatter.getFormat(FIELDS);

        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream inputStream = process.getInputStream();
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            String str;

            while ((str = reader.readLine()) != null) {

                System.out.println(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
