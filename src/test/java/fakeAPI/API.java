package fakeAPI;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.List;

public class API {
    //User creation API
    //We use HTTP POST method to achive this
    //Requirements;
    //1. url+resource 2. request body
    //Imagine url resource for this API is "api.test.com/user/create"
    //Request body Must be as following:
    //user must have name, user must have username
    //user must have password.

    public static String createUser(String url, User user){
        String expectedURL = "api.test.com/user/create";
        if(!url.equals(expectedURL)){
            return "404 - Responce Not Found";

        }
        if(user.name==null || user.username==null||user.password==null){
            return "400 - Bad request";

        }
        DB.users.add(user);
        return "201 - User Created";
    }
    public static List<User> getUsers(String url){
        String expectedURL = "api.test.com/user/all";
        if(!url.equals(expectedURL)){
            System.out.println("404 - not found");
            return null;
        }
        System.out.println("200 - ok");
        return DB.users;

    }
}
