import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataStorage {

    private static final String URL  = "jdbc:mysql://localhost:3306/campusbookstore";
    private static final String USER = "root";
    private static final String PASS = "";

    private Connection con;

    private void connect() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection(URL, USER, PASS);
        }
    }

    public void disconnect() {
        if (con != null) {
            try { con.close(); } catch (SQLException ignored) {}
        }
    }

    // --------------------------------------------------
    // Uygulama açılışı: DB'den yükle
    // --------------------------------------------------
    public void startUp(CampusBookStore store) throws SQLException {
        connect();

        List<Student> students = loadStudentsFromDB();
        List<Employee> employees = loadEmployeesFromDB();

        // ✅ CampusBookStore'da setter yok -> direkt listeleri doldur
        store.students.clear();
        store.students.addAll(students);

        store.employees.clear();
        store.employees.addAll(employees);
    }
    public void shutDown(CampusBookStore store) throws SQLException {
        connect();

        // ✅ getter yok -> direkt public listeleri gönder
        saveStudentsToDB(store.students);
        saveEmployeesToDB(store.employees);
    }


    private List<Student> loadStudentsFromDB() throws SQLException {
        List<Student> list = new ArrayList<>();

        String sql = "SELECT studentId, name, dateOfBirth FROM Student";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("studentId");
                String name = rs.getString("name");

                java.sql.Date dobSql = rs.getDate("dateOfBirth");
                Date dob = (dobSql != null) ? new Date(dobSql.getTime()) : null;

                Student s = new Student(id, name);



                list.add(s);
            }
        }
        return list;
    }

    private void saveStudentsToDB(List<Student> students) throws SQLException {
        // tabloyu temizle
        try (Statement st = con.createStatement()) {
            st.executeUpdate("DELETE FROM Student");
        }

        String sql = "INSERT INTO Student (studentId, name, dateOfBirth) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (Student s : students) {
                ps.setInt(1, s.getID());
                ps.setString(2, s.getName());


                ps.setDate(3, null);


                ps.addBatch();
            }
            ps.executeBatch();
        }
    }


    private List<Employee> loadEmployeesFromDB() throws SQLException {
        List<Employee> list = new ArrayList<>();

        String sql = "SELECT employeeId, name, dateOfBirth, startDate FROM Employee";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("employeeId");
                String name = rs.getString("name");

                java.sql.Date dobSql = rs.getDate("dateOfBirth");
                Date dob = (dobSql != null) ? new Date(dobSql.getTime()) : null;

                java.sql.Date startSql = rs.getDate("startDate");
                Date start = (startSql != null) ? new Date(startSql.getTime()) : null;

                Employee e = new Employee(id, name, dob, start);

                list.add(e);
            }
        }
        return list;
    }

    private void saveEmployeesToDB(List<Employee> employees) throws SQLException {
        try (Statement st = con.createStatement()) {
            st.executeUpdate("DELETE FROM Employee");
        }

        String sql = "INSERT INTO Employee (employeeId, name, dateOfBirth, startDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (Employee e : employees) {
                ps.setInt(1, e.getID());
                ps.setString(2, e.getName());

                Date dob = e.getDateOfBirth();
                if (dob == null) ps.setDate(3, null);
                else ps.setDate(3, new java.sql.Date(dob.getTime()));

                Date start = e.getStartDate();
                if (start == null) ps.setDate(4, null);
                else ps.setDate(4, new java.sql.Date(start.getTime()));

                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
}
