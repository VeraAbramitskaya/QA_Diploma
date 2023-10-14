package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Dashboard {

    private final SelenideElement cardButton = $(byText("Купить"));
    private final SelenideElement creditButton = $(byText("Купить в кредит"));

    public pages.CardPage payCard() {
        cardButton.click();
        return new pages.CardPage();
    }

    public CreditPage buyCredit() {
        creditButton.click();
        return new CreditPage();
    }
}