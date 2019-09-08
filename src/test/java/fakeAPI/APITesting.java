package fakeAPI;

import org.junit.Test;

import java.util.List;

public class APITesting {

    @Test
    public void api1() {
        User u = new User();
        u.name = "James Bond";
        u.username = "jbond";
        u.password = "JB123";
        String response = API.createUser("api.test.com/user/create", u);
        System.out.println(response);
        DB.users.get(0).info();

    }
    //API 2:
    //GET HTTP method
    //resource: /user/all

@Test
    public void apiGet(){
        List<User> u = API.getUsers("api.test.com/user/all");
    System.out.println(u.size());
}
}