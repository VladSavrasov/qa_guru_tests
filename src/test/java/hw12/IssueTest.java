package hw12;


import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static hw12.TestData.*;
import static io.qameta.allure.Allure.step;

public class IssueTest extends BaseTest {

    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории  Гитхаб")
    @Owner("Savrasov")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "github", url = "{baseURL}")
    @DisplayName("Проверка Issue в репозитории ")
    public void issueSearchTest() {
        open(BASEURL);
        $(".search-input-container").click();
        $(".QueryBuilder-InputWrapper #query-builder-test").setValue(REPO).pressEnter();
        $(By.linkText(REPO)).click();
        $("#issues-tab").click();
        $(withText(SEARCHTEXT)).should(Condition.exist);
    }

    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории  используя лямбду")
    @Owner("Savrasov")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "github", url = "{baseURL}")
    @DisplayName("Проверка Issue в репозитории используя лямбду")
    public void issueLambdaSearchTest() {
        step("открыть главную страницу",() -> open(BASEURL));
        step("найти строку поиска",() ->$(".search-input-container").click());
        step("перейти на стр с репозиторием",() ->$(".QueryBuilder-InputWrapper #query-builder-test").setValue(REPO).pressEnter());
        step("перейти в репозиторий "+ REPO,() ->$(By.linkText(REPO)).click());
        step("перейти на страничку issues",() ->$("#issues-tab").click());
        step("найти страничке "+ SEARCHTEXT,() ->$(withText(SEARCHTEXT)).should(Condition.exist));
    }
    @Test
    @Feature("Поиск в репозитории")
    @Story("Поиск в репозитории  используя аннотацию Step")
    @Owner("Savrasov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "github", url = "{baseURL}")
    @DisplayName("Проверка Issue в репозитории с аннотацией @Step")
    public void issueStepsSearchTest() {
        WebSteps webSteps = new WebSteps();
        webSteps.openStartPage(BASEURL);
        webSteps.findSearchFild();
        webSteps.openPageWithRepo(REPO);
        webSteps.openRepoPage(REPO);
        webSteps.openIssuesPage();
        webSteps.checkSearchTextExist(SEARCHTEXT);
    }
}
