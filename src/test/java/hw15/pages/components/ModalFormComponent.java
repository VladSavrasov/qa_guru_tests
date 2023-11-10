package hw15.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalFormComponent {
    SelenideElement modalFormCheck = $(".table-responsive"),
            closeModalForm = $("#closeLargeModal");

    public ModalFormComponent checkField(String key, String value) {
        modalFormCheck.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public void closeModalform(){
        closeModalForm.click();
    }
}