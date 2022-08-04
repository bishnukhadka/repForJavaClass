package com.acem.db.modifier.impl;

import com.acem.db.model.Student;
import com.acem.db.modifier.FileModifier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileModifierImpl implements FileModifier {
    private final String url;
    private final BufferedWriter bufferedWriter;


    public FileModifierImpl(String url) throws IOException {
        this.url = url;
        this.bufferedWriter = new BufferedWriter(new FileWriter(url));
    }

    @Override
    public Boolean add(Object o) {
        String tempString = o.toString();
        Boolean status = addString(tempString);
        return status;
    }

    @Override
    public Boolean write(List<Object> list) {
        String tempStr;
        for(Object object: list){
            tempStr = object.toString();
            if(add(tempStr)==false)
                    return false;
        }
        return true;
    }

    public Boolean addString(String tempString){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(url));
            bufferedWriter.newLine();
            bufferedWriter.write(tempString);
            return true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean update(Object o) {
        String tempString = o.toString();
        return update(tempString);
    }

    public Boolean update(String tempString){
        Path path = Path.of(url);
        try{
            List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
            //here the Files.readAllLines() doesn't read lines and is empty.
            if (fileContent.isEmpty())
                return false;
            Student student = new Student();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the id: ");
            student.setId(scanner.nextLong());
            scanner.nextLine();
            System.out.print("Enter the name: ");
            student.setName(scanner.nextLine());
            System.out.print("Enter the email: ");
            student.setEmail(scanner.nextLine());
            System.out.print("Enter the contact no: ");
            student.setContactNo(scanner.nextLine());

            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).equals(tempString)) {
                    fileContent.set(i, student.toString());
                    break;
                }
            }
            if(path == Files.write(path, fileContent, StandardCharsets.UTF_8));
                return true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Boolean delete(Object o) {
        String tempString = o.toString();
        return delete(tempString);
    }

    public Boolean delete(String tempString){
        Path path = Path.of(url);
        try{
            List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
            List<String> temp = null;
            for (int i = 0; i < fileContent.size(); i++) {
                if (!fileContent.get(i).equals(tempString)) {
                    temp.add(fileContent.get(i));
                }
            }
            Files.write(path, temp, StandardCharsets.UTF_8);
            return true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
