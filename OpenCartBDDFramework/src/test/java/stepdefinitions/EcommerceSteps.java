package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.LoginPage;
import pages.SearchPage;
import utilities.ExcelUtils;

public class EcommerceSteps extends BaseClass {

    LoginPage lp =
            new LoginPage(driver);

    SearchPage sp =
            new SearchPage(driver);

    CartPage cp =
            new CartPage(driver);

    @Given("user launches application")
    public void launch() {

        System.out.println("Application launched");
    }

    @When("user login using excel data")
    public void login() throws Exception {

        String username =
                ExcelUtils.getUsername();

        String password =
                ExcelUtils.getPassword();

        lp.login(username, password);
    }

    @When("user searches {string}")
    public void search(String product) {

        sp.searchProduct(product);
    }

    @When("user adds product to cart")
    public void addCart() {

        cp.addProduct();
    }

    @Then("user validates cart")
    public void validateCart() {

        System.out.println("Cart validated");
    }
}
