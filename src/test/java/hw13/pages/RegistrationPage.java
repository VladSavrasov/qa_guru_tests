package registrationTest.pages;

import com.codeborne.selenide.SelenideElement;
import registrationTest.pages.components.CalendarComponent;
import registrationTest.pages.components.ModalFormComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    ModalFormComponent modalForm = new ModalFormComponent();
    SelenideElement titleLabel = $(".practice-form-wrapper"),
            subjectsField = $(".subjects-auto-complete__value-container--is-multi"),
            subject = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            puctureLoader = $("#uploadPicture"),
            currentAddressField = $("textarea[id=currentAddress]"),
            stateField = $("#state"),
            stateInput = $("#react-select-3-input"),
            cityField = $(byText("Select City")),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            firstNameInput = $(id("firstName")),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            phoneNumberInput = $("[id=userNumber]");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setfirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setGenderRadio(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage clickSubjectsField() {
        subjectsField.click();
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setSubjectsField(String value) {
        clickSubjectsField();
        setSubject(value);
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage downloadThePicture(String value) {
        puctureLoader.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddressField(String value) {
        currentAddressField.click();
        currentAddressField.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityField.click();
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }
    public RegistrationPage modalformFieldCheck(String key, String value) {
        modalForm.checkField( key, value);
        return this;
    }
    public void closeModalformField() {
        modalForm.closeModalform();
    }
}
