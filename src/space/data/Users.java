public class Users {

    private static String name;
    private String login;
    private String password;

    public Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public static String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static Users Fortest1 = new Users("Фортест1", "Fortest1", "Sh273Ht1");
    public static Users Fortest2 = new Users("Фортест2", "Fortest2", "Sh273Ht1");
    public static Users Fortest3 = new Users("Фортест3", "Fortest3", "Sh273Ht1");
}
