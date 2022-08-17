package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.navigation.GuardianNewsHomePage;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchStepDefinitions {

    @Given("{actor} is researching things on the internet")
    public void researchingThings(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theWikipediaHomePage());
        ListOfWebElementFacades article_title = GuardianNewsHomePage.NEWS_TITLES.resolveAllFor(actor);
        ListOfWebElementFacades article_title2 = (ListOfWebElementFacades) actor.asksFor(GuardianNewsHomePage.getAllTheVisibleElements(actor));
        int article_title_old_style = GuardianNewsHomePage.getHeadlinesCount();
        assertThat(article_title_old_style).isGreaterThan(0);
        assertThat(article_title.size()).isGreaterThan(0);
    }

    @When("{actor} looks up {string}")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see information about {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(WikipediaArticle.HEADING).hasText(term)
        );
    }
}
