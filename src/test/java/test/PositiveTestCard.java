package test;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import data.DataHelper;
import data.Sql;
import pages.Dashboard;

import static com.codeborne.selenide.Selenide.open;

public class PositiveTestCard {
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

    @DisplayName("Successful card purchase.")
    @Test
    public void shouldConfirmPaymentApprovedCard() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var approvedCardInformation = DataHelper.getValidCard();
        payCard.enterCardData(approvedCardInformation);
        payCard.successfulCardPayment();

        var paymentId = Sql.getPaymentId();
        var statusPayment = Sql.getStatusPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusPayment);
    }

    @DisplayName("Successful card purchase with current month and year.")
    @Test
    public void shouldConfirmPaymentCurrentMonthAndYear() {
        var dashboard = new Dashboard();
        var payCard = dashboard.payCard();
        var validCardInformation = DataHelper.getCurrentMonthAndYear();
        payCard.enterCardData(validCardInformation);
        payCard.successfulCardPayment();

        var paymentId = Sql.getPaymentId();
        var statusPayment = Sql.getStatusPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusPayment);
    }

   }