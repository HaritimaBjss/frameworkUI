package selenium_tests.steplibrary;

import core.ReadProperties;
import net.thucydides.core.annotations.Steps;
import selenium_tests.pages.LandingPage;

public class LandingStepLib {

    @Steps
    private  LandingPage landingPage;

    @Steps
    private  ReadProperties data;

    public void launchGoogle(){
       landingPage.getUrl(data.getLoginUrl());
    }

}
