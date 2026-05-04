package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        //Deserialization.
       ObjectMapper mapper=new ObjectMapper();
       //Read JSON from a source and convert it into an object of a given class.
         Student student=mapper.readValue(new File("data/sample.json"),Student.class);


        System.out.println("ID = " + student.getId());
        System.out.println("First Name = " + student.getFirstName());
        System.out.println("Last Name = " + student.getLastName());

        //Serialization
        //Convert a Java object into JSON and write it to a file, or write it to a string.
        // if file is not exist it will create a new file and write the data into it.
        //else it will overwrite the existing file with new data.
        student.setId(5);
        student.setFirstName("Sara");
        student.setLastName("Ali");
        mapper.writeValue(new File("data/sample1.json"),student);
        System.out.println("JSON file created!");

    }



}
