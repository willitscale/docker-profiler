package uk.co.n3tw0rk.profiler.docker.Support.Usecase;

import org.springframework.stereotype.Component;

@Component
public class Formatter {

    public static String SPLITTER = "||";

    public String getFormat(String[] fields) {
        StringBuilder format = new StringBuilder();
        for (String field : fields) {
            if (0 < format.length()) {
                format.append(SPLITTER);
            }

            format.append("{{.")
                    .append(field)
                    .append("}}");
        }

        return format.toString();
    }
}
