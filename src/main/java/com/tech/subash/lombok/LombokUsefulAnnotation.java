package com.tech.subash.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class LombokUsefulAnnotation {

    public static void main(String[] args) {

        try {
            @Cleanup InputStream input = new FileInputStream("C:\\Users\\subas\\OneDrive\\Desktop\\api-docs.json");
            @Cleanup BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            log.info(e.getMessage());
        }

       /* try {
            Class<?> clazz = Class.forName("com.example.MyClass");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }*/
         loadClass();
         noramlCalls();

    }

    @SneakyThrows
    public static void loadClass() {
        Class<?> clazz = Class.forName("com.example.MyClass");
    }

    public static void noramlCalls(){
        System.out.println("normal calls");
    }
}
