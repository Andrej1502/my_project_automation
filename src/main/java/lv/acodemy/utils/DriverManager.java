package lv.acodemy.utils;

import org.openqa.selenium.chrome.ChromeDriver;



public class DriverManager {

    private static final ThreadLocal<ChromeDriver> driver = ThreadLocal.withInitial(ChromeDriver::new);

    public static ChromeDriver getDriver() {
        return driver.get();
    }
    public static void closeDriver() {
        if (getDriver() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
