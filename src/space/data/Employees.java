public class Employees {

    private String name;
    private String login;
    private String password;

    public Employees(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static Employees Fortest1 = new Employees("Фортест1", "Fortest1", "Sh273Ht1");
    public static Employees Fortest2 = new Employees("Фортест2", "Fortest2", "Sh273Ht1");
    public static Employees Fortest3 = new Employees("Фортест3", "Fortest3", "Sh273Ht1");

}
