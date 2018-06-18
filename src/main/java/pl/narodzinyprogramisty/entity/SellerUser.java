package pl.narodzinyprogramisty.entity;

public class SellerUser extends User {
    private String academy;
    private int level;


    public SellerUser(String name, String lastName, String password, String login, String academy, int level) {
        super(name, lastName, password, login);
        this.academy = academy;
        this.level = level;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SellerUser{" +
                "academy='" + academy + '\'' +
                ", level=" + level +
                '}';
    }
}
