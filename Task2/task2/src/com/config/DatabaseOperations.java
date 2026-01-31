package com.config;
import com.Vehicle;

public class DatabaseOperations
{
    private String url;
    private String username;
    private String password;

    public DatabaseOperations() {
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void save(Vehicle vehicle)
    {
        System.out.println("---------------connecting to database with properties------------------");
//        System.out.printf("url: %s\n username:%s\n password:%\n" , url , username , password);
        System.out.println(url + " " + username + " " + password);
        System.out.printf("--------------%s saved to database------------------\n" , vehicle.getBrand());
    }
}
