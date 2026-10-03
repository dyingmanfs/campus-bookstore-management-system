/**
 *
 * @author Furkan Sağlam
 * @version 2.0
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.io.Serializable;

public class Student extends User implements StudentLoyalty, Comparable<Student>,Serializable {
    private static final long serialVersionUID = 1L;


    private HashMap<String, String> identityCheck;
    private Date reservationDate;
    private ArrayList<TextbookReservation>  reservations = new ArrayList<>();

    public Student() {
        this.ID = -11111111;
        this.name = "no name";
        this.reservationDate = new Date();
        identityCheck = new HashMap<>();
    }


    public HashMap<String, String> getIdentityCheck() {
        return identityCheck;
    }
    /**
     *
     * @param studentID Student id
     * @param name Student's name
     */
        public Student(int studentID, String name) {
            this.ID = studentID;
            this.name = name;
            this.reservationDate = new Date();
            identityCheck = new HashMap<>();
            this.dateOfBirth = new Date();

        }

    /**
     *
      * @param reservation Textbook reservation to add list for student
     */
    public  void addReservation(TextbookReservation reservation) {
            reservations.add(reservation);
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

    public Date getReservationDate() {
            return reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
            this.reservationDate = reservationDate;
    }
    public ArrayList<TextbookReservation> getReservations() {
            return reservations;
    }
    public void setReservations(ArrayList<TextbookReservation> reservations) {
            this.reservations = reservations;
    }
    public double calculateTotalQuantity(){
        int total = 0;
        for(TextbookReservation text :reservations){
            for (BookItem book : text.getBookList()){
                total += book.getQuantity();
            }
        }
        return total;

    }
    public int compareTo(Student other) {

                if(this.calculateTotalQuantity()>other.calculateTotalQuantity()){
                    return 1;// if number retun1, this stundent has more quantity than other student
                } else if (this.calculateTotalQuantity()==other.calculateTotalQuantity()) {
                    return 0; // if number is equal, method will return 0;
                } else{
                    return -1;//if number retun -1 other student has more quantity than this student
                }



    }

}
