package tests;

import models.Student;
import org.testng.annotations.BeforeMethod;

public class StudentFormTest extends TestBase {


    @BeforeMethod
    public void preCondition(){
        app.getStudent().selectItemForms();
        app.getStudent().selectPracticeForm();
        app.getStudent().hideFooter();
    }

    public void studentFormTest(){
        Student model = Student.builder()
                .firstName("Joe")
                .lastName("Doe")
                .email("john@mail.com")
                .gender("Male")
                .phone("1234567890")
                .birthday("29 06 2000")
                .subject("Maths,Physics")
                .hobbies("Sports")
                .address("Main street, 5")
                .state("NCR")
                .city("Delhi")
                .build();

        app.getStudent().fillForm(model);
        app.getStudent().uploadPicture();
    }

}
