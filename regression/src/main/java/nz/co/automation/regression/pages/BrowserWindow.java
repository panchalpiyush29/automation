package nz.co.automation.regression.pages;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BrowserWindow {

  private final String baseUrl;
  private final WebDriver webDriver;

  @Autowired
  public BrowserWindow() {
    this.baseUrl = "http://www.google.co.nz";
    this.webDriver = WebDriverRunner.getWebDriver();
  }

  public void scrollToTop() {
    ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0)");
  }

  public String getFirstTabName() {
    return getTabNames().get(0);
  }

  public void closeOtherTabs(String currentTabName) {
    // close all tabs to the right
    getTabNames().stream()
            .filter(tabName -> !tabName.equalsIgnoreCase(currentTabName))
            .forEach(tabName -> closeTab(tabName));

    // focusZuoraIframe on the current tab
    focusTab(currentTabName);
  }

  public String getCurrentTabUrl() {
    return webDriver.getCurrentUrl();
  }

  public String getNextTabUrl() {
    final String currentTabName = webDriver.getWindowHandle();
    final List<String> tabNames = getTabNames();
    final int size = tabNames.size();
    for (int i = 0; i < size; i++) {
      if (tabNames.get(i).equalsIgnoreCase(currentTabName)) {
        if (i == size - 1) {
          throw new IndexOutOfBoundsException("Current tab is the last tab on the right!");
        }

        // get next tab url
        final String nextTabName = tabNames.get(i + 1);
        focusTab(nextTabName);
        final String nextTabUrl = webDriver.getCurrentUrl();

        // switch back to current
        focusTab(currentTabName);
        return nextTabUrl;
      }
    }
    ;
    throw new IllegalStateException("Cannot find current tab!");
  }

  private List<String> getTabNames() {
    return new ArrayList(webDriver.getWindowHandles());
  }

  private void closeTab(String tabName) {
    focusTab(tabName);
    webDriver.close();
  }

  private void focusTab(String tabName) {
    webDriver.switchTo().window(tabName);
  }

  public void navigateTo(Object path) {
    webDriver.get(baseUrl + "/" + path);
  }

  public void clearSessionStorage() {
    ((JavascriptExecutor) webDriver).executeScript("sessionStorage.clear();");
    webDriver.manage().deleteAllCookies();
  }

  public void navigateBack() {
    webDriver.navigate().back();
  }
}
