import Base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class EasyTest extends BaseTest {

    @Test
    @DisplayName("Get user test")
    public void restTest() {
        var response = request
                .baseUri("https://reqres.in/")
                .when().get("api/users/2")
                .then().extract().response();

        var status = response.getStatusCode();
        var resBody = response.body().prettyPrint();
        var user = response.body().jsonPath().get("data.first_name").toString();

        System.out.println(":> Status: " + status);
        System.out.println(":> Response body: " + resBody);
        System.out.println(":> Response user: " + user);

        Assertions.assertEquals(200, status);
        Assertions.assertEquals("Janet", user);

    }

    @Test
    @DisplayName("Get user list test")
    public void restTestTwo() {
        List<UserData> userList = request
                .baseUri("https://reqres.in/")
                .when().get("api/users?page=2")
                .then().extract().jsonPath().getList("data", UserData.class);

        userList.forEach(u -> System.out.println(u.getFirst_name()));
        System.out.println(Arrays.toString(userList.toArray()));
        Assertions.assertEquals(6, userList.size());
    }
}
