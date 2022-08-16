package manager;

import models.Student;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HelperStudent extends HelperBase{

    public HelperStudent(WebDriver wd) {
        super(wd);
    }


    public void selectItemForms(){

        if(isElementPresent(By.id("adplus-anchor"))){
            hideAds();
        }

        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    public void selectPracticeForm(){
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
//        typeBDay(model.getBirthday());
        BDaySelect(model.getBirthday());
        addSubject(model.getSubject());
        selectHobby(model.getHobbies());
        type(By.id("currentAddress"), model.getAddress());
        typeState(model.getState());
        typeCity(model.getCity());
    }

    public void typeCity(String state){
        WebElement element = wd.findElement(By.id("react-select-4-input"));
        element.sendKeys(state);
        element.sendKeys(Keys.ENTER);
        pause(3000);
    }


    public void typeState(String state){
//        Dimension dimension = wd.manage().window().getSize();
//        System.out.println(dimension.height + "," + dimension.width);
//        scroll(0, dimension.height / 4);
        WebElement element = wd.findElement(By.id("react-select-3-input"));
        element.sendKeys(state);
        element.sendKeys(Keys.ENTER);
        pause(3000);
    }

    public void selectHobby(String hobbies){
        String[] all = hobbies.split(",");
        for (String hobby : all) {
            switch (hobby) {
                case "Sports": click(By.xpath("//label[@for='hobbies-checkbox-1']")); break;
                case "Reading": click(By.xpath("//label[@for='hobbies-checkbox-2']")); break;
                case "Music": click(By.xpath("//label[@for='hobbies-checkbox-3']")); break;
            }
        }
    }

    public void addSubject(String subject){
        String[] subjects = subject.split(",");
        String locator = "subjectsInput";
        click(By.id(locator));
        for(String sub : subjects){
            wd.findElement(By.id(locator)).sendKeys(sub);
            wd.findElement(By.id(locator)).sendKeys(Keys.ENTER);
            // pause(3000);
        }
    }
    public void BDaySelect(String birthday){
        String[] date = birthday.split(" ");
        WebElement BDay = wd.findElement(By.id("dateOfBirthInput"));
        BDay.click();
        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select")))
                .selectByValue("" + (Integer.parseInt(date[1])-1));
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select")))
                .selectByValue(date[2]);
        //click(By.xpath("//div[text()='" + date[0] + "']"));
        String locator = String.format("//div[text()='%s']",date[0]);
        List<WebElement> list = wd.findElements(By.xpath(locator));
        if(list.size() > 1 && Integer.parseInt(date[0]) > 15){
            list.get(1).click();
        } else {
            list.get(0).click();
        }
        // pause(3000);
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
            click(By.xpath("//label[.='Male']"));
        } else if(gender.equals("Female")){
            click(By.xpath("//label[.='Female']"));
        } else {
            click(By.xpath("//label[.='Other']"));
        }
    }
}
