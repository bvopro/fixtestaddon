package features

import com.company.fixtestaddon.AccountService
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Autowired

class AccountStepdefs {

    @Autowired
    lateinit var service : AccountService

    @Given("account balance is {double}")
    fun givenAccountBalance(initialBalance: Double?) {
        service.account += initialBalance ?: 0.0
    }

    @When("the account is credited with {double}")
    fun the_account_is_credited_with(amount: Double?) {
        service.account += amount ?: 0.0
    }

    @Then("account should have a balance of {double}")
    fun account_should_have_a_balance_of(expectedBalance: Double?) {
        Assertions.assertEquals(expectedBalance, service.account)
    }
}
