package seleniumtests.steplibrary;

import core.ReadProperties;
import net.thucydides.core.annotations.Steps;
import seleniumtests.pages.LandingPage;

public class LandingStepLib {

  @Steps
    private  LandingPage landingPage;

  @Steps
    private  ReadProperties data;

  public void launchGoogle() {
    landingPage.getUrl(data.getLoginUrl());
  }

  public void searchText(String bjss) {
    landingPage.sendText(bjss);
  }
}
