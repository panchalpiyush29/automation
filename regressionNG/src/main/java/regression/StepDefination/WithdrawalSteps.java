package regression.StepDefination;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class WithdrawalSteps {
    @Given("^I have \\$(\\d+) in my account$")
    public void iHave$InMyAccount(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^the flight (\\w+)(\\d+) is leaving today$")
    public void theFlightEZYIsLeavingToday(int arg0) {

    }

    @Given("^I have (\\d+) cucumbers? in my basket$")
    public void iHaveCucumberInMyBasket(int number) {

    }

    @Given("^I (?:visit|go to) the homepage$")
    public void iVisitTheHomepage() {

    }

    @Given("^these users:$")
    public void theseUsers() {

    }

    private List<List<String>> board;

    @Given("^a board like this:$")
    public void aBoardLikeThis(DataTable table) {
        this.board = new ArrayList<List<String>>();
        for (List<String> row : table.raw()) {
            this.board.add(new ArrayList<String>(row));
        }
    }

    @When("^player x plays in row (\\d+), column (\\d+)$")
    public void playerXPlaysInRowColumn(int row, int col) {
        board.get(row).set(col, "x");
    }

    @Then("^the board should look like this:$")
    public void theBoardShouldLookLikeThis(DataTable expectedTable) {
        expectedTable.diff(board);
    }
}