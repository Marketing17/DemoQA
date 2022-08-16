package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperStudent student;

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://demoqa.com/automation-practice-form");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        student = new HelperStudent(wd);
    }

    public void stop(){
       // wd.quit();
    }

    public HelperStudent getStudent() {
        return student;
    }
}