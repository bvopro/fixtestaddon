package features

import com.company.fixtestaddon.repository.NewEntityRepository
import com.company.fixtestaddon.service.NewEntityService
import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import org.springframework.beans.factory.annotation.Autowired

class NewEntityStepdefs {

    var code: String? = null

    @Autowired
    lateinit var newEntityRepository: NewEntityRepository

    @Autowired
    lateinit var newEntityService: NewEntityService

    @Given("a empty list of New entity")
    fun aEmptyListOfNewEntity() {
        // nothing to do
    }

    @When("I search the code {string}")
    fun iSearchTheCode(code: String) {
        this.code = code
    }

    @Then("I get no new entity")
    fun iGetNoNewEntity() {
        assert(newEntityRepository.findByCode(this.code) == null)
    }

    @Then("I check it is available")
    fun iCheckCodeIsAvailable() {
        assert(newEntityService.isCodeAvailable(this.code!!))
    }

    @Then("I get no new entity v2")
    fun iGetNoNewEntityV2() {
        assert(newEntityService.findByCodeCustom(this.code!!) == null)
    }
}
