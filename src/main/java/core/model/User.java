package core.model;

public class User {
    private String login;
    private String password;
    public User(String loginUser, String passwordUser){
        login = loginUser;
        password = passwordUser;
    }
    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.password;
    }
    void setLogin(String log){
        this.login = log;
    }
    void setPassword(String pass){
        this.password = pass;
    }
}
