package tests;

import models.Student;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends tests.TestBase {

    @BeforeMethod
    public void preCondition(){
        app.getStudent().hideFooter();
        app.getStudent().selectItemForms();
        app.getStudent().selectPracticeForm();
        app.getStudent().hideFooter();
    }

    @Test
    public void studentFormTest(){
        Student model = Student.builder()
                .firstName("Joe")
                .lastName("Doe")
                .email("john@mail.com")
                .gender("Male")
                .phone("1234567890")
                .birthday("31 08 2022")
                .subject("Maths,Physics")
                .hobbies("Sports,Music")
                .address("Main street, 5")
                .state("NCR")
                .city("Delhi")
                .build();

        app.getStudent().fillForm(model);
        app.getStudent().uploadPicture();
        app.getStudent().submit();

    }
}