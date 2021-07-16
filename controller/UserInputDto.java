package ch.zli3.ksh18a.crm.controller;

public class UserInputDto {

    private final String username;
    private final String password;

    public UserInputDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
