package uk.co.n3tw0rk.profiler.docker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        Process process = Runtime.getRuntime().exec("docker stats --all");

        InputStream inputStream = process.getInputStream();

        InputStreamReader isReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(isReader);
        String str;

        while((str = reader.readLine())!= null){
            System.out.println(str);
        }
    }

}