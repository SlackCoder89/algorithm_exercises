package org.hmk.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9112");
        login(driver);
        applyForPages(driver);
        System.out.println("test");
    }

    private static void login(WebDriver driver) {
        driver.get("https://www.linkedin.com/login/zh-cn?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("hmkwork89@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Hmk260587778");
        WebElement loginButton = driver.findElement(By.className("login__form_action_container"));
        loginButton.click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000 * 10));
    }

    private static void applyForPages(WebDriver driver) throws Exception {
        driver.get("https://www.linkedin.com/jobs/search/?currentJobId=3926278877&distance=25&f_AL=true&f_JT=F&f_WT=3%2C1&geoId=91000000&keywords=java&origin=JOBS_HOME_SEARCH_CARDS");
        Thread.sleep(1000 * 5);
        for (int i = 0; i < 10; ++i) {
            List<WebElement> pages = driver.findElements(By.className("artdeco-pagination__indicator"));
            pages.get(i).click();
            Thread.sleep(1000 * 3);
            applyForPage(driver);
        }
    }

    private static void applyForPage(WebDriver driver) throws InterruptedException {
        List<WebElement> elementList = driver.findElements(By.className("jobs-search-results__list-item"));
        for (WebElement e : elementList) {
            if (e.getText().isEmpty()) {
                continue;
            }
            processJob(driver, e);
        }
    }

    private static void processJob(WebDriver driver, WebElement e) throws InterruptedException {
        List<WebElement> state = e.findElements(By.className("job-card-container__footer-job-state"));
        if (!state.isEmpty()) {
            System.out.println(state.get(0).getText());
            switch (state.get(0).getText()) {
                case "Viewed":
                case "Applied":
                    break;
            }
        } else {
            applyForJob(driver, e);
        }
    }

    private static void applyForJob(WebDriver driver, WebElement jobDescription) throws InterruptedException {
        jobDescription.click();
        Thread.sleep(1000 * 3);
        WebElement applyButton = null;
        try {
            applyButton = driver.findElement(By.className("jobs-apply-button"));
        } catch (Exception e) {
            System.err.println(e);
            return;
        }
        applyButton.click();
        Thread.sleep(1000 * 3);

        while (true) {
            try {
                WebElement nextButton = driver.findElement(By.className("artdeco-button--primary"));
                nextButton.click();
            } catch (Exception e) {
                System.err.println(e);
                Thread.sleep(1000 * 5);
                closeCompletePrompt(driver);
                break;
            }
//            Thread.sleep(1000 * 3);
            if (hasError(driver)) {
                closePrompt(driver);
                break;
            }
        }
    }

    private static void closeCompletePrompt(WebDriver driver) {
        try {
            List<WebElement> closeButton = driver.findElements(By.className("artdeco-button--muted"));
            if (closeButton.isEmpty()) {
                throw new RuntimeException("Can't find close button");
            }
            closeButton.get(0).click();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static boolean hasApplied(WebDriver driver) {
        List<WebElement> sentEle = driver.findElements(By.xpath("//h3[contains(@text, 'Your application was sent to')]"));
        return !sentEle.isEmpty();
    }

    private static void closePrompt(WebDriver driver) {
        List<WebElement> closeButton = driver.findElements(By.className("artdeco-button--muted"));
        if (closeButton.isEmpty()) {
            throw new RuntimeException("Can't find close button");
        }
        closeButton.get(0).click();
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> discardButton = driver.findElements(By.cssSelector("button[data-control-name=\"discard_application_confirm_btn\"]"));
        if (discardButton.isEmpty()) {
            throw new RuntimeException("Can't find discard button");
        }
        discardButton.get(0).click();
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean hasError(WebDriver driver) {
        List<WebElement> errors = driver.findElements(By.className("artdeco-inline-feedback--error"));
        return !errors.isEmpty();
    }
}
