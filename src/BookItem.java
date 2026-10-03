/**
 *
 * @author Furkan Sağlam
 * @version 2.0
 */
public class BookItem  {
    private String type;
    private int quantity;
    private double price;
    private Employee employee;
    public BookItem(){
        this.type = "Null";
        this.quantity = 0;
        this.price = 0;
    }

    /**
     *
     * @param type type of book
     * @param quantity number of book
     * @param price price of book
     */
    public BookItem(String type, int quantity, double price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     *
     * @param type type of book
     * @param quantity number of book
     * @param price price of book
     * @param e employee
     */
    public BookItem(String type, int quantity, double price,Employee e) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.employee = e;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     *
     * @return total cost price for book or books
     */
    public double totalCost(){
        // number of book * price
        return quantity * price;
    }

}
