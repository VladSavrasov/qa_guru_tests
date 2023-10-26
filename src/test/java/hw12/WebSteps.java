package hw12;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {
    @Step("открыть главную страницу")
    public void openStartPage(String baseURL) {
        open(baseURL);
    }

    @Step("найти строку поиска")
    public void findSearchFild() {
        $(".search-input-container").click();
    }

    @Step("перейти на стр с репозиторием")
    public void openPageWithRepo(String repo) {
        $(".QueryBuilder-InputWrapper #query-builder-test").setValue(repo).pressEnter();
    }

    @Step("перейти в репозиторий ")
    public void openRepoPage(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("перейти на страничку issues")
    public void openIssuesPage() {
        $("#issues-tab").click();
    }

    @Step("найти страничке {searchText}")
    public void checkSearchTextExist(String searchText) {
        $(withText(searchText)).should(Condition.exist);
    }
}
