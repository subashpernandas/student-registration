package com.tech.subash.exception;

import com.tech.subash.dto.Student;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckException {
    public static void main(String[] args) {
        try {
            fileWrite();
            fileBufferedReader();
            classNotFoundException();
            sqlConnection();
            reflectionException();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void fileWrite() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(new File(""));
            fileWriter.write("this is write");
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static List<String> fileBufferedReader() throws FileNotFoundException, IOException {
        System.out.println("reader comes");

       try( BufferedReader  fileReader = new BufferedReader(new FileReader(new File("")))) {
           String character;
           List<String> listOfLines = new ArrayList<>();
           while ((character = fileReader.readLine()) != null) {
               listOfLines.add(character);
           }
           return listOfLines;
       } catch (Exception e) {
           System.out.println(e.getLocalizedMessage());
       }
        return List.of();
    }


    public static Class<?> classNotFoundException() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println("comes into class not found");
        try {
            Class<?> checkException = Class.forName("com.example.demo.CheckException");
            CheckException obj = (CheckException) checkException.newInstance();
            return obj.getClass();
        } catch(Exception e){
            System.out.println("Class Not Found Error" +e.getLocalizedMessage());
        }
        return null;
    }

    public static Connection sqlConnection() throws ClassNotFoundException, SQLException {
        System.out.println("sql connection");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
        } catch (Exception e) {
            System.out.println("DB error" + e.getLocalizedMessage());
        }
        return null;
    }

    public static void reflectionException() throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Object[][] properties = {
                {"name", "John"},
                {"age", 20},
                {"grade", "A"}
        };
        for (Object[] prop : properties) {
            String fieldName = (String) prop[0];
            Object fieldValue = prop[1];

            Field field = Student.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(student, fieldValue);
        }

        Field field = Student.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(student, "subahs.ps");
        System.out.println(student.getName());

    }
}
