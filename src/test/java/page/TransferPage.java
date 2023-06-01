package page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

import data.DataHelper;

public class TransferPage {
    private SelenideElement heading = $x("//h1[contains(text(), 'Пополнение')]");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement fromCard = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public TransferPage() {
        heading.shouldBe(visible);
    }

    public void getTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amountToTransfer);
        fromCard.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }

    public DashboardPage getValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        getTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }
}