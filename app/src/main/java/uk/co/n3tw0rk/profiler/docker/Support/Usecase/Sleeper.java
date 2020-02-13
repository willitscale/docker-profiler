package uk.co.n3tw0rk.profiler.docker.Support.Usecase;

import org.springframework.stereotype.Component;

@Component
public class Sleeper {
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
