/**
 *
 * @author Furkan Sağlam
 * @version 2.0
 */
import java.util.ArrayList;
import java.util.Date;

public class TextbookReservation {
    Date reservationDate;
    ArrayList<BookItem>  bookList = new ArrayList<>();
    boolean paidStatus;

    /**
     *
     * @param book bookItem objeckt
     * @param paidStatus is it paid or not
     */
    public TextbookReservation(BookItem book, boolean paidStatus) {
        // take from ssytem date
        this.reservationDate = new Date();
        this.bookList.add(book);
        this.paidStatus = paidStatus;

    }

    /**
     *
     * @param paidStatus  is it paid or not
     * @param reservationDate Reservation date
     */
    public TextbookReservation( boolean paidStatus,Date reservationDate) {
        this.reservationDate = reservationDate;
        this.paidStatus = paidStatus;

    }

    /**
     * Defult consturcter
     */
    public TextbookReservation() {
        this.reservationDate = new Date();
        this.paidStatus = false;

    }


    public Date getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    public ArrayList<BookItem> getBookList() {
        return bookList;
    }
    public void setBookList(ArrayList<BookItem> bookList) {
        this.bookList = bookList;
    }
    public boolean isPaidStatus() {
        return paidStatus;
    }
    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    /**
     *
     * @return total price for all book
     */
    public double totalReservationCost() {
        double total = 0;
        // to take all book
        for (BookItem book : bookList) {
            total += book.totalCost();
        }
        return total;
    }
    // add a new book for booklist
    public  void addBookItem(BookItem book) {
        bookList.add(book);
    }
}
