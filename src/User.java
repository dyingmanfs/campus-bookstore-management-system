import java.util.Date;

abstract public class User {
    int ID;
    String name;
    Date dateOfBirth;

    public User() {
        dateOfBirth =new Date();
    }
}
