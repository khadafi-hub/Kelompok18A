package kasirbaju;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class KoneksiDB {
    private Connection koneksi;
    
    public Connection getKoneksi(){
        return koneksi;
    }
    
    public void koneksiDatabase() { 
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
            try {
                String url, user, password;
                url = "jdbc:mysql://localhost:3306/kasirbaju"; 
                user = "root";
                password = "";
                koneksi = DriverManager.getConnection(url, user, password);

            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + se);
                System.exit(0);
            }
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!" +cnfe);
            System.exit(0);
        }
    }
    
    public static void main(String[] kon) {
        new KoneksiDB().koneksiDatabase();
    }
    
}