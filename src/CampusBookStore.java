//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
/**
 *
 * @author Furkan Sağlam
 * @version 2.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CampusBookStore  {

    public DataStorage dataStorage = new DataStorage();
    //List of student
    public  ArrayList<Student> students = new ArrayList<>();
    //List of Employee
    public  ArrayList<Employee> employees = new ArrayList<>();
    // input sytem to take user
    Scanner input = new Scanner(System.in);
    public  static GUI a;

    public static void main(String[] args) {
        CampusBookStore store = new CampusBookStore();
        StudentSecurity.startIntegrityCheckThread();

        try {
            store.dataStorage.startUp(store);
        } catch (SQLException e) {
            System.out.println("Database load error");
            e.printStackTrace();
        }

        a = new GUI(store);
        a.main();

    }
    /**
     * param none This method takes no parameters; it interacts directly with user input.
     * @return void This method does not return anything.
     */
     public  void menu(){


        while(true){
            System.out.println("Menu:");
            System.out.println("1) Add Employee");
            System.out.println("2) Delete Employee");
            System.out.println("3) List Employees Details");
            System.out.println("4) Add student");
            System.out.println("5) Delete student");
            System.out.println("6) Get student details");
            System.out.println("7) Make reservation");
            System.out.println("8)  Reservation Details");
            System.out.println("9)  Reservation total cost");
            System.out.println("10) Show Employee Details");
            System.out.println("11) Show Student Details");
            System.out.println("0) Exit");
            System.out.println("Enter number");
            int choose = input.nextInt();
            if(choose==1){
                addEmployee();
            }
            else if(choose==2){
                System.out.println("Enter id to delete employee");
                int id = input.nextInt();
                deleteEmployee(id);
            }
            else if(choose==3){
                System.out.println("Enter id to list employees");
                int id = input.nextInt();
                listEmployeeDetails(id);
            }
            else if(choose == 4){

                addStudent();


            } else if (choose == 5) {
                System.out.println("Enter id to delete student");
                int id = input.nextInt();
                deleteStudent(id);

            } else if(choose == 6){
                System.out.println("Enter id to see student details");
                int id = input.nextInt();
                getStudentDetails(id);
            } else if (choose == 7) {
                System.out.println("Enter id to make reservation");
                int id = input.nextInt();
                makeReservation(id);
            } else if(choose == 8){
                System.out.println("Enter student ID");
                int id = input.nextInt();
                Date d=null;
                SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Date of Birth (format: dd/mm/yyyy):");
                String date = input.next();
                try {
                     d  = ft.parse(date);
                } catch (ParseException e) {
                    System.out.println("Wrong date format " + ft);
                }

                getStudentReservationDetails(id,d);
            }
            else if (choose==9) {
                System.out.println("Enter student ID");
                int id = input.nextInt();
                Date d=null;
                SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Date of Birth (format: dd/mm/yyyy):");
                String date = input.next();
                try {
                    d  = ft.parse(date);
                } catch (ParseException e) {
                    System.out.println("Wrong date format " + ft);
                }
                getStudentReservationTotalCost(id,d);
            }

            else if(choose == 10){
                listEmployees();
            }
            else if(choose == 11){
                listStudents();
            }
            else if(choose == 0){
                exit();
            }
        }

    }
    /**
     * param none This method takes no parameters; it interacts directly with user input.
     * @return void This method does not return anything.
     */
    public void addStudent(){
        System.out.println("Name");
        String name = input.next();
        int id;
        while (true){
            System.out.println("Student ID");
             id = input.nextInt();
             int control = 0;
           for(int i=0; i<students.size(); i++){
               if(students.get(i).getID()==id){
                   control=1;
               }
           }
           if(control==0){
               break;
           }
           else {
               System.out.println("This id already exists, please try again");
           }
        }

        Student s = new Student(id,name);
        students.add(s);
    }
    /**
     *
     * @param empID The ID of the Emplyee to find Employee and show Employee details
     * @return This method does not return anything because its return type is void.
     */
    public void listEmployeeDetails(int empID){

        int contorl =0 ;
        for(Employee e:employees){
            // if id can find show detailes
            if(e.getID()==empID){
                contorl = 1;

                a.setEmployee(e);
                System.out.println("Name "+e.getName()+" Id: "+e.getID()+" Date of birth:"+e.getDateOfBirth()+ "Start date: "+e.getStartDate());
                break;
            }

        }

        // if it cant find show Erorr messge
        if (contorl==0){
            System.out.println("Id does not exist");
        }
    }
    /**
     * param there is no parameter.
     * @return does not return anything because of void.
     */
    public void addEmployee(){
        System.out.println("Name");
        String name = input.next();


        int id;
        // to check id is used before
        while (true){
            System.out.println("Employee ID");
            id = input.nextInt();
            int control = 0;
            for(int i=0; i<employees.size(); i++){
                if(employees.get(i).getID()==id){
                    control=1;
                }
            }
            if(control==0){
                break;
            }
            else {
                System.out.println("This id already exists, please try again");
            }
        }
        Date dob = null;
        // Date format
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date of Birth (format: dd/mm/yyyy):");
        String date = input.next();
        try {
            dob = ft.parse(date);
        } catch (ParseException e) {
            System.out.println("Wrong date format " + ft);
        }

        Employee e = new Employee(id,name,dob);
        employees.add(e);
    }
    /**
     * param there is no parameter
     * @return does not return anything because of void.
     */
    public void  listStudents(){


        String [][] listofstudents = new String[students.size()][2];
        int i = 0;
        // loop for all students
        for(Student s: students){
            System.out.println(s.getID()+" "+s.getName()+" "+" "+s.getReservationDate());
            listofstudents[i][0] = String.valueOf(s.getID());
            listofstudents[i][1] = s.getName();
            // loop for all TexttbookReservation for studemts
            for(TextbookReservation t: s.getReservations()){
                System.out.println("Paid is "+t.paidStatus + "Date is"+t.getReservationDate());

                // loop for Bool ıtem list for student
                for (BookItem b: t.getBookList()){


                    System.out.println("Book's type is"+ b.getType()+ "Book's quantity is" + b.getQuantity()+"Book's price is "+b.getPrice());
                }
                System.out.println();

            }
            i++;
        }
        a.setListofstudents(listofstudents);
    }
    /**
     *
     * @param id The ID of the Student to find Student and show students details
     * @return This method does not return anything because its return type is void.
     */
    public void getStudentDetails(int id){
        //control check for id
        int control = 0;
        // start the loop to find id
        for(Student s: students){
            //if find id show details and break loop
            if(s.ID ==id){
                System.out.println("Id is  "+s.getID()+" Name is "+s.getName()+" Reservation Date is "+s.getReservationDate()+" Total reservations are "+ s.getReservations().size());
                a.setS(s);
                control = 1;
                break;
            }

        }
        // don't find show error message
        if(control==0){
            System.out.println("Student not found");
        }
    }
    /**
     *
     * @param id The ID of the Student to find Student and delete
     * @return This method does not return anything because its return type is void.
     */
    public void deleteStudent(int id){
        // contor to check id
        int control = 0;
        // start loop to find id
        for(Student s: students){
            if(s.ID ==id){
                students.remove(s);
                control = 1;
                break;
            }

        }
        //if don't find id
        if(control==0){
            System.out.println("Student not found");
        }
    }

     /**
     *
     * @param id The ID of the Employee to find Employee and delete
     * @return This method does not return anything because its return type is void.
     */
     public void deleteEmployee(int id){
        // contorl for check id number
        int control = 0;
        for(Employee e: employees){
            //if find id
            if(e.getID()==id){
                employees.remove(e);
                control = 1;
                break;
            }

        }
        //if don't find id
        if(control==0){
            System.out.println("Employee not found");
        }
    }
    /**
     /**
     *
     * param There is no parameter
     * @return This method does not return anything because its return type is void.
     */
    void listEmployees(){
        String [][] listofEmploy = new String[employees.size()][4];
        int i = 0;
        //start show all Emplye list
        for(Employee e: employees){
            listofEmploy [i][0] = e.getName();
            listofEmploy [i][1] = String.valueOf(e.getID());
            listofEmploy [i][2] =  String.valueOf(e.getDateOfBirth());
            listofEmploy [i][3] = String.valueOf(e.getStartDate());
            System.out.println("Name "+e.getName()+" Id: "+e.getID()+" Date of birth:"+e.getDateOfBirth()+ "Start date: "+e.getStartDate());
            i++;
        }
        a.setListofEmploy(listofEmploy);
    }
    /**
     /**
     *
     * @param studentID The ID of the student to find student
     * @return This method does not return anything because its return type is void.
     */
    public void makeReservation(int studentID){
        ArrayList<BookItem> b =a.getBooks();
        String [] info = a.getReservation();
        // control to check id
        int control = 0;
        for(Student s: students){
            // if find id
            if(s.ID ==studentID){
                control = 1;
                Date d = null;
                // Date format to input
                SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Enter date (format: dd/mm/yyyy):");
                String date = input.next();
                try {
                    d = ft.parse(date);
                } catch (ParseException e) {
                    System.out.println("Wrong date format " + ft);
                }
                System.out.println("Is it paid?");
                boolean paidStatus = Boolean.parseBoolean(info[2]);
                //creat new TextbookReservation
                TextbookReservation tr = new TextbookReservation(paidStatus,d);
                System.out.println("Enter the number of book");
                int count = Integer.parseInt(info[1]);
                // start loop to take inputs for book
                for (int i = 0; i < count; i++) {

                    // added TextBookreservation lis item for student
                    tr.addBookItem(b.get(i));

                }
                s.addReservation(tr);


                break;
            }
        }
        if(control==0){
            System.out.println("Student does not found");
        }
    }

    /**
     *  to take random Employee when make reservation
     * @return Employee random employee
     */
    Employee randomEmployee(){
        Random rand = new Random();
        int index = rand.nextInt(employees.size());
        return employees.get(index);
    }
    /**
     * @param id method takes Stundent  id and resevation date from the user.
     * @param reservationDate takes resavation date from user the user.
     * @return does not return anything because of void.
     */
    void getStudentReservationDetails(int id, Date reservationDate){
        int control = 0;
        int control2 = 0;
        // creat a new TextBookReservation
        ArrayList<TextbookReservation>  list = new ArrayList<>();
        for(Student s: students){
            //if find id
            if(s.ID ==id){
                control=1;
                for(TextbookReservation tr: s.getReservations()){
                    //if find textbookreservation
                    if(tr.getReservationDate().compareTo(reservationDate)==0){
                        a.setS(s);
                        control2=1;
                        list.add(tr);
                    }
                }
            }

        }
        if(control==0){
            System.out.println("Student not found");
        }
        // if find id but don't find textresevation
        else if(control2==0){
            System.out.println("Reservation not found");
        }
        // if find id and textreservation
        else if (control == 1 && control2==1) {
            System.out.println("Reservation date:" + reservationDate);
            System.out.println("Number of reservations "+list.size());
            int i = 1;

            for (TextbookReservation tr: list) {
                int len =  tr.getBookList().size();
                for (int j = 0; j < len; j++) {
                    BookItem bookItem = tr.getBookList().get(j);

                    System.out.println(i+ " paid is "+ tr.isPaidStatus() + " Type is " + bookItem.getType() + " Quantity is "+bookItem.getQuantity() );

                }

            }

        }
    }
    /**
     *
     * @param StudentID The ID of the student whose reservation cost will be calculated.
     * @param reservationDate The date of the reservation to search for.
     * @return This method does not return anything because its return type is void.
     */
    void getStudentReservationTotalCost(int StudentID, Date reservationDate){
        int control = 0;
        int control2 = 0;
        //creat a new TextbookReservation list to show student
        ArrayList<TextbookReservation>  list = new ArrayList<>();
        for(Student s: students){
            // if find id
            if(s.ID ==StudentID){
                a.setS(s);
                control=1;
                for(TextbookReservation tr: s.getReservations()){
                    if(tr.getReservationDate().compareTo(reservationDate)==0){
                        control2=1;
                        list.add(tr);
                    }
                }
            }

        }
        double totalcost=0;
        // if don't find
        if(control==0){
            System.out.println("Student not found");
        }
        // if don't find textreservarion
        else if(control2==0){
            System.out.println("Reservation not found");
        }

        // if find id and textreservetion list find
        else if (control == 1 && control2==1) {
            a.setList(list);
            for(TextbookReservation tr: list){
                totalcost = tr.totalReservationCost();
                System.out.println("Total cost is "+totalcost);
            }
        }

    }
    /**
     * Exit method
     * param there is no param.
     * @return does not return anything because of void.
     */
    void exit(){
        try {
            StudentSecurity.saveStudentsWithMD5(students);

            dataStorage.shutDown(this);
            dataStorage.disconnect();
        } catch (Exception e) {
            System.out.println("Database save error");
            e.printStackTrace();
        }

        System.out.println("Bye");
        System.exit(0);
    }
    void compareStudentLoyalty(int studentID1, int studentID2){
        Student student1=null;
        Student student2=null;
        for (Student s: students){
            if (studentID1 == s.getID()){
                student1 = s;
                a.setS(s);
            }
            if (studentID2 == s.getID()){
                student2 = s;
                a.setS2(s);
            }
        }
        try {
            int bool = student1.compareTo(student2);
            if(bool == 1){
                System.out.println("Name is "+ student1.getName()+ " who is more than "+  student2.getName());
                a.setResult("Name is "+ student1.getName()+ " who is more than "+  student2.getName());
            }
            else if(bool == 0){
                System.out.println("Students are equal");
                a.setResult("Students are equal");
            }
            else{
                System.out.println("Name is "+ student2.getName()+ " who is more than "+  student1.getName());
                a.setResult("Name is "+ student2.getName()+ " who is more than "+  student1.getName());

            }
        }
        catch (NullPointerException e){
            System.out.println("Student doesn't find");
        }


    }
    void  recordIdentityCheck(int studentID, String status){
        Student student = null;
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(d);
        int control = 0;
        for (Student s : students){
            if(studentID == s.getID()){
                control = 1;
                student = s;
            }
        }
        if(control==0){
            System.out.println("Stundent's ID doesn't find");

        }
        else {
            try {
                student.getIdentityCheck().put(date,status);
                a.setS(student);
            } catch (NullPointerException e) {
                System.out.println("error");
            }

        }
    }
    public void loaddatas() {

        File fStudent = new File("student.dat");
        File fEmployee = new File("employee.dat");

        //if  find file
        if (fStudent.exists()) {
            try (DataInputStream Studentin = new DataInputStream(new BufferedInputStream(new FileInputStream(fStudent)))) {

                students.clear();


                int count = Studentin.readInt();// whole number of student


                for (int i = 0; i < count; i++) {//extract from binary data and load the list
                    int id = Studentin.readInt();
                    String name = Studentin.readUTF();
                    Student s = new Student(id, name);
                    students.add(s);
                }

            } catch (IOException e) {
                System.out.println("Sytem error file doesn't load");

            }
        }
        // if find employee file
        if (fEmployee.exists()) {
            try (DataInputStream Employeein = new DataInputStream(new BufferedInputStream(new FileInputStream(fEmployee)))) {

                employees.clear();

                int count = Employeein.readInt(); // whole number of employees
                SimpleDateFormat pDate = new SimpleDateFormat("dd/MM/yyyy");

                for (int i = 0; i < count; i++) {

                    int id = Employeein.readInt();
                    String name = Employeein.readUTF();
                    String sdob = Employeein.readUTF();
                    Date dob = pDate.parse(sdob);
                    String Sstart = Employeein.readUTF();
                    Date startDate = pDate.parse(Sstart);
                    Employee e = new Employee(id, name, dob,startDate);

                    employees.add(e);
                }

            } catch (IOException |ParseException e) {
                System.out.println("Sytem error file doesn't load");
            }
        }



    }
    public void savedatas(){
        File fStudent = new File("student.dat");
        File fEmployee = new File("employee.dat");
        SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/yyyy");
        DataOutputStream Studentout = null;

        try {
            Studentout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fStudent)));
            Studentout.writeInt(students.size());
            for (int i = 0; i < students.size(); i++) {
                Studentout.writeInt(students.get(i).getID());
                Studentout.writeUTF(students.get(i).getName());
            }
            Studentout.close();
        } catch (IOException e) {
            System.out.println("Student file write error");
        }

        DataOutputStream Employeeout = null;

        try {
            Employeeout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fEmployee)));
            Employeeout.writeInt(employees.size());
            for (int i = 0; i < employees.size(); i++) {
                Employeeout.writeInt(employees.get(i).getID());
                Employeeout.writeUTF(employees.get(i).getName());
                String dob = fdate.format(employees.get(i).getDateOfBirth());
                Employeeout.writeUTF(dob);
                String start = fdate.format(employees.get(i).getStartDate());  // ✅ EKLE
                Employeeout.writeUTF(start);

            }
            Employeeout.close();

        } catch (IOException e) {
            System.out.println("Employee file write error");
        }


    }




}

