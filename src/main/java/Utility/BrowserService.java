package Utility;

import com.microsoft.playwright.*;
import java.net.URL;

public class BrowserService {

    public static Browser browser;
    public static Page page;
    public static URL baseUrl;

    public static void initBrowser() {
        String browserName = ConfigReader.get("browser");
        boolean isHeadless = Boolean.parseBoolean(ConfigReader.get("headless"));
        String url = ConfigReader.get("base.url");

        Playwright playwright = Playwright.create();

        if (browserName.equalsIgnoreCase("chromium")) {
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(isHeadless)
            );
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(isHeadless)
            );
        } else {
            throw new RuntimeException("Unsupported browser: " + browserName);
        }

        page = browser.newPage();
        page.navigate(url);  // now baseUrl is properly initialized
    }
}
