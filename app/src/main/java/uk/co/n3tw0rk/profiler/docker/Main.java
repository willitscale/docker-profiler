package uk.co.n3tw0rk.profiler.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import uk.co.n3tw0rk.profiler.docker.Support.Usecase.ServiceRunner;

@SpringBootApplication
@ComponentScan(value = {
        "uk.co.n3tw0rk.profiler.docker.Stats",
        "uk.co.n3tw0rk.profiler.docker.WebSocket",
        "uk.co.n3tw0rk.profiler.docker.Support"
})
public class Main {

    @Autowired
    public Main(ServiceRunner serviceRunner) {
        serviceRunner.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}