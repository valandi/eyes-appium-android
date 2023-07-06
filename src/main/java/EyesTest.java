import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import com.applitools.eyes.appium.Eyes;



public class EyesTest {

    public static void main(String[] args) throws Exception {

        // Set desired capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "device_name");
        capabilities.setCapability("platformVersion", "platform_version");
        //NOTE: 📣 Download this app from https://applitools.jfrog.io/artifactory/Examples/app-debug.apk
        capabilities.setCapability("app", "path_to_apk");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("automationName", "UiAutomator2");

        // Open the app.
        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Initialize the eyes SDK and set your private API key.
        Eyes eyes = new Eyes();
        eyes.setApiKey("YOUR_API_KEY");

        eyes.setForceFullPageScreenshot(true);

        try {

            // Start the test.
            eyes.open(driver, "Contacts!", "My first Appium native Java test!");

            // Visual validation.
            eyes.checkWindow("Contact list!");

            // End the test.
            eyes.close();

        } finally {

            // Close the app.
            driver.quit();

            // If the test was aborted before eyes.close was called, ends the test as aborted.
            eyes.abortIfNotClosed();

        }

    }

}
