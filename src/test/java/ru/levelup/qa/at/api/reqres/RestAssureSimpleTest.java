package ru.levelup.qa.at.api.reqres;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class RestAssureSimpleTest {

    @Test
    public void restAssuredSimpleTest() {
        RestAssured
                .given()                                                             // ДАНО:
                .baseUri("https://reqres.in/")                                          // базовый урл для запроса
                .header(new Header("Content-Type", "application/json"))     // Задаём заголовки запроса
                .body("{\n" +                                                           //
                        "    \"name\": \"spider-man\",\n" +                             // тело запроса
                        "    \"job\": \"superhero\"\n" +                                //
                        "}")                                                            //
                .log().all()                                                            // включаем логирование запроса
                .when()                                                              // КОГДА:
                .post("/api/users")                                                 // Отправляем запрос на эндпоит
                .then()                                                              // ТОГДА:
                .log().all()                                                             // включаем логирование для ответа
                .statusCode(200)                                                         // проверка статус кода ответа
                .body("name", equalTo("spider-man"))                        //
                .body("job", equalTo("superhero"))                          //
                .body("id", not(emptyString()))                                     // проверка тело ответа на запрос
                .body("createdAt", not(emptyString()));                             //
    }
}
