package hw10;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static hw10.TestData.*;



public class OzonTest extends BaseTest{

    static Stream <Arguments> ozonMainPageTest(){
        return Stream.of(
                Arguments.of(mainPagesDiv,mainPagesList));
    }

    @MethodSource
    @ParameterizedTest(name ="проверить наличие массива строк{1} на странице ozon")
    @Tags({@Tag("High"),@Tag("web")})
    void ozonMainPageTest(String div,List<String> expectedButtons){

        $$(div).shouldHave(texts(expectedButtons));
    }

    @CsvSource("#stickyHeader, Избранное")
    @ParameterizedTest(name ="проверить наличие кнопки {1} на странице ozon")
    @Tags({@Tag("Blocker"), @Tag("web")})
    void headerCheckTest(String header, String text){

        $(header).shouldHave(text(text));
    }

    @DisplayName("проверить наличие кнопки 'Стать продавцом' на странице ozon")
    @CsvFileSource(resources = "/navigationBarTest.csv")
    @ParameterizedTest
    @Tags({@Tag("Low"), @Tag("api")})
    void navigationbarTest(String navigationBar, String text) {
        $(navigationBar).shouldHave(text(text));
    }
}
