package starter.navigation;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://www.theguardian.com/tone/news")
public class GuardianNewsHomePage extends PageObject {

    @FindBy(css = "a.u-faux-block-link__overlay.js-headline-text")
    static List<WebElement> news_headings;

    public static final Target NEWS_TITLES = Target.the("news title links").locatedBy("a.u-faux-block-link__overlay.js-headline-text");

    public static int getHeadlinesCount() throws Exception{
        return news_headings.size();
    }

}
