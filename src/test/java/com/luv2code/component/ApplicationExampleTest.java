package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.*;
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
        studentGrades.setMathGradeResults(new ArrayList<Double>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);
    }


    @DisplayName("add grade results for students ")
    @Test
    public void Test_addGradeResultsForStudentGradesEquals() {
        {
            Assertions.assertEquals(353.25,studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
        }
    }


    @DisplayName("add grade results for students not equal")
    @Test
    public void Test_addGradeResultsForStudentGradesNotEquals() {
        {
            Assertions.assertEquals(0,studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
        }
    }



    @DisplayName("Is grade greater")
    @Test
    public void TestisGrdeGreaterStudentGrades()
    {
        Assertions.assertTrue(studentGrades.isGradeGreater(80,75),"failure - should be true");
    }



    @DisplayName("is grade greater false")
    @Test
    public void isGradeGreaterStudentGradesFalse() {
        {
            Assertions.assertFalse(studentGrades.isGradeGreater(89,92),"failure - should be false");
        }
    }



    @DisplayName("Check Null for student grades")
    @Test
    public void checkNullForStudentGrades()
    {
        Assertions.assertNull(studentGrades.checkNull(student.getStudentGrades().getMathGradeResults()), "Object should not be null");
    }

}
