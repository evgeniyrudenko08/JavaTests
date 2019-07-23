import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
public class restAssuredPostRequest {

    @Test
    public void createUser() {
        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest/doregister";
        given().urlEncodingEnabled(true)
                .param("email", "test780@test50.com")
                .param("name", "Andrey")
                .param("password", "123456q11")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(200);
    }

    @Test
    public void deleteAvatar() {

        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/deleteavatar/?email=test780@test50.com");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        given().when().get("http://www.google.com").then().statusCode(200);
    }

    @Test
    public void deleteAvatarWithBody() {

        Map<String, String> map = new HashMap<>();
        String email = "test780@test50.com";
        map.put("email", email);

        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest/deleteavatar";

        RequestSpecification req = RestAssured.given();
        req.header("Content-Type", "application/json");
        req.body(map).when();
        Response resp = req.delete("http://users.bugred.ru/tasks/rest/deleteavatar");

        String body = resp.asString();
        System.out.println("Response is : " + body);
    }
}
