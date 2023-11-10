package hw15;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import hw15.pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Feature("Practice form page")
    @Story("Проверка Practice form page")
    @Owner("Savrasov")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("Registration")
    @DisplayName("Проверка Practice form используя лямбду")
    void fillFormTest() {
        step("fill the form", () -> {
            registrationPage.openPage()
                    .setfirstName("Vladius")
                    .setLastName("Vladivikovich")
                    .setEmail("vsvsvs08@rambler.ru")
                    .setGenderRadio("Male")
                    .setPhoneNumber("8909890099").setDateOfBirth("11", "January", "2002")
                    .setSubjectsField("e")
                    .setHobby("Music")
                    .downloadThePicture("x.png")
                    .setCurrentAddressField("Some text")
                    .setState("uttar")
                    .setCity("ag")
                    .submit();
        });

        step("Check the form", () -> {
            registrationPage.modalformFieldCheck("Student Name", "Vladius Vladivikovich")
                    .modalformFieldCheck("Student Email", "vsvsvs08@rambler.ru")
                    .modalformFieldCheck("Gender", "Male")
                    .modalformFieldCheck("Mobile", "8909890099")
                    .modalformFieldCheck("Date of Birth", "11 January,2002")
                    .modalformFieldCheck("Subjects", "English")
                    .modalformFieldCheck("Hobbies", "Music")
                    .modalformFieldCheck("Picture", "x.png")
                    .modalformFieldCheck("Address", "Some text")
                    .modalformFieldCheck("State and City", "Uttar Pradesh Agra")
                    .closeModalformField();
        });

    }
}