package realRestAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.Objects;

public class CyberAPI {
    @Test
    public void getTeachersTest() throws Exception {
      Response response= RestAssured.get("http://api.cybertektraining.com/teacher/all");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        //Challenge: read 4 attributes from the response and for each and every object
        //JsonPath:Writing the syntax of the path to preferred attribute in the response.
        //This design is not preferred. Becouse it will be hardcoded and dependent from the object structure
        //We are going to use POJO model
        //POJO approach is most fit for API aoutomation
        //Idea:converting the Json response into Basic Java object and have an
        //accsess to it's field/attributes/properties.
        //We also use Jackson library to map from json to object or object to vise versa


        ObjectMapper mapper = new ObjectMapper();
        GeneralResponse gr=mapper.readValue(response.asString(),GeneralResponse.class);
        System.out.println(gr.getTeachers().size());

        for(GeneralTeacher teacher: gr.getTeachers()){
            System.out.println(teacher.getFirstName()+"\n");
            Assert.assertTrue(teacher.getFirstName()!=null);
            Assert.assertTrue(teacher.getLastName()!=null);
            Assert.assertTrue(teacher.getEmailAddress()!=null);
            Assert.assertTrue(teacher.getSubject()!=null);

        }

    }

    @Test
    public void createInstructor(){
        GeneralTeacher teacher=new GeneralTeacher();
        teacher.setBatch(11);
        teacher.setEmailAddress("0716hga@mail.ru");
        teacher.setFirstName("Alana");
        teacher.setLastName("Wilson");
        teacher.setSubject("Math");
        teacher.setBirthDate("06/16/2006");
        teacher.setGender("female");
        teacher.setDepartment("computer");
        teacher.setJoinDate("03/03/2019");
        teacher.setSalary(100);
        teacher.setSection("OK");
        teacher.setPassword("567hvk");
        teacher.setPhone("787249592");
        teacher.setPremanentAddress("2700 S river");




        String url ="http://api.cybertektraining.com/teacher/create";
        Response response=RestAssured.given().contentType(ContentType.JSON).body(teacher).when().post(url);
        System.out.println(response.asString());
        System.out.println(response.statusCode());

    }
}
