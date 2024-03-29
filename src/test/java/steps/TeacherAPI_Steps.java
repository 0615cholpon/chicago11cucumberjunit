package steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HelperMethods;
import io.cucumber.datatable.DataTable;
import models.CustomResponse;
import models.RequestBody;
import org.junit.Assert;
import utilities.APIrunner;
import utilities.Config;
import utilities.DBUtility;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TeacherAPI_Steps {

private RequestBody requestBody;
private CustomResponse customResponse;

    @Given("teacher is created with values")
    public void teacher_is_created_with_values(io.cucumber.datatable.DataTable dataTable) {

        Map<String,String> map=dataTable.asMap(String.class,String.class);
      requestBody= HelperMethods.convertMapToObject(map);


    }
    @When("user hits the web service {string}")
    public void user_hits_the_web_service(String url) {
        // Write code here that turns the phrase above into concrete actions
        APIrunner.runPOST(url,requestBody);
    }

    @Then("verify status code {string}")
    public void verify_status_code(String statusCode) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(APIrunner.getResponse().statusCode()==Integer.valueOf(statusCode));
    }
    @Then("verify with database;")
    public void verify_with_database() {
        // Write code here that turns the phrase above into concrete actions
        String teacher_id=APIrunner.getCustomResponse().getTeacherId()+"";
        String query = "select*from teacher where teacher_id="+teacher_id;
        System.out.println(query);
        try {
            DBUtility.openConnection(Config.getProperty("dbType"));
            List<Map<String, Object>> table=
                    DBUtility.executeSQLquery(query);
            System.out.println("Table size: "+table.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
