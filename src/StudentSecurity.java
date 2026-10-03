import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.ArrayList;

public class StudentSecurity {

    private static final String SER_FILE = "students.ser";
    private static final String MD5_FILE = "students.md5";

    public static void saveStudentsWithMD5(ArrayList<Student> students) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SER_FILE))) {
            oos.writeObject(students);
        }

        String md5 = md5OfFile(Path.of(SER_FILE));

        try (PrintWriter pw = new PrintWriter(new FileWriter(MD5_FILE))) {
            pw.println(md5);
        }
    }

    public static void startIntegrityCheckThread() {
        Thread t = new Thread(() -> {
            try {
                File ser = new File(SER_FILE);
                File md5 = new File(MD5_FILE);

                if (!ser.exists() || !md5.exists()) return;

                String oldMd5 = Files.readString(Path.of(MD5_FILE)).trim();
                String newMd5 = md5OfFile(Path.of(SER_FILE));

                if (!oldMd5.equalsIgnoreCase(newMd5)) {
                    System.out.println("⚠ WARNING: Student data file was modified!");
                    javax.swing.JOptionPane.showMessageDialog(
                            null,
                            "WARNING: Student data has been modified while the app was closed!",
                            "Security Warning",
                            javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    System.out.println("✅ Student data integrity OK (MD5 matches).");
                }

            } catch (Exception e) {
                System.out.println("Integrity check failed: " + e.getMessage());
            }
        });

        t.setDaemon(true);
        t.start();
    }

    private static String md5OfFile(Path path) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = Files.readAllBytes(path);
        byte[] digest = md.digest(bytes);

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) sb.append(String.format("%02x", b));
        return sb.toString();
    }
}
