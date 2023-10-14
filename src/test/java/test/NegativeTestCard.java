package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import data.DataHelper;
import data.Sql;
import pages.Dashboard;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTestCard {

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

    @DisplayName("Card - Declined card.")
    @Test
    public void shouldNotPayDeclinedCard() {
        var dasboard = new Dashboard();
        var payCard = dasboard.payCard();
        var declinedCard = DataHelper.getDeclinedCard();
        payCard.enterCardData(declinedCard);
        payCard.notSuccessfulCardPayment();

        var paymentId = Sql.getPaymentId();
        var statusPayment = Sql.getStatusPayment(paymentId);
        Assertions.assertEquals("DECLINED", statusPayment);
    }


    @DisplayName("Card - All blank data.")
    @Test
    public void shouldNotPayEmptyForm() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var emptyCardInformation = DataHelper.getAllFieldsEmpty();
        payCard.enterCardData(emptyCardInformation);
        payCard.invalidCardFormat();
    }



    @DisplayName("Card - Blank card number.")
    @Test
    public void shouldNotPayEmptyCard() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var fieldCardEmpty = DataHelper.getCardNumberEmpty();
        payCard.enterCardData(fieldCardEmpty);
        payCard.invalidCardFormat();
    }



    @DisplayName("Card - Blank Year.")
    @Test
    public void shouldNotPayEmptyYear() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var fieldYearEmpty = DataHelper.getYearEmpty();
        payCard.enterCardData(fieldYearEmpty);
        payCard.invalidCardFormat();
    }



    @DisplayName("Card - Blank Month.")
    @Test
    public void shouldNotPayEmptyMonth() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var fieldMonthEmpty = DataHelper.getMonthEmpty();
        payCard.enterCardData(fieldMonthEmpty);
        payCard.invalidCardFormat();
    }


    @DisplayName("Card - Blank Holder")
    @Test
    public void shouldNotPayEmptyHolder() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var fieldHolderEmpty = DataHelper.getHolderEmpty();
        payCard.enterCardData(fieldHolderEmpty);
        payCard.requiredCardToFillIn();
    }



    @DisplayName("Card - Blank CVV.")
    @Test
    public void shouldNotPayEmptyCvv() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var fieldCvvEmpty = DataHelper.getCVVEmpty();
        payCard.enterCardData(fieldCvvEmpty);
        payCard.invalidCardFormat();
    }



    @DisplayName("Card - Expired year.")
    @Test
    public void shouldNotPayExpiredYear() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getExpiredYear();
        payCard.enterCardData(invalidCard);
        payCard.expiredCardYear();
    }



    @DisplayName("Card - Expired month.")
    @Test
    public void shouldNotPayExpiredMonth() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getExpiredMonth();
        payCard.enterCardData(invalidCard);
        payCard.invalidDate();
    }



    @DisplayName("Card - Invalid card number.")
    @Test
    public void shouldNotPayInvalidNumber() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getInvalidNumber();
        payCard.enterCardData(invalidCard);
        payCard.invalidCardFormat();
    }



    @DisplayName("Card - Wrong year.")
    @Test
    public void shouldNotPayWrongYear() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getWrongYear();
        payCard.enterCardData(invalidCard);
        payCard.invalidDate();
    }



    @DisplayName("Card - Wrong month.")
    @Test
    public void shouldNotPayWrongMonth() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getWrongMonth();
        payCard.enterCardData(invalidCard);
        payCard.invalidDate();
    }



    @DisplayName("Сard - Numeric holder's name.")
    @Test
    public void shouldNotPayNumericHolder() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getNumericName();
        payCard.enterCardData(invalidCard);
        payCard.invalidCardFormat();
    }



    @DisplayName("Card - Invalid CVV.")
    @Test
    public void shouldNotPayInvalidCVV() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getInvalidCVV();
        payCard.enterCardData(invalidCard);
        payCard.invalidCardFormat();
    }


    @DisplayName("Card - Zero card number.")
    @Test
    public void shouldNotPayZeroNumber() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getZeroCard();
        payCard.enterCardData(invalidCard);
        payCard.notSuccessfulCardPayment();
    }



    @DisplayName("Card - Zero month.")
    @Test
    public void shouldNotPayZeroMonth() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getZeroMonth();
        payCard.enterCardData(invalidCard);
        payCard.invalidDate();
    }


    @DisplayName("Card - Zero CVV")
    @Test
    public void shouldNotPayZeroCVV() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var invalidCard = DataHelper.getZeroCVV();
        payCard.enterCardData(invalidCard);
        payCard.invalidCardFormat();
    }



}