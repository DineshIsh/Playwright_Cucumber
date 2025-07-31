package Page;

import HelperFunctions.Helpers;
import Utility.BrowserService;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class LoginPage {

    private Page page;
    private static LoginPage instance;
    private Helpers helper;

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(Page page) {
        this.page = page;  //this.page = BrowserService.page;  // ✅ Take it directly from BrowserService (optional)
        this.helper = new Helpers();


    }

    public static LoginPage getInstance(Page page) {
        logger.info("Thread:--- " + Thread.currentThread().getName());

        if (instance == null) {
            logger.info("Creating new instance of LoginPage");
            instance = new LoginPage(page);
        } else {
            logger.debug("Reusing existing instance of LoginPage");
        }

        return instance;
    }


    //===========xpath ==============





    public void clickSignIn(String value) throws InterruptedException {
        Locator searchBar = page.locator("//input[@id='twotabsearchtextbox']");
        helper.fill(searchBar, value);
        Thread.sleep(2000);
        helper.enter(searchBar);
    }

}
