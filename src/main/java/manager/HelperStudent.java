package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class HelperStudent extends HelperBase{

    public HelperStudent(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms(){
if(isElementPresent(By.id("//div[@id='adplus-anchor']"))){
    hideAds();
}
        click (By.xpath("//div[@class='category-cards']"));

    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }


    public void uploadPicture(){

    }

    public void submit(){
        click(By.id("submit"));
    }


    public void fillForm(Student model) {
        String os = System.getProperty("os.name");
        System.out.println(os);
        type(By.id("firstName"), model.getFirstName());
        type(By.id("lastName"), model.getLastName());
        type(By.id("userEmail"), model.getEmail());
        selectGender(model.getGender());
        type(By.id("userNumber"), model.getPhone());
        typeBDay(model.getBirthday());
//        model.getSubject()
//        model.getHobbies()
        type(By.id("currentAddress"), model.getAddress());
//        model.getState()
//        model.getCity()
    }

    public void typeBDay(String birthday){
        WebElement BDay = wd.findElement(By.id("dateOfBirthInput"));
        BDay.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if(os.startsWith("Windows")){
            BDay.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        } else {
            BDay.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }
        BDay.sendKeys(birthday);
        BDay.sendKeys(Keys.ENTER);

    }

    public void selectGender(String gender){
        if(gender.equals("Male")){
            click(By.xpath("//label[for='gender-radio-1']"));
        } else if(gender.equals("Female")){
            click(By.xpath("//label[for='gender-radio-2']"));
        } else {
            click(By.xpath("//label[for='gender-radio-3']"));
        }
    }
}

