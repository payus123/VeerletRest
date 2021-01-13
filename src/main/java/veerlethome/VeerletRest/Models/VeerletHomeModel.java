package veerlethome.VeerletRest.Models;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class VeerletHomeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String firebasePassword;


    public VeerletHomeModel(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public VeerletHomeModel() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebasePassword() {
        return firebasePassword;
    }

    public void setFirebasePassword(String firebasePassword) {
        this.firebasePassword = firebasePassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
