/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poe_sample;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import static java.lang.Character.isLetter;
import static poe_sample.Student.IDs;

/**
 *   calling class
 *   calling scanner 
 *   assigning scanner value to class 
 *   checking !
 */
public class StudentTest {
    
     @Test
    public void TestSaveStudent() {
        
        Student student = new Student ();
        Scanner dm = new Scanner("135\nCristal Jones\n18\ncristal@gmail1234\nBCAD");
        // \n stands for enter 
        student.SaveStudent(dm);
        
        
        // Check if the data was saved correctly
        assertEquals(1, student.getIDs().size());
        assertEquals(1, student.getNames().size());
        assertEquals(1, student.getAges().size());
        assertEquals(1, student.getEmails().size());
        assertEquals(1, student.getCourses().size());
        
    }//end of tesSaveStudent()
    
     @Test
    public void TestSearchStudent(){
        
        Student student = new Student ();
        student.SearchStudent("135");
        assertTrue(0, student.SearchStudent("135"));
   
    }//end of TestSearchStudent() 
    
     @Test
    public void TestSearchStudent_StudentNotFound(){
        
      Student student = new Student ();
      Scanner dm = new Scanner("135\nCristal Jones\n18\ncristal@gmail1234\nBCAD");
      student.SaveStudent(dm);
      assertFalse(student.IDs.contains(13));
      //13 is the example Id number given to the unit test
      //it will compare this to the ID number given in TestSearchStudent() and display the invalid ID number message 
      
     }//end of TestSearchStudent_StudentNotFound()
    
     @Test
    public void TestDeleteStudent(){
        
      Student student = new Student ();
      Scanner dm = new Scanner("135\nCristal Jones\n18\ncristal@gmail1234\nBCAD");
      student.SaveStudent(dm);
      student.removeIDs("135");
      assertFalse(student.IDs.contains(1));
      
}//end of TestDeleteStudent()
    
     @Test
    public void TestDeleteStudent_StudentNotFound(){
        
        Student student = new Student ();
        Scanner dm = new Scanner("135\nCristal Jones\n18\ncristal@gmail1234\nBCAD");
        student.SaveStudent(dm);
        student.removeIDs(dm);
        assertFalse(student.IDs.contains(1));
        
    }//end of TestDeleteStudent_StudentNotFound()
    
     @Test 
    public void TestStudentAge_StudentAgeValid(){
        
       Student student = new Student ();
       Scanner dm = new Scanner("135\nCristal Jones\n18\ncristal@gmail1234\nBCAD");
       student.SaveStudent(dm);  
    }//end of TestStudentAge_StudentAgeValid()
    
     @Test 
    public void TestStudentAge_StudentAgeInvalid(){
        
       Student student = new Student ();
       Scanner dm = new Scanner("135\nCristal Jones\n18\ncristal@gmail1234\nBCAD");
       student.SaveStudent(dm);
       int age = 16;
       boolean isValidAge = false; 
       assertTrue(Student.isValidAge(age));
       
    }//end of TestStudentAge_StudentAgeInvalid()
    
     @Test 
    public void TestStudentAge_StudentAgeInvalidCharacter(){
        
       Student student = new Student ();
       String value= "d";
       int valueAge = 18;
       assertTrue(Student.isLetter(value));   //true because a letter was entered  
       assertFalse(Student.isLetter(valueAge));      //false because a number was entered 
       
       //https://www.javatpoint.com/post/java-character-isletter-method#:~:text=The%20isLetter(char%20ch)%20method,type%20provided%20by%20the%20Character.
       //why assertTrue: . public static void assertTrue(boolean condition) 
    }  //end of TestStudentAge_StudentAgeInvalidCharacter() 
    
}//end of class
