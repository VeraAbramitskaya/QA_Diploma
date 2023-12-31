package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage extends pages.Dashboard {

    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement expirationMonthField = $("[placeholder='08']");
    private final SelenideElement expirationYearField = $("[placeholder='22']");
    private final SelenideElement cardHolderNameField = fields.get(3);
    private final SelenideElement cardSecurityCodeField = $("[placeholder='999']");
    private final SelenideElement continueButton = $(withText("Продолжить"));

    private final SelenideElement successNotification = $(withText("Успешно"));
    private final SelenideElement errorNotification = $(withText("Ошибка"));
    private final SelenideElement invalidFormatError = $(withText("Неверный формат"));
    private final SelenideElement requiredToFillIn = $(withText("Поле обязательно для заполнения"));
    private final SelenideElement expiredYearError = $(withText("Истёк срок действия карты"));
    private final SelenideElement invalidDateError = $(withText("Неверно указан срок действия карты"));

    public void enterCreditCardData(DataHelper.CardInformation cardInformation) {
        cardNumberField.setValue(cardInformation.getCardNumber());
        expirationMonthField.setValue(cardInformation.getMonth());
        expirationYearField.setValue(cardInformation.getYear());
        cardHolderNameField.setValue(cardInformation.getHolder());
        cardSecurityCodeField.setValue(cardInformation.getCVV());
        continueButton.click();
    }

    public void successfulCreditCardPayment() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void notSuccessfulCreditCardPayment() {
        errorNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void invalidCreditFormat() {
        invalidFormatError.shouldBe(visible);
    }

    public void requiredCreditToFillIn() {
        requiredToFillIn.shouldBe(visible);
    }

    public void expiredCreditCardYear() {
        expiredYearError.shouldBe(visible);
    }

    public void invalidDate() {
        invalidDateError.shouldBe(visible);
    }
}