package test;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import data.DataHelper;
import data.Sql;
import pages.Dashboard;

import static com.codeborne.selenide.Selenide.open;

public class PositiveTestCredit {
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

    @DisplayName("Successful credit purchase")
    @Test
    public void shouldConfirmCreditApprovedCard() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var approvedCardInformation = DataHelper.getValidCard();
        buyCredit.enterCreditCardData(approvedCardInformation);
        buyCredit.successfulCreditCardPayment();

        var paymentId = Sql.getPaymentId();
        var statusPayment = Sql.getStatusCredit(paymentId);
        Assertions.assertEquals("APPROVED", statusPayment);
    }


    @DisplayName("Successful credit purchase with current month and year.")
    @Test
    public void shouldConfirmCreditWithCurrentMonthAndYear() {
        var dashboard = new Dashboard();
        var buyCredit = dashboard.buyCredit();
        var validCardInformation = DataHelper.getCurrentMonthAndYear();
        buyCredit.enterCreditCardData(validCardInformation);
        buyCredit.successfulCreditCardPayment();

        var paymentId = Sql.getPaymentId();
        var statusPayment = Sql.getStatusCredit(paymentId);
        Assertions.assertEquals("APPROVED", statusPayment);
    }

}