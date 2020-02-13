package uk.co.n3tw0rk.profiler.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@ComponentScan(value = {
        "uk.co.n3tw0rk.profiler.docker.Stats"
})
public class Main {

    private ThreadPoolExecutor threadPoolExecutor;

    public Main(ThreadPoolExecutor threadPoolExecutor, ) {

    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}