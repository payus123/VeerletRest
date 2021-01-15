package veerlethome.VeerletRest.Models;

public class CheckUser {
    private String username;

    public CheckUser() {
    }

    public CheckUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
