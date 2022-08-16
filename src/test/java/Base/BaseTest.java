package Base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.given;

@ExtendWith(LogListener.class)
public class BaseTest {

    protected RequestSpecification request;

    @BeforeEach
    public void setUp() {
        request = given()
                .filter(new AllureRestAssured())
                .log().all();
    }
}
