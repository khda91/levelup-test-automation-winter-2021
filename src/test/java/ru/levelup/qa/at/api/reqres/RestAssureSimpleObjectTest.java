package ru.levelup.qa.at.api.reqres;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.levelup.qa.at.api.reqres.model.CreateUserRequest;
import ru.levelup.qa.at.api.reqres.model.CreateUserResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class RestAssureSimpleObjectTest {

    RequestSpecification rqSpec;
    ResponseSpecification rsSpec;

    @BeforeClass
    public void beforeClass() {
        rqSpec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        rsSpec = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(Matchers.greaterThanOrEqualTo(200))
                .build();
    }

    @Test
    public void restAssuredSimpleTest() {
        System.out.println("restAssuredSimpleTest");

        CreateUserRequest request = new CreateUserRequest("spider-man", "superhero");
        CreateUserResponse expercted = CreateUserResponse.builder()
                .name(request.getName())
                .job(request.getJob())
                .build();

        CreateUserResponse res = RestAssured
                .given(rqSpec)                                                             // ДАНО:
//                .body("{\n" +                                                           //
//                        "    \"name\": \"spider-man\",\n" +                             // тело запроса
//                        "    \"job\": \"superhero\"\n" +                                //
//                        "}")                                                            //
                .body(request)
                .when()                                                              // КОГДА:
                .post("/api/users")                                                 // Отправляем запрос на эндпоит
                .then()                                                              // ТОГДА:
                .spec(rsSpec)
                .extract()
                .as(CreateUserResponse.class);
//                .body("name", equalTo("spider-man"))                        //
//                .body("job", equalTo("superhero"))                          //
//                .body("id", not(emptyString()))                                     // проверка тело ответа на запрос
//                .body("createdAt", not(emptyString()));                             //

        assertThat(res, equalTo(expercted));

    }

    @Test
    public void restAssuredGetRequestTest() {
        System.out.println("restAssuredGetRequestTest");
        RestAssured
                .given()
                .spec(rqSpec)
                .when()
                .get("/api/users/2")
                .then()
                .spec(rsSpec)
                .body(Matchers.equalToCompressingWhiteSpace("{" +
                        "\"data\": {" +
                        "\"id\": 2," +
                        "\"email\": \"janet.weaver@reqres.in\"," +
                        "\"first_name\": \"Janet\"," +
                        "\"last_name\": \"Weaver\"," +
                        "\"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"" +
                        "}," +
                        "\"support\": {" +
                        "\"url\": \"https://reqres.in/#support-heading\"," +
                        "\"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"" +
                        "}" +
                        "}"));
    }
}
