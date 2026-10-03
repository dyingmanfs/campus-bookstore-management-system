/**
 *
 * @author Furkan Sağlam
 * @version 2.0
 */
import java.util.Date;

public class Employee extends User{
    private Date startDate;
    // Default constructor
    public Employee(){
        // take from system
        this.startDate = new Date();

    }

    /**
     *
     * @param empID Employee id
     * @param name Employee name
     * @param dateOfBirth Employe's date of birth day
     */
    public Employee(int empID, String name, Date dateOfBirth) {
        this.ID = empID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        // take from system
        this.startDate = new Date();
    }

    /**
     *
     * @param empID Employee's id
     * @param name Employee's name

     * @param dateOfBirth Employee's Date of birthday
     * @param startDate Employe's start date
     */
    public Employee(int empID, String name, Date dateOfBirth, Date startDate) {
        this.ID = empID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.startDate = startDate;
    }


    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
