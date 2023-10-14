package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import data.DataHelper;
import data.Sql;
import pages.Dashboard;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTestCredit {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openChrome() {
        open("http://localhost:8080/");
    }


    @DisplayName("Credit - Declined card.")
    @Test
    public void shouldNotCreditDeclinedCard() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var declinedCard = DataHelper.getDeclinedCard();
        buyCredit.enterCreditCardData(declinedCard);
        buyCredit.notSuccessfulCreditCardPayment();

        var paymentId = Sql.getPaymentId();
        var statusPayment = Sql.getStatusCredit(paymentId);
        Assertions.assertEquals("DECLINED", statusPayment);
    }


    @DisplayName("Credit - All blank data.")
    @Test
    public void shouldNotCreditEmptyForm() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var emptyCardInformation = DataHelper.getAllFieldsEmpty();
        buyCredit.enterCreditCardData(emptyCardInformation);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Blank card number.")
    @Test
    public void shouldNotCreditEmptyCard() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var fieldCardEmpty = DataHelper.getCardNumberEmpty();
        buyCredit.enterCreditCardData(fieldCardEmpty);
        buyCredit.invalidCreditFormat();
    }


    @DisplayName("Credit - Blank Year.")
    @Test
    public void shouldNotCreditEmptyYear() {
        var dashboard= new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var fieldYearEmpty = DataHelper.getYearEmpty();
        buyCredit.enterCreditCardData(fieldYearEmpty);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Blank Month.")
    @Test
    public void shouldNotCreditEmptyMonth() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var fieldMonthEmpty = DataHelper.getMonthEmpty();
        buyCredit.enterCreditCardData(fieldMonthEmpty);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Blank Holder")
    @Test
    public void shouldNotCreditEmptyHolder() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var fieldHolderEmpty = DataHelper.getHolderEmpty();
        buyCredit.enterCreditCardData(fieldHolderEmpty);
        buyCredit.requiredCreditToFillIn();
    }



    @DisplayName("Credit - Blank CVV.")
    @Test
    public void shouldNotCreditEmptyCvv() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var fieldCvvEmpty = DataHelper.getCVVEmpty();
        buyCredit.enterCreditCardData(fieldCvvEmpty);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Expired year.")
    @Test
    public void shouldNotCreditExpiredYear() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getExpiredYear();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.expiredCreditCardYear();
    }



    @DisplayName("Credit - Expired month.")
    @Test
    public void shouldNotCreditExpiredMonth() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getExpiredMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidDate();
    }



    @DisplayName("Credit - Invalid card number.")
    @Test
    public void shouldNotCreditInvalidNumber() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getInvalidNumber();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Wrong year.")
    @Test
    public void shouldNotCreditWrongYear() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getWrongYear();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidDate();
    }



    @DisplayName("Credit - Wrong month.")
    @Test
    public void shouldNotCreditWrongMonth() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getWrongMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidDate();
    }



    @DisplayName("Сredit - Numeric holder's name.")
    @Test
    public void shouldNotCreditNumericHolder() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getNumericName();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Invalid CVV.")
    @Test
    public void shouldNotCreditInvalidCVV() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getInvalidCVV();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidCreditFormat();
    }



    @DisplayName("Credit - Zero card number.")
    @Test
    public void shouldNotCreditZeroNumber() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getZeroCard();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.notSuccessfulCreditCardPayment();
    }



    @DisplayName("Credit- Zero month.")
    @Test
    public void shouldNotCreditZeroMonth() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getZeroMonth();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidDate();
    }



    @DisplayName("Credit - Zero CVV")
    @Test
    public void shouldNotCreditZeroCVV() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var invalidCard = DataHelper.getZeroCVV();
        buyCredit.enterCreditCardData(invalidCard);
        buyCredit.invalidCreditFormat();
    }

}
