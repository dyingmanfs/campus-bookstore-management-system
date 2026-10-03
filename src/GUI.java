/**
 *
 * @author Furkan Sağlam
 * @version 2.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GUI {
    public ArrayList<TextbookReservation> getList() {
        return list;
    }

    public void setList(ArrayList<TextbookReservation> list) {
        this.list = list;
    }

    ArrayList<TextbookReservation>  list = new ArrayList<>();

    public double getTotatlcost() {
        return totatlcost;
    }

    public void setTotatlcost(double totatlcost) {
        this.totatlcost = totatlcost;
    }

    double totatlcost;
    public ArrayList<BookItem> getBooks() {
        return Books;
    }

    public void setBooks(ArrayList<BookItem> books) {
        Books = books;
    }

    public Student getS2() {
        return s2;
    }

    public void setS2(Student s2) {
        this.s2 = s2;
    }

    Student s2;

    ArrayList<BookItem> Books = new ArrayList<>();
    public void setS(Student s) {
        this.s = s;
    }

    public String[] getReservation() {
        return Reservation;
    }

    public void setReservation(String[] reservation) {
        Reservation = reservation;
    }

    String [] Reservation = new String[4];

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    String result;

    public Student getS() {
        return s;
    }

    Student s;
    public GUI(CampusBookStore cbs) {
        this.cbs = cbs;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    Employee employee;

    public void setListofstudents(String[][] listofstudents) {
        this.listofstudents = listofstudents;
    }

    String [][] listofstudents;
    public String[][] getListofstudents() {
        return listofstudents;
    }



    String [] [] listofEmploy;
    public  String [] [] getListofEmploy(){
        return listofEmploy;
    }
    public void setListofEmploy(String[][] listofEmploy) {
        this.listofEmploy = listofEmploy;
    }

    CampusBookStore cbs;
    JFrame frame = new JFrame("Welcome to Campus Book Store ");
    JLabel header = new JLabel("Menu:");
    JButton butonAddEmploy = new JButton("Add Emply");
    JButton butonDeleteEmploy = new JButton("Delete Employ");
    JButton buttonAddStudent = new JButton("Add Student");
    JButton butonlistEmployeeDetails = new JButton("Employee Details");
    JButton buttonDeleteStudent = new JButton("Delete Student");
    JButton buttonGetStudentDetail = new JButton("Get Student Detail");
    JButton buttonListofStudents = new JButton("List of student");
    JButton buttonListofEmploy = new JButton("List of Employ");
    JButton buttonMakereservation = new JButton("Make reservation");
    JButton buttonGetReservation = new JButton("Get reservation");
    JButton buttonGetReservationtotalcost = new JButton("Get totatl cost for resevation");
    JButton buttonCompareLoyalty = new JButton("Compare student loyalty");
    JButton buttonIdentityCheck = new JButton("Record identity check");


    void main(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadItem = new JMenuItem("Load Data");
        JMenuItem saveItem = new JMenuItem("Save Data");
        JMenuItem exitItem = new JMenuItem("Exit");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbs.loaddatas();
                JOptionPane.showMessageDialog(frame, "Data loaded.");
            }
        });
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbs.savedatas();
                JOptionPane.showMessageDialog(frame, "Data saved.");
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cbs.savedatas(); // istersen kaldırabilirsin
                cbs.exit();
                System.exit(0);
            }
        });
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        buttonCompareLoyalty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compareLoyaltyGUI();
            }
        });

        buttonIdentityCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                identityCheckGUI();
            }
        });

        buttonGetReservationtotalcost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSutentTotalcost();
            }
        });
        buttonGetReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getStudetreservation();
            }
        });
        buttonMakereservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makereservation();
            }
        });
        buttonListofEmploy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListofEmploy();
            }
        });
        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Addstudent();
            }
        });
        buttonListofStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListofStudent();
            }
        });
        buttonGetStudentDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentDetail();
            }
        });

        buttonDeleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteStudet();
            }
        });

        butonlistEmployeeDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeedetail();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 5, 5));

        Container contentPane = frame.getContentPane();
        panel.add(header);
        panel.add(butonAddEmploy);
        panel.add(butonDeleteEmploy);
        panel.add(butonlistEmployeeDetails);
        panel.add(buttonAddStudent);
        panel.add(buttonDeleteStudent);
        panel.add(buttonGetStudentDetail);
        panel.add(buttonListofStudents);
        panel.add(buttonListofEmploy);
        panel.add(buttonMakereservation);
        panel.add(buttonGetReservation);
        panel.add(buttonGetReservationtotalcost);
        panel.add(buttonCompareLoyalty);
        panel.add(buttonIdentityCheck);
        butonDeleteEmploy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteEmployee();
            }
        });
        butonAddEmploy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmploy();
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
        System.out.println("Welcome to Campus Book Store");

    }
    void compareLoyaltyGUI() {
        frame.setVisible(false);

        JFrame cmp = new JFrame("Compare Student Loyalty");
        cmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cmp.setSize(frame.getSize());
        cmp.setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField id1 = new JTextField();
        JTextField id2 = new JTextField();

        p.add(new JLabel("Student ID 1"));
        p.add(id1);
        p.add(new JLabel("Student ID 2"));
        p.add(id2);

        JTextArea out = new JTextArea();
        out.setEditable(false);
        JScrollPane scroll = new JScrollPane(out);

        JButton show = new JButton("Show");
        JButton back = new JButton("Back");

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(show, BorderLayout.NORTH);
        bottom.add(back, BorderLayout.SOUTH);

        cmp.add(p, BorderLayout.NORTH);
        cmp.add(scroll, BorderLayout.CENTER);
        cmp.add(bottom, BorderLayout.SOUTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmp.setVisible(false);
                frame.setVisible(true);
            }
        });

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.setText("");

                int ID1, ID2;
                try {
                    ID1 = Integer.parseInt(id1.getText());
                    ID2 = Integer.parseInt(id2.getText());
                    cbs.compareStudentLoyalty(ID1,ID2);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cmp, "Invalid ID");
                    return;
                }





                if (s == null || s2 == null) {
                    out.append("Student doesn't find\n");
                    return;
                }
                try {
                    out.append(result);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(cmp, "Result Eror");

                }


            }
        });

        cmp.setVisible(true);
    }
    void identityCheckGUI() {
        frame.setVisible(false);

        JFrame mianf = new JFrame("Record Identity Check");
        mianf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mianf.setSize(frame.getSize());
        mianf.setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField idField = new JTextField();

        String[] options = {"On probation","Valid, regular status"};
        JComboBox<String> statusBox = new JComboBox<>(options);

        p.add(new JLabel("Student ID"));
        p.add(idField);

        p.add(new JLabel("Status"));
        p.add(statusBox);

        JTextArea out = new JTextArea();
        out.setEditable(false);
        JScrollPane scroll = new JScrollPane(out);

        JButton save = new JButton("Save");
        JButton back = new JButton("Back");

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(save, BorderLayout.NORTH);
        bottom.add(back, BorderLayout.SOUTH);

        mianf.add(p, BorderLayout.NORTH);
        mianf.add(scroll, BorderLayout.CENTER);
        mianf.add(bottom, BorderLayout.SOUTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mianf.setVisible(false);
                frame.setVisible(true);
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.setText("");

                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                    cbs.recordIdentityCheck(id,(String)statusBox.getSelectedItem());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mianf, "Invalid ID");
                    return;
                }
                for (String key : s.getIdentityCheck().keySet()) {
                    out.append(key + " -> " + s.getIdentityCheck().get(key) + "\n");
                }
                JOptionPane.showMessageDialog(mianf, "Sucsessful!");

            }
        });

        mianf.setVisible(true);
    }


    void employeedetail(){
        frame.setVisible(false);

        JFrame EmployeeDetail = new JFrame("Student Detail");
        EmployeeDetail.setSize(frame.getSize());
        EmployeeDetail.setVisible(true);
        JTextField ID = new JTextField();
        JTextArea employeed = new JTextArea();


        JLabel employeeID=new JLabel("Enter the Employee ID");
        employeed.setEditable(false);
        JPanel mainp  = new JPanel(new GridLayout(0, 1, 5, 5));
        JPanel bottomp = new JPanel(new BorderLayout());
        JScrollPane scrolls = new JScrollPane(employeed);

        mainp.add(employeeID);
        mainp.add(ID);
        mainp.add(scrolls);
        JButton btnBack = new JButton("Back");
        JButton show  = new JButton("Show");
        bottomp.add(show,BorderLayout.NORTH);
        bottomp.add(btnBack,BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeDetail.setVisible(false);
                frame.setVisible(true);
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeed.setText("");
                cbs.listEmployeeDetails(Integer.parseInt(ID.getText()));
                employeed.append("Name is "+employee.getName()+" \n ID is "+employee.getID()+"\n Date of birth "+employee.getDateOfBirth()+"\nDate of Start "+employee.getStartDate());
            }
        });
        EmployeeDetail.add(mainp);
        EmployeeDetail.add(bottomp,BorderLayout.SOUTH);

    }
    void makereservation() {
        frame.setVisible(false);

        JFrame r = new JFrame("Make a reservation");
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r.setSize(frame.getSize());
        JPanel mainp = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField studentID = new JTextField();
        JTextField dateField = new JTextField();

        String[] paidOptions = {"Paid", "Not Paid"};
        JComboBox<String> isPaid = new JComboBox<>(paidOptions);

        JTextField bookType = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        JTextArea bookListArea = new JTextArea();
        bookListArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(bookListArea);

        JButton addBook = new JButton("Add Book");
        JButton save = new JButton("Save Reservation");
        JButton btnBack = new JButton("Back");
        mainp.add(new JLabel("Enter the ID"));
        mainp.add(studentID);
        mainp.add(new JLabel("Enter date (dd/mm/yyyy)"));
        mainp.add(dateField);
        mainp.add(new JLabel("Choose paid type"));
        mainp.add(isPaid);
        mainp.add(new JLabel("Book Type"));
        mainp.add(bookType);

        mainp.add(new JLabel("Quantity"));
        mainp.add(quantityField);

        mainp.add(new JLabel("Price"));
        mainp.add(priceField);

        mainp.add(addBook);
        mainp.add(new JLabel(""));

        mainp.add(new JLabel("Books"));
        mainp.add(scroll);

        JPanel bottom = new JPanel(new GridLayout(1, 2, 5, 5));
        bottom.add(save);
        bottom.add(btnBack);

        r.add(mainp, BorderLayout.CENTER);
        r.add(bottom, BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Books.clear();
                r.setVisible(false);
                frame.setVisible(true);
            }


        });

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String type = bookType.getText();
                    int quantity = Integer.parseInt(quantityField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    BookItem b = new BookItem(type, quantity, price, cbs.randomEmployee());
                    Books.add(b);
                    bookListArea.append("Type: " + type + " Qty: " + quantity + " Price: " + price + "\n");
                    bookType.setText("");
                    quantityField.setText("");

                    priceField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(r, "Invalid book input");
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Reservation[0] = studentID.getText();
                    Reservation[3] = dateField.getText();

                    String paidText = (String) isPaid.getSelectedItem();
                    if (paidText.equals("Paid")){
                        Reservation[2] = "true";
                    }
                    else{
                        Reservation[2] = "false";
                    }

                    int id = Integer.parseInt(Reservation[0]);

                    // öğrenci var mı kontrol
                    Student target = null;
                    for (Student s : cbs.students) {
                        if (s.getID() == id) {
                            target = s;
                            break;
                        }
                    }
                    if (target == null) {
                        JOptionPane.showMessageDialog(r, "Student not found");
                        return;
                    }

                    // date parse
                    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                    Date d = ft.parse(Reservation[3]);

                    boolean paid = Boolean.parseBoolean(Reservation[2]);

                    TextbookReservation tr = new TextbookReservation(paid, d);

                    // kitapları ekle
                    for (BookItem b : Books) {
                        tr.addBookItem(b);
                    }

                    target.addReservation(tr);

                    JOptionPane.showMessageDialog(r, "Reservation saved");

                    Books.clear();
                    r.setVisible(false);
                    frame.setVisible(true);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(r, "Reservation error");
                }
            }
        });

        r.setVisible(true);
    }
    void getSutentTotalcost(){
        frame.setVisible(false);
        JFrame getReserf = new JFrame("Student Detail");

        getReserf.setSize(frame.getSize());
        getReserf.setVisible(true);
        JPanel p = new JPanel(new GridLayout(0,2,5,5));
        JTextField ID = new JTextField();
        JTextField date = new JTextField();
        p.add(new JLabel("Enter The ID"));
        p.add(ID);
        p.add(new JLabel("Enter the Date"));
        p.add(date);
        getReserf.add(p,BorderLayout.NORTH);
        JPanel books = new JPanel(new BorderLayout());
        JTextArea b = new JTextArea();
        b.setEditable(false);
        books.add(b);
        JButton btnBack = new JButton("Back");
        JButton show  = new JButton("Show");
        JPanel bottomp = new JPanel(new BorderLayout());
        bottomp.add(show,BorderLayout.NORTH);
        bottomp.add(btnBack,BorderLayout.SOUTH);
        getReserf.add(books,BorderLayout.CENTER);
        getReserf.add(bottomp,BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getReserf.setVisible(false);
                frame.setVisible(true);
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("");

                int id;
                Date d;

                try {
                    id = Integer.parseInt(ID.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getReserf, "Invalid ID");
                    return;
                }

                try {
                    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                    d = ft.parse(date.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getReserf, "Invalid Date");
                    return;
                }
                cbs.getStudentReservationTotalCost(id, d);
                b.append("Student: " + s.getName() + " (ID: " + s.getID() + ")\n");
                for (TextbookReservation t: list){
                    b.append("Total cost is "+ "\n"+ t.totalReservationCost());
                }

            }
        });
    }
    void getStudetreservation(){
        frame.setVisible(false);
        JFrame getReserf = new JFrame("Student Detail");

        getReserf.setSize(frame.getSize());
        getReserf.setVisible(true);

        JPanel p = new JPanel(new GridLayout(0,2,5,5));
        JTextField ID = new JTextField();
        JTextField date = new JTextField();
        p.add(new JLabel("Enter The ID"));
        p.add(ID);
        p.add(new JLabel("Enter the Date"));
        p.add(date);
        getReserf.add(p,BorderLayout.NORTH);
        JPanel books = new JPanel(new BorderLayout());
        JTextArea b = new JTextArea();
        b.setEditable(false);
        books.add(b);
        JButton btnBack = new JButton("Back");
        JButton show  = new JButton("Show");
        JPanel bottomp = new JPanel(new BorderLayout());
        bottomp.add(show,BorderLayout.NORTH);
        bottomp.add(btnBack,BorderLayout.SOUTH);
        getReserf.add(books,BorderLayout.CENTER);
        getReserf.add(bottomp,BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getReserf.setVisible(false);
                frame.setVisible(true);
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {            b.setText("");

                int id;
                Date d;

                try {
                    id = Integer.parseInt(ID.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getReserf, "Invalid ID");
                    return;
                }

                try {
                    SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
                    d = ft.parse(date.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getReserf, "Invalid Date");
                    return;
                }
                cbs.getStudentReservationDetails(id, d);
                int found = 0;

                b.append("Student: " + s.getName() + " (ID: " + s.getID() + ")\n");
                b.append("Reservation Date: " + d + "\n\n");

                for (TextbookReservation t : s.getReservations()) {

                    if (t.getReservationDate().compareTo(d) == 0) {
                        found = 1;
                        b.append("Paid Status: " + t.isPaidStatus() + "\n");
                        b.append("Books:\n");

                        for (BookItem book : t.getBookList()) {

                            b.append("Type: " + book.getType() + "\n");
                            b.append("Quantity: " + book.getQuantity() + "\n");
                            b.append("Price: " + book.getPrice() + "\n");


                            b.append("\n");
                        }
                    }
                }

                if (found == 0) {
                    b.append("Reservation not found\n");
                }

            }
        });




    }

    void studentDetail(){
        frame.setVisible(false);

        JFrame studentdetailF = new JFrame("Student Detail");
        studentdetailF.setSize(frame.getSize());
        studentdetailF.setVisible(true);
        JTextField ID = new JTextField();
        JTextArea studentd = new JTextArea();


        JLabel stuendID=new JLabel("Enter the student ID");
        JLabel books =  new JLabel("The Books List");
        JTextArea booksd = new JTextArea("Books");
        booksd.setEditable(false);
        studentd.setEditable(false);
        JPanel mainp  = new JPanel(new GridLayout(0, 1, 5, 5));
        JPanel bottomp = new JPanel(new BorderLayout());
        JScrollPane scrolls = new JScrollPane(studentd);
        JScrollPane scrollb = new JScrollPane(booksd);
        mainp.add(stuendID);
        mainp.add(ID);
        mainp.add(scrolls);
        mainp.add(books);
        mainp.add(scrollb);
        JButton btnBack = new JButton("Back");
        JButton show  = new JButton("Show");
        bottomp.add(show,BorderLayout.NORTH);
        bottomp.add(btnBack,BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentdetailF.setVisible(false);
                frame.setVisible(true);
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentd.setText("");
                cbs.getStudentDetails(Integer.parseInt(ID.getText()));
                studentd.append("Name is "+s.getName()+" \n ID is "+s.getID());
                booksd.setText("");
                for(TextbookReservation t : s.getReservations()){
                    booksd.append("paid is "+ t.isPaidStatus() + "\nReservation date is "+t.reservationDate + "\n");
                    for (BookItem b : t.getBookList()){
                        booksd.append("Book type "+b.getType() + " Book price is "+ b.getPrice()+ " Book is "+ b.getQuantity()+"\n");
                    }
                }
            }
        });
        studentdetailF.add(mainp);
        studentdetailF.add(bottomp,BorderLayout.SOUTH);


    }
    void DeleteEmployee(){
        frame.setVisible(false);
        JFrame deleteEmployee = new JFrame("Delete Student");
        deleteEmployee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteEmployee.setSize(frame.getSize());
        JPanel delete = new JPanel();
        delete.setLayout(new GridLayout(0,1,5,5));
        JPanel Battom = new JPanel(new BorderLayout());
        JTextField tfID = new JTextField("Enter the id to delete");
        JButton btnDelete = new JButton("Delete");
        JButton btnBack = new JButton("Back");
        delete.add(new JLabel("Enter the Employee ID to delete:"));
        delete.add(new JLabel("ID:"));
        delete.add(tfID);
        Battom.add(btnDelete,BorderLayout.NORTH);
        Battom.add(btnBack,BorderLayout.SOUTH);
        deleteEmployee.add(delete);
        deleteEmployee.add(Battom,BorderLayout.SOUTH);
        deleteEmployee.setVisible(true);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idText = tfID.getText();
                int id;
                id = Integer.parseInt(idText);


                int control = 0;
                for (Employee em: cbs.employees) {
                    if (em.getID() == id) {
                        control=1;
                        JOptionPane.showMessageDialog(deleteEmployee, "Employee find and delete");
                        break;
                    }
                }
                if(control==0){
                    JOptionPane.showMessageDialog(deleteEmployee, "Employee doesn't find please enter again");

                }
                else{
                    cbs.deleteEmployee(id);

                }

            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee.setVisible(false);
                frame.setVisible(true);
            }
        });

    }
    void DeleteStudet(){
        frame.setVisible(false);
        JFrame deletestudent  = new JFrame("Delete Student");
        deletestudent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deletestudent.setSize(frame.getSize());
        JPanel delete = new JPanel();
        delete.setLayout(new GridLayout(0,2,5,5));
        JTextField tfID = new JTextField("Enter the id to delete");
        JButton btnDelete = new JButton("Delete");
        JButton btnBack = new JButton("Back");

        delete.add(new JLabel("ID:"));
        delete.add(tfID);
        delete.add(btnDelete);
        delete.add(btnBack);
        deletestudent.add(delete);
        deletestudent.setVisible(true);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String idText = tfID.getText();
                int id;
                id = Integer.parseInt(idText);


                int control = 0;
                for (Student s : cbs.students) {
                    if (s.getID() == id) {
                        control=1;
                        JOptionPane.showMessageDialog(deletestudent, "Stundet find and delete");
                        break;
                    }
                }
                if(control==0){
                    JOptionPane.showMessageDialog(deletestudent, "Stundet doesn't find please enter again");

                }
                else{
                    cbs.deleteStudent(id);

                }

            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletestudent.setVisible(false);
                frame.setVisible(true);
            }
        });


    }
    void AddEmploy(){
        frame.setVisible(false);

        JFrame AddEmploy = new JFrame("Employ Student");
        AddEmploy.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddEmploy.setSize(frame.getSize());

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(0, 1, 5, 5));
        JTextField tfName = new JTextField();
        JTextField tfID = new JTextField();
        JTextField Date = new JTextField();

        JButton btnAdd = new JButton("Add");
        JButton btnBack = new JButton("Back");

        p.add(new JLabel("Name:"));
        p.add(tfName);
        p.add(new JLabel("Emplye ID:"));
        p.add(tfID);
        p.add(new JLabel("Emplye date of birth:"));
        p.add(Date);
        p.add(btnAdd);
        p.add(btnBack);

        AddEmploy.add(p);
        AddEmploy.setVisible(true);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String idText = tfID.getText();
                String date = Date.getText();
                int id;
                id = Integer.parseInt(idText);
                SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");




                for (Employee em : cbs.employees) {
                    if (em.getID() == id) {
                        JOptionPane.showMessageDialog(AddEmploy, "This ID already exists!");
                        return;
                    }
                }

                try {
                    Employee newEmployee = new Employee(id, name,ft.parse(date));
                    cbs.employees.add(newEmployee);
                    JOptionPane.showMessageDialog(AddEmploy, "Employee added successfully!");


                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(AddEmploy, "Parese Erorr please try again");
                }


            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmploy.setVisible(false);
                frame.setVisible(true);
            }
        });
    }
    void Addstudent(){

                frame.setVisible(false);

                JFrame addStudentFrame = new JFrame("Add Student");
                addStudentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                addStudentFrame.setSize(frame.getSize());

                JPanel p = new JPanel();
                p.setLayout(new GridLayout(0, 1, 5, 5));
                JTextField tfName = new JTextField();
                JTextField tfID = new JTextField();

                JButton btnAdd = new JButton("Add");
                JButton btnBack = new JButton("Back");

                p.add(new JLabel("Name:"));
                p.add(tfName);
                p.add(new JLabel("Student ID:"));
                p.add(tfID);
                p.add(btnAdd);
                p.add(btnBack);

                addStudentFrame.add(p);
                addStudentFrame.setVisible(true);

                btnAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name = tfName.getText();
                        String idText = tfID.getText();
                        int id;
                        id = Integer.parseInt(idText);



                        for (Student s : cbs.students) {
                            if (s.getID() == id) {
                                JOptionPane.showMessageDialog(addStudentFrame, "This ID already exists!");
                                return;
                            }
                        }


                        Student newStudent = new Student(id, name);
                        cbs.students.add(newStudent);

                        JOptionPane.showMessageDialog(addStudentFrame, "Student added successfully!");

                    }
                });

                btnBack.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addStudentFrame.setVisible(false);
                        frame.setVisible(true);
                    }
                });
            }
    void ListofEmploy(){
        cbs.listEmployees();

        String[][] data = getListofEmploy();
        String[] columns = {"Employe Name ","ID","Day of Birth","Day of Start"};
        frame.setVisible(false);
        JFrame EmploytList = new JFrame("All Employ list");
        EmploytList.setSize(frame.getSize());
        JPanel listpanel  = new JPanel(new BorderLayout());
        JTable EmployTable = new JTable(data, columns);
        EmployTable.setEnabled(false);
        JScrollPane scroll = new JScrollPane(EmployTable);
        listpanel.add(scroll, BorderLayout.CENTER);
        JButton btnBack = new JButton("Back");
        JPanel Bottom = new JPanel();
        Bottom.add(btnBack);
        listpanel.add(Bottom,BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmploytList.setVisible(false);
                frame.setVisible(true);
            }
        });

        EmploytList.add(listpanel);
        EmploytList.setVisible(true);

    }
    void ListofStudent(){
        cbs.listStudents();

        String[][] data = getListofstudents();
        String[] columns = {"Student ID","Name"};
        frame.setVisible(false);
        JFrame studentList = new JFrame("All students list");
        studentList.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentList.setSize(frame.getSize());
        JPanel listpanel  = new JPanel(new BorderLayout());
        JTable stundstable = new JTable(data, columns);
        stundstable.setEnabled(false);
        JScrollPane scroll = new JScrollPane(stundstable);
        listpanel.add(scroll, BorderLayout.CENTER);
        JButton btnBack = new JButton("Back");
        JPanel Bottom = new JPanel();
        Bottom.add(btnBack);
        listpanel.add(Bottom,BorderLayout.SOUTH);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentList.setVisible(false);
                frame.setVisible(true);
            }
        });
        studentList.add(listpanel);
        studentList.setVisible(true);






    }



}
