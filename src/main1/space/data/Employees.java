package data;

import lombok.Data;

@Data
public class Employees {
    private String name;
    private String login;
    private String password;
    public Employees(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }
}
