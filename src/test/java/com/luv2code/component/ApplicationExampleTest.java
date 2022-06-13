package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class ApplicationExampleTest {


    private static int count = 0;


    @Value("${info.app.name}")
    private String appinfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;


    @Autowired
    CollegeStudent student;


    @Autowired
    StudentGrades studentGrades;


    @Test
    public void test() {

        Assertions.assertTrue(true);


    }


    @BeforeEach
    public void beforeEach() {
        count = count + 1;
        System.out.println("Testing" + appinfo + "which is" + appDescription +
                "Version " + appVersion + "Execution of Method" + count);

        student.setFirstname("Priyam");
        student.setLastname("Dua");
        student.setEmailAddress("priyamduua26@gmail.com");
        studentGrades.setMathGradeResults(new ArrayList<Double>(Arrays.asList(100.2, 8.555, 76.12, 91.40)));
        student.setStudentGrades(studentGrades);
    }



}
