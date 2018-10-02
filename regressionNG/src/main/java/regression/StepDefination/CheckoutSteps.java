package regression.StepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import regression.Pages.Checkout;

public class CheckoutSteps {
    int bananaPrice = 0;
    int applePrice = 0;
    Checkout checkout;

    @Given("^the price of a \"([^\"]*)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) {
        System.out.println("Given");
        bananaPrice = price;
    }

    @When("^I checkout (\\d+) \"([^\"]*)\"$")
    public void iCheckout(int itemCount, String itemName) {
        System.out.println("When");
        checkout = new Checkout();
        checkout.addBanana(itemCount, bananaPrice);
    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) {
        System.out.println("Then");
        Assert.assertEquals(total, checkout.total());

    }
}
