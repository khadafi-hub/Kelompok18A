/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbaju;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MDafi
 */
public class dashboard extends javax.swing.JFrame {

    /**
     * Creates new form dashboard
     */
     private static KoneksiDB kdb = new KoneksiDB();
    
     
    private static String pilihan = "";
    
    private static inheritanceAll operanAll = new inheritanceAll();
   
    private static String NIK = "";
    private static String jabatan = "";
    private static String nama = "";
    private static String katasandi = "";
    private static String tanggallahir = "";
   private static  String gaji = "";
    
 // popup 
        Popup p; 
        
        // create a label 
        JPanel p1 = new JPanel(); 
        PopupFactory pf = new PopupFactory(); 
        // create a panel
        
        Popup p3; 
        
        // create a label 
        JPanel p4 = new JPanel(); 
        
        // create a panel
        
        
    public dashboard() {
        initComponents();
        
        pil(pilihan);
        
        JPanel p2 = helppane; 
        // create a popup 
        p = pf.getPopup(p1, p2, 600, 275);
        
        JPanel p5 = profilepane; 
        // create a popup 
        p3 = pf.getPopup(p4, p5, 600, 275);
        
       
        
        kdb.koneksiDatabase();
         try {
            
            String sql = "SELECT * FROM akun WHERE NIK='"+operanAll.getNik()+"'" ;   
            
            Statement stat = kdb.getKoneksi().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                
               
                NIK = hasil.getString("NIK");
                jabatan = hasil.getString("Jabatan") ;
                nama = hasil.getString("Nama");
                katasandi = hasil.getString("KataSandi");
                tanggallahir = hasil.getString("TanggalLahir");
                gaji = hasil.getString("Gaji");
                System.out.println(NIK);
                
                            
            }
         }catch (Exception e) {
          //  JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
         
        
        SelamatDatang.setText("SELAMAT DATANG ");
        
        Namalabel.setText(operanAll.getNama());
        NIKlabel.setText(operanAll.getNik());
        
        
    }
    
    public void profileSetter(String name){
        kdb.koneksiDatabase();
         try {
             String sql = "SELECT * FROM akun WHERE NIK='"+operanAll.getNik()+"'" ;   
            
           
            Statement stat = kdb.getKoneksi().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                
               
               
                
                NikKanan.setText(NIK);
                JabatanKanan.setText(jabatan);
                NamaKanan.setText(nama);
                KataSandiKanan.setText(katasandi);
                TanggalLahirKanan.setText(tanggallahir);
                GajiKanan.setText(gaji);
                
                            
            }
         }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
         
        
    }
    
    public void mouseEnteredExitedReleasedPanelKiri(JLabel label, String tujuan, String pilihan){
        if(tujuan.equalsIgnoreCase("Entered")){
            label.setForeground(new Color(242, 37, 200));
            
        }
        if(tujuan.equalsIgnoreCase("Exited")){
            label.setForeground(new Color(150,114,182));
            
        }
        if(tujuan.equalsIgnoreCase("Released")){
            
            if(pilihan.equalsIgnoreCase("Kasir")){
                PanelKasir panK = new PanelKasir();
                panK.setVisible(true);
                int state = panK.getExtendedState();
                state &= ~JFrame.ICONIFIED;
                panK.setExtendedState(state);
                panK.setAlwaysOnTop(true);
                panK.toFront();
                panK.requestFocus();
                panK.setAlwaysOnTop(false);
                this.dispose();
                
            } else if(pilihan.equalsIgnoreCase("Persediaan")){
                pil("0");
                label.setForeground(new Color(150,114,182));
                PanelPersediaan PP = new PanelPersediaan();

                PP.setVisible(true);
                int state = PP.getExtendedState();
                state &= ~JFrame.ICONIFIED;
                PP.setExtendedState(state);
                PP.setAlwaysOnTop(true);
                PP.toFront();
                PP.requestFocus();
                PP.setAlwaysOnTop(false);
                this.dispose();
                
            }  else if(pilihan.equalsIgnoreCase("Admin")){
                if(operanAll.getJabatan().equalsIgnoreCase("Admin")){
                PanelAdmin panAD = new PanelAdmin();
                panAD.setVisible(true);
                int state = panAD.getExtendedState();
                state &= ~JFrame.ICONIFIED;
                panAD.setExtendedState(state);
                panAD.setAlwaysOnTop(true);
                panAD.toFront();
                panAD.requestFocus();
                panAD.setAlwaysOnTop(false);
                this.dispose();
                this.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Hanya admin yang boleh memakai fitur ini","Informasi", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                
                
            } 
            
        
        
        }
        
    }
    
    
    public void mouseEnteredExitedReleasedPanelKanan(JLabel label, String tujuan, String pilihan){
        if(tujuan.equalsIgnoreCase("Entered")){
            label.setForeground(new Color(242, 37, 200));
        }
        if(tujuan.equalsIgnoreCase("Exited")){
            label.setForeground(new Color(150, 114, 182));
        }
        if(tujuan.equalsIgnoreCase("Released")){
            
            pil(pilihan);
            label.setForeground(new Color(150,114,182));
            PanelPersediaan PP = new PanelPersediaan();

            PP.setVisible(true);
            int state = PP.getExtendedState();
            state &= ~JFrame.ICONIFIED;
            PP.setExtendedState(state);
            PP.setAlwaysOnTop(true);
            PP.toFront();
            PP.requestFocus();
            PP.setAlwaysOnTop(false);
            
            this.dispose();
        }
        
    }

    public static void pil(String pilihan) {
        
        if (null != pilihan) {
            switch (pilihan) {
                case "0": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/dashboar.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock");
                    pilih.setText(pilihan);
                    break;
                }
                case "1": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil1.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Sweater_Jumper'");
                    pilih.setText(pilihan);
                    break;
                }
                case "2": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil2.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Romper'");
                    pilih.setText(pilihan);
                    break;
                }
                case "3": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil3.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Kemeja'");
                    pilih.setText(pilihan);
                    break;
                }
                case "4": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil4.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Rok'");
                    pilih.setText(pilihan);
                    break;
                }
                case "5": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil5.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Kaos'");
                    pilih.setText(pilihan);
                    break;
                }
                case "6": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil6.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Topi'");
                    pilih.setText(pilihan);
                    break;
                }

                case "7": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil6.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Kacamata'");
                    pilih.setText(pilihan);
                    break;
                }

                case "8": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil6.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Sepatu'");
                    pilih.setText(pilihan);
                    break;
                }

                case "9": {
                    //ImageIcon A= new ImageIcon(getClass().getResource("/img/pil6.jpg"));
                    //bg.setIcon(A);
                    sqlrubah.setText("SELECT * FROM stock WHERE JenisProduk='Sandal'");
                    pilih.setText(pilihan);
                    break;
                }

                default:
                    break;

            }
        }
        System.out.println(pilihan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGroundKiriKanan = new javax.swing.JPanel();
        profilepane = new javax.swing.JPanel();
        profilejudul = new javax.swing.JLabel();
        closeLogo1 = new javax.swing.JLabel();
        NikKiri = new javax.swing.JLabel();
        JabatanKiri = new javax.swing.JLabel();
        NamaKiri = new javax.swing.JLabel();
        KataSandiKiri = new javax.swing.JLabel();
        TanggalLahirKiri = new javax.swing.JLabel();
        GajiKiri = new javax.swing.JLabel();
        NamaKanan = new javax.swing.JLabel();
        KataSandiKanan = new javax.swing.JLabel();
        TanggalLahirKanan = new javax.swing.JLabel();
        GajiKanan = new javax.swing.JLabel();
        helppane = new javax.swing.JPanel();
        helpjudul = new javax.swing.JLabel();
        closeLogo = new javax.swing.JLabel();
        hubungilabel = new javax.swing.JLabel();
        kontakdafi = new javax.swing.JLabel();
        kontakidham = new javax.swing.JLabel();
        kontakcaesar = new javax.swing.JLabel();
        viewpane = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        Help = new javax.swing.JLabel();
        Settings2 = new javax.swing.JLabel();
        Settings1 = new javax.swing.JLabel();
        PanelKiri = new javax.swing.JPanel();
        PanelLogoMrMeat = new javax.swing.JPanel();
        LogoMrMeat = new javax.swing.JLabel();
        PanelKasir = new javax.swing.JPanel();
        LogoKasir = new javax.swing.JLabel();
        MenuKasirLabel = new javax.swing.JLabel();
        PanelPersediaan = new javax.swing.JPanel();
        LogoPersediaan = new javax.swing.JLabel();
        MenuPersediaanLabel = new javax.swing.JLabel();
        PanelProfile = new javax.swing.JPanel();
        LogoProfile = new javax.swing.JLabel();
        MenuProfileLabel = new javax.swing.JLabel();
        PanelAdmin = new javax.swing.JPanel();
        LogoAdmin = new javax.swing.JLabel();
        MenuAdminLabel = new javax.swing.JLabel();
        BackgroundKiri = new javax.swing.JLabel();
        PanelKanan = new javax.swing.JPanel();
        PanelKananDepan = new javax.swing.JPanel();
        PanelSweaterJumper1 = new javax.swing.JPanel();
        PanelRomper1 = new javax.swing.JPanel();
        PanelKemeja1 = new javax.swing.JPanel();
        PanelRok1 = new javax.swing.JPanel();
        PanelKaos1 = new javax.swing.JPanel();
        PanelTopi1 = new javax.swing.JPanel();
        PanelKacamata1 = new javax.swing.JPanel();
        PanelSepatu1 = new javax.swing.JPanel();
        PanelSandal1 = new javax.swing.JPanel();
        PanelSweaterJumper = new javax.swing.JPanel();
        LogoSweaterJumper = new javax.swing.JLabel();
        MenuSweaterJumperLabel = new javax.swing.JLabel();
        PanelRomper = new javax.swing.JPanel();
        LogoRomper = new javax.swing.JLabel();
        MenuRomperLabel = new javax.swing.JLabel();
        PanelKemeja = new javax.swing.JPanel();
        LogoKemeja = new javax.swing.JLabel();
        MenuKemejaLabel = new javax.swing.JLabel();
        PanelRok = new javax.swing.JPanel();
        LogoRok = new javax.swing.JLabel();
        MenuRokLabel = new javax.swing.JLabel();
        PanelKaos = new javax.swing.JPanel();
        LogoKaos = new javax.swing.JLabel();
        MenuKaosLabel = new javax.swing.JLabel();
        PanelTopi = new javax.swing.JPanel();
        LogoTopi = new javax.swing.JLabel();
        MenuTopiLabel = new javax.swing.JLabel();
        PanelKacaMata = new javax.swing.JPanel();
        LogoKacamata = new javax.swing.JLabel();
        MenuKacamataLabel = new javax.swing.JLabel();
        PanelSepatu = new javax.swing.JPanel();
        LogoSepatu = new javax.swing.JLabel();
        MenuSepatuLabel = new javax.swing.JLabel();
        PanelSandal = new javax.swing.JPanel();
        LogoSandal = new javax.swing.JLabel();
        MenuSandalLabel = new javax.swing.JLabel();
        NIKlabel = new javax.swing.JLabel();
        BackGroundPanelKanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGroundKiriKanan.setBackground(new java.awt.Color(255, 51, 102));
        BackGroundKiriKanan.setPreferredSize(new java.awt.Dimension(720, 550));
        BackGroundKiriKanan.setLayout(null);

        profilepane.setBackground(new java.awt.Color(51, 0, 97));
        profilepane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        profilepane.setEnabled(false);
        profilepane.setVisible(false);
        profilepane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilepaneMouseEntered(evt);
            }
        });

        profilejudul.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        profilejudul.setForeground(new java.awt.Color(150, 114, 182));
        profilejudul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-contact-64.png"))); // NOI18N
        profilejudul.setText("PROFILE");
        profilejudul.setToolTipText("");
        profilejudul.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        profilejudul.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        profilejudul.setFocusable(false);
        profilejudul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilejudulMouseClicked(evt);
            }
        });

        closeLogo1.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        closeLogo1.setForeground(new java.awt.Color(150, 114, 182));
        closeLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close-sign-45.png"))); // NOI18N
        closeLogo1.setToolTipText("");
        closeLogo1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        closeLogo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLogo1.setFocusable(false);
        closeLogo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLogo1MouseClicked(evt);
            }
        });

        NikKiri.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        NikKiri.setForeground(new java.awt.Color(150, 114, 182));
        NikKiri.setText("NIK                         :");
        NikKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NikKiri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NikKiri.setPreferredSize(new java.awt.Dimension(136, 45));
        NikKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NikKiriMouseClicked(evt);
            }
        });

        JabatanKiri.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        JabatanKiri.setForeground(new java.awt.Color(150, 114, 182));
        JabatanKiri.setText("Jabatan                :");
        JabatanKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JabatanKiri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JabatanKiri.setPreferredSize(new java.awt.Dimension(136, 45));
        JabatanKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JabatanKiriMouseClicked(evt);
            }
        });

        NamaKiri.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        NamaKiri.setForeground(new java.awt.Color(150, 114, 182));
        NamaKiri.setText("Nama                    :");
        NamaKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NamaKiri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NamaKiri.setPreferredSize(new java.awt.Dimension(136, 45));
        NamaKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NamaKiriMouseClicked(evt);
            }
        });

        KataSandiKiri.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        KataSandiKiri.setForeground(new java.awt.Color(150, 114, 182));
        KataSandiKiri.setText("Kata Sandi          :");
        KataSandiKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        KataSandiKiri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        KataSandiKiri.setPreferredSize(new java.awt.Dimension(136, 45));
        KataSandiKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KataSandiKiriMouseClicked(evt);
            }
        });

        TanggalLahirKiri.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        TanggalLahirKiri.setForeground(new java.awt.Color(150, 114, 182));
        TanggalLahirKiri.setText("Tanggal Lahir    :");
        TanggalLahirKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TanggalLahirKiri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TanggalLahirKiri.setPreferredSize(new java.awt.Dimension(136, 45));
        TanggalLahirKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TanggalLahirKiriMouseClicked(evt);
            }
        });

        GajiKiri.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        GajiKiri.setForeground(new java.awt.Color(150, 114, 182));
        GajiKiri.setText("Gaji                       :");
        GajiKiri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GajiKiri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GajiKiri.setPreferredSize(new java.awt.Dimension(136, 45));
        GajiKiri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GajiKiriMouseClicked(evt);
            }
        });

        NikKanan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        NikKanan.setForeground(new java.awt.Color(150, 114, 182));
        NikKanan.setText("*140*");
        NikKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NikKanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NikKanan.setPreferredSize(new java.awt.Dimension(136, 45));
        NikKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NikKananMouseClicked(evt);
            }
        });

        JabatanKanan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        JabatanKanan.setForeground(new java.awt.Color(150, 114, 182));
        JabatanKanan.setText("*140*");
        JabatanKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JabatanKanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JabatanKanan.setPreferredSize(new java.awt.Dimension(136, 45));
        JabatanKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JabatanKananMouseClicked(evt);
            }
        });

        NamaKanan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        NamaKanan.setForeground(new java.awt.Color(150, 114, 182));
        NamaKanan.setText("*nama*");
        NamaKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NamaKanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NamaKanan.setPreferredSize(new java.awt.Dimension(136, 45));
        NamaKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NamaKananMouseClicked(evt);
            }
        });

        KataSandiKanan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        KataSandiKanan.setForeground(new java.awt.Color(150, 114, 182));
        KataSandiKanan.setText("*katasandi*");
        KataSandiKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        KataSandiKanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        KataSandiKanan.setPreferredSize(new java.awt.Dimension(136, 45));
        KataSandiKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KataSandiKananMouseClicked(evt);
            }
        });

        TanggalLahirKanan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        TanggalLahirKanan.setForeground(new java.awt.Color(150, 114, 182));
        TanggalLahirKanan.setText("*tanggallahir*");
        TanggalLahirKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TanggalLahirKanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TanggalLahirKanan.setPreferredSize(new java.awt.Dimension(136, 45));
        TanggalLahirKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TanggalLahirKananMouseClicked(evt);
            }
        });

        GajiKanan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        GajiKanan.setForeground(new java.awt.Color(150, 114, 182));
        GajiKanan.setText("Gaji                       :");
        GajiKanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GajiKanan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GajiKanan.setPreferredSize(new java.awt.Dimension(136, 45));
        GajiKanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GajiKananMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout profilepaneLayout = new javax.swing.GroupLayout(profilepane);
        profilepane.setLayout(profilepaneLayout);
        profilepaneLayout.setHorizontalGroup(
            profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepaneLayout.createSequentialGroup()
                .addComponent(profilejudul, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(profilepaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JabatanKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(TanggalLahirKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(KataSandiKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(NamaKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(NikKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(GajiKiri, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilepaneLayout.createSequentialGroup()
                        .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalLahirKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(KataSandiKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(NamaKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(NikKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(GajiKanan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(JabatanKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        profilepaneLayout.setVerticalGroup(
            profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilepaneLayout.createSequentialGroup()
                .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeLogo1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profilejudul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NikKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NikKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JabatanKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JabatanKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilepaneLayout.createSequentialGroup()
                        .addComponent(NamaKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KataSandiKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TanggalLahirKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GajiKiri, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profilepaneLayout.createSequentialGroup()
                        .addComponent(NamaKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KataSandiKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TanggalLahirKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GajiKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BackGroundKiriKanan.add(profilepane);
        profilepane.setBounds(0, 0, 280, 200);

        helppane.setBackground(new java.awt.Color(51, 0, 97));
        helppane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        helppane.setEnabled(false);
        helppane.setVisible(false);
        helppane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                helppaneMouseEntered(evt);
            }
        });

        helpjudul.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        helpjudul.setForeground(new java.awt.Color(150, 114, 182));
        helpjudul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-about-45.png"))); // NOI18N
        helpjudul.setText("HELP");
        helpjudul.setToolTipText("");
        helpjudul.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        helpjudul.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        helpjudul.setFocusable(false);
        helpjudul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpjudulMouseClicked(evt);
            }
        });

        closeLogo.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        closeLogo.setForeground(new java.awt.Color(150, 114, 182));
        closeLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close-sign-45.png"))); // NOI18N
        closeLogo.setToolTipText("");
        closeLogo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        closeLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeLogo.setFocusable(false);
        closeLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLogoMouseClicked(evt);
            }
        });

        hubungilabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        hubungilabel.setForeground(new java.awt.Color(150, 114, 182));
        hubungilabel.setText("Hubungi :");
        hubungilabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hubungilabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hubungilabel.setPreferredSize(new java.awt.Dimension(136, 45));
        hubungilabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hubungilabelMouseClicked(evt);
            }
        });

        kontakdafi.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        kontakdafi.setForeground(new java.awt.Color(150, 114, 182));
        kontakdafi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-whatsapp-30.png"))); // NOI18N
        kontakdafi.setText("+62 877 8858 8302");
        kontakdafi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kontakdafi.setPreferredSize(new java.awt.Dimension(136, 45));
        kontakdafi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kontakdafiMouseClicked(evt);
            }
        });

        kontakidham.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        kontakidham.setForeground(new java.awt.Color(150, 114, 182));
        kontakidham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-whatsapp-30.png"))); // NOI18N
        kontakidham.setText("+62 812 8692 5497");
        kontakidham.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kontakidham.setPreferredSize(new java.awt.Dimension(136, 45));
        kontakidham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kontakidhamMouseClicked(evt);
            }
        });

        kontakcaesar.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        kontakcaesar.setForeground(new java.awt.Color(150, 114, 182));
        kontakcaesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-whatsapp-30.png"))); // NOI18N
        kontakcaesar.setText("+62 851 5603 1871");
        kontakcaesar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kontakcaesar.setPreferredSize(new java.awt.Dimension(136, 45));
        kontakcaesar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kontakcaesarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout helppaneLayout = new javax.swing.GroupLayout(helppane);
        helppane.setLayout(helppaneLayout);
        helppaneLayout.setHorizontalGroup(
            helppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helppaneLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(helpjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(closeLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(helppaneLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(helppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hubungilabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kontakdafi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kontakidham, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kontakcaesar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        helppaneLayout.setVerticalGroup(
            helppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(helppaneLayout.createSequentialGroup()
                .addGroup(helppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(closeLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(helpjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hubungilabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kontakdafi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kontakidham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kontakcaesar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BackGroundKiriKanan.add(helppane);
        helppane.setBounds(0, 0, 280, 190);

        viewpane.setBackground(new java.awt.Color(51, 0, 97));
        viewpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        viewpane.setEnabled(false);
        viewpane.setVisible(false);

        exit.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        exit.setForeground(new java.awt.Color(150, 114, 182));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-exit-45.png"))); // NOI18N
        exit.setText("EXIT");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.setPreferredSize(new java.awt.Dimension(136, 45));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitMouseReleased(evt);
            }
        });

        Help.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        Help.setForeground(new java.awt.Color(150, 114, 182));
        Help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-about-45.png"))); // NOI18N
        Help.setText("HELP");
        Help.setToolTipText("");
        Help.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Help.setFocusable(false);
        Help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HelpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HelpMouseExited(evt);
            }
        });

        javax.swing.GroupLayout viewpaneLayout = new javax.swing.GroupLayout(viewpane);
        viewpane.setLayout(viewpaneLayout);
        viewpaneLayout.setHorizontalGroup(
            viewpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewpaneLayout.createSequentialGroup()
                .addGroup(viewpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        viewpaneLayout.setVerticalGroup(
            viewpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewpaneLayout.createSequentialGroup()
                .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BackGroundKiriKanan.add(viewpane);
        viewpane.setBounds(140, 410, 140, 100);

        Settings2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-settings-30.png"))); // NOI18N
        Settings2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Settings2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Settings2MouseClicked(evt);
            }
        });
        BackGroundKiriKanan.add(Settings2);
        Settings2.setBounds(140, 510, 30, 30);

        Settings1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-settings-30.png"))); // NOI18N
        Settings1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Settings1.setEnabled(false);
        Settings1.setVisible(false);
        Settings1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Settings1MouseClicked(evt);
            }
        });
        BackGroundKiriKanan.add(Settings1);
        Settings1.setBounds(140, 510, 30, 30);

        PanelKiri.setPreferredSize(new java.awt.Dimension(180, 550));
        PanelKiri.setBackground(new Color(68, 30, 92,128));
        PanelKiri.setLayout(null);

        PanelLogoMrMeat.setBackground(new Color(68, 30, 92,128));

        LogoMrMeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_mr_meat_glow_logo.png"))); // NOI18N

        PanelKasir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKasir.setOpaque(false);
        PanelKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelKasirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelKasirMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelKasirMouseReleased(evt);
            }
        });

        LogoKasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cash-register-70.png"))); // NOI18N

        MenuKasirLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKasirLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuKasirLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuKasirLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKasirLabel.setText("KASIR");
        MenuKasirLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        MenuKasirLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        MenuKasirLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuKasirLabel.setOpaque(true);
        MenuKasirLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKasirLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelKasirLayout = new javax.swing.GroupLayout(PanelKasir);
        PanelKasir.setLayout(PanelKasirLayout);
        PanelKasirLayout.setHorizontalGroup(
            PanelKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuKasirLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelKasirLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LogoKasir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelKasirLayout.setVerticalGroup(
            PanelKasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKasirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LogoKasir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MenuKasirLabel)
                .addGap(0, 0, 0))
        );

        PanelPersediaan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelPersediaan.setOpaque(false);
        PanelPersediaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelPersediaanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelPersediaanMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelPersediaanMouseReleased(evt);
            }
        });

        LogoPersediaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-new-product-70.png"))); // NOI18N

        MenuPersediaanLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuPersediaanLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuPersediaanLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuPersediaanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuPersediaanLabel.setText("PERSEDIAAN");
        MenuPersediaanLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        MenuPersediaanLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        MenuPersediaanLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuPersediaanLabel.setOpaque(true);
        MenuPersediaanLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuPersediaanLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelPersediaanLayout = new javax.swing.GroupLayout(PanelPersediaan);
        PanelPersediaan.setLayout(PanelPersediaanLayout);
        PanelPersediaanLayout.setHorizontalGroup(
            PanelPersediaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPersediaanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPersediaanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LogoPersediaan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPersediaanLayout.setVerticalGroup(
            PanelPersediaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPersediaanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LogoPersediaan, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MenuPersediaanLabel)
                .addGap(0, 0, 0))
        );

        PanelProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelProfile.setOpaque(false);
        PanelProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelProfileMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelProfileMouseReleased(evt);
            }
        });

        LogoProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-contact-64.png"))); // NOI18N

        MenuProfileLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuProfileLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuProfileLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuProfileLabel.setText("PROFILE");
        MenuProfileLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        MenuProfileLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        MenuProfileLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuProfileLabel.setOpaque(true);
        MenuProfileLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuProfileLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelProfileLayout = new javax.swing.GroupLayout(PanelProfile);
        PanelProfile.setLayout(PanelProfileLayout);
        PanelProfileLayout.setHorizontalGroup(
            PanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuProfileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelProfileLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LogoProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelProfileLayout.setVerticalGroup(
            PanelProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelProfileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LogoProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MenuProfileLabel)
                .addGap(0, 0, 0))
        );

        PanelAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelAdmin.setOpaque(false);
        PanelAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelAdminMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelAdminMouseReleased(evt);
            }
        });

        LogoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-admin-settings-male-64.png"))); // NOI18N

        MenuAdminLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuAdminLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuAdminLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuAdminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuAdminLabel.setText("ADMIN");
        MenuAdminLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        MenuAdminLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        MenuAdminLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuAdminLabel.setOpaque(true);
        MenuAdminLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuAdminLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelAdminLayout = new javax.swing.GroupLayout(PanelAdmin);
        PanelAdmin.setLayout(PanelAdminLayout);
        PanelAdminLayout.setHorizontalGroup(
            PanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAdminLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelAdminLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LogoAdmin)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PanelAdminLayout.setVerticalGroup(
            PanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAdminLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LogoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MenuAdminLabel)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout PanelLogoMrMeatLayout = new javax.swing.GroupLayout(PanelLogoMrMeat);
        PanelLogoMrMeat.setLayout(PanelLogoMrMeatLayout);
        PanelLogoMrMeatLayout.setHorizontalGroup(
            PanelLogoMrMeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoMrMeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelLogoMrMeatLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PanelLogoMrMeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PanelPersediaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelKasir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLogoMrMeatLayout.setVerticalGroup(
            PanelLogoMrMeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoMrMeatLayout.createSequentialGroup()
                .addComponent(LogoMrMeat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPersediaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PanelKiri.add(PanelLogoMrMeat);
        PanelLogoMrMeat.setBounds(0, 0, 180, 550);

        BackgroundKiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_2861.jpg"))); // NOI18N
        BackgroundKiri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKiri.add(BackgroundKiri);
        BackgroundKiri.setBounds(0, 0, 180, 550);
        PanelKiri.add(sqlrubah);
        sqlrubah.setBounds(40, 0, 50, 10);
        PanelKiri.add(pilih);
        pilih.setBounds(40, 0, 50, 10);

        BackGroundKiriKanan.add(PanelKiri);
        PanelKiri.setBounds(0, 0, 180, 550);

        PanelKanan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKanan.setPreferredSize(new java.awt.Dimension(720, 550));
        PanelKanan.setLayout(null);

        PanelKananDepan.setOpaque(false);
        PanelKananDepan.setPreferredSize(new java.awt.Dimension(720, 550));
        PanelKananDepan.setLayout(null);

        PanelSweaterJumper1.setBackground(new java.awt.Color(51, 0, 97));
        PanelSweaterJumper1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelSweaterJumper1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelSweaterJumper1.setOpaque(false);
        PanelSweaterJumper1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelSweaterJumper1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSweaterJumper1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSweaterJumper1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSweaterJumper1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelSweaterJumper1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelSweaterJumper1Layout = new javax.swing.GroupLayout(PanelSweaterJumper1);
        PanelSweaterJumper1.setLayout(PanelSweaterJumper1Layout);
        PanelSweaterJumper1Layout.setHorizontalGroup(
            PanelSweaterJumper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelSweaterJumper1Layout.setVerticalGroup(
            PanelSweaterJumper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelSweaterJumper1);
        PanelSweaterJumper1.setBounds(105, 40, 150, 130);

        PanelRomper1.setBackground(new java.awt.Color(51, 0, 97));
        PanelRomper1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelRomper1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelRomper1.setOpaque(false);
        PanelRomper1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelRomper1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelRomper1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelRomper1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelRomper1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelRomper1Layout = new javax.swing.GroupLayout(PanelRomper1);
        PanelRomper1.setLayout(PanelRomper1Layout);
        PanelRomper1Layout.setHorizontalGroup(
            PanelRomper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelRomper1Layout.setVerticalGroup(
            PanelRomper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelRomper1);
        PanelRomper1.setBounds(285, 40, 150, 130);

        PanelKemeja1.setBackground(new java.awt.Color(51, 0, 97));
        PanelKemeja1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKemeja1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKemeja1.setOpaque(false);
        PanelKemeja1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelKemeja1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelKemeja1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelKemeja1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelKemeja1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelKemeja1Layout = new javax.swing.GroupLayout(PanelKemeja1);
        PanelKemeja1.setLayout(PanelKemeja1Layout);
        PanelKemeja1Layout.setHorizontalGroup(
            PanelKemeja1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelKemeja1Layout.setVerticalGroup(
            PanelKemeja1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelKemeja1);
        PanelKemeja1.setBounds(465, 40, 150, 130);

        PanelRok1.setBackground(new java.awt.Color(51, 0, 97));
        PanelRok1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelRok1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelRok1.setOpaque(false);
        PanelRok1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelRok1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelRok1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelRok1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelRok1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelRok1Layout = new javax.swing.GroupLayout(PanelRok1);
        PanelRok1.setLayout(PanelRok1Layout);
        PanelRok1Layout.setHorizontalGroup(
            PanelRok1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelRok1Layout.setVerticalGroup(
            PanelRok1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelRok1);
        PanelRok1.setBounds(105, 219, 150, 130);

        PanelKaos1.setBackground(new java.awt.Color(51, 0, 97));
        PanelKaos1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKaos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKaos1.setOpaque(false);
        PanelKaos1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelKaos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelKaos1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelKaos1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelKaos1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelKaos1Layout = new javax.swing.GroupLayout(PanelKaos1);
        PanelKaos1.setLayout(PanelKaos1Layout);
        PanelKaos1Layout.setHorizontalGroup(
            PanelKaos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelKaos1Layout.setVerticalGroup(
            PanelKaos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelKaos1);
        PanelKaos1.setBounds(285, 219, 150, 130);

        PanelTopi1.setBackground(new java.awt.Color(51, 0, 97));
        PanelTopi1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelTopi1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelTopi1.setOpaque(false);
        PanelTopi1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelTopi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelTopi1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelTopi1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelTopi1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelTopi1Layout = new javax.swing.GroupLayout(PanelTopi1);
        PanelTopi1.setLayout(PanelTopi1Layout);
        PanelTopi1Layout.setHorizontalGroup(
            PanelTopi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelTopi1Layout.setVerticalGroup(
            PanelTopi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelTopi1);
        PanelTopi1.setBounds(465, 219, 150, 130);

        PanelKacamata1.setBackground(new java.awt.Color(51, 0, 97));
        PanelKacamata1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKacamata1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKacamata1.setOpaque(false);
        PanelKacamata1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelKacamata1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelKacamata1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelKacamata1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelKacamata1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelKacamata1Layout = new javax.swing.GroupLayout(PanelKacamata1);
        PanelKacamata1.setLayout(PanelKacamata1Layout);
        PanelKacamata1Layout.setHorizontalGroup(
            PanelKacamata1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelKacamata1Layout.setVerticalGroup(
            PanelKacamata1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelKacamata1);
        PanelKacamata1.setBounds(105, 399, 150, 130);

        PanelSepatu1.setBackground(new java.awt.Color(51, 0, 97));
        PanelSepatu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelSepatu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelSepatu1.setOpaque(false);
        PanelSepatu1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelSepatu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSepatu1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSepatu1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelSepatu1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelSepatu1Layout = new javax.swing.GroupLayout(PanelSepatu1);
        PanelSepatu1.setLayout(PanelSepatu1Layout);
        PanelSepatu1Layout.setHorizontalGroup(
            PanelSepatu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelSepatu1Layout.setVerticalGroup(
            PanelSepatu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelSepatu1);
        PanelSepatu1.setBounds(285, 399, 150, 130);

        PanelSandal1.setBackground(new java.awt.Color(51, 0, 97));
        PanelSandal1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelSandal1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelSandal1.setOpaque(false);
        PanelSandal1.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelSandal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelSandal1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelSandal1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelSandal1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout PanelSandal1Layout = new javax.swing.GroupLayout(PanelSandal1);
        PanelSandal1.setLayout(PanelSandal1Layout);
        PanelSandal1Layout.setHorizontalGroup(
            PanelSandal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        PanelSandal1Layout.setVerticalGroup(
            PanelSandal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        PanelKananDepan.add(PanelSandal1);
        PanelSandal1.setBounds(465, 399, 150, 130);

        PanelSweaterJumper.setBackground(new java.awt.Color(51, 0, 97));
        PanelSweaterJumper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelSweaterJumper.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelSweaterJumper.setPreferredSize(new java.awt.Dimension(150, 130));
        PanelSweaterJumper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSweaterJumperMousePressed(evt);
            }
        });

        LogoSweaterJumper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-jumper-64.png"))); // NOI18N

        MenuSweaterJumperLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSweaterJumperLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuSweaterJumperLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuSweaterJumperLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSweaterJumperLabel.setText("SWEATER JUMPER");
        MenuSweaterJumperLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuSweaterJumperLabel.setOpaque(true);
        MenuSweaterJumperLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSweaterJumperLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelSweaterJumperLayout = new javax.swing.GroupLayout(PanelSweaterJumper);
        PanelSweaterJumper.setLayout(PanelSweaterJumperLayout);
        PanelSweaterJumperLayout.setHorizontalGroup(
            PanelSweaterJumperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSweaterJumperLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoSweaterJumper, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuSweaterJumperLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSweaterJumperLayout.setVerticalGroup(
            PanelSweaterJumperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSweaterJumperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoSweaterJumper, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuSweaterJumperLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelSweaterJumper);
        PanelSweaterJumper.setBounds(105, 40, 150, 130);

        PanelRomper.setBackground(new java.awt.Color(51, 0, 97));
        PanelRomper.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelRomper.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelRomper.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoRomper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-romper-64.png"))); // NOI18N

        MenuRomperLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuRomperLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuRomperLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuRomperLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuRomperLabel.setText("ROMPER");
        MenuRomperLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuRomperLabel.setOpaque(true);
        MenuRomperLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuRomperLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelRomperLayout = new javax.swing.GroupLayout(PanelRomper);
        PanelRomper.setLayout(PanelRomperLayout);
        PanelRomperLayout.setHorizontalGroup(
            PanelRomperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRomperLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoRomper, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuRomperLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelRomperLayout.setVerticalGroup(
            PanelRomperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRomperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoRomper, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuRomperLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelRomper);
        PanelRomper.setBounds(285, 40, 150, 130);

        PanelKemeja.setBackground(new java.awt.Color(51, 0, 97));
        PanelKemeja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKemeja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKemeja.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoKemeja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-shirt-64.png"))); // NOI18N

        MenuKemejaLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKemejaLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuKemejaLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuKemejaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKemejaLabel.setText("KEMEJA");
        MenuKemejaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuKemejaLabel.setOpaque(true);
        MenuKemejaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKemejaLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelKemejaLayout = new javax.swing.GroupLayout(PanelKemeja);
        PanelKemeja.setLayout(PanelKemejaLayout);
        PanelKemejaLayout.setHorizontalGroup(
            PanelKemejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKemejaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoKemeja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(MenuKemejaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );
        PanelKemejaLayout.setVerticalGroup(
            PanelKemejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKemejaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoKemeja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuKemejaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelKemeja);
        PanelKemeja.setBounds(465, 40, 150, 130);

        PanelRok.setBackground(new java.awt.Color(51, 0, 97));
        PanelRok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelRok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelRok.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoRok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-skirt-64.png"))); // NOI18N

        MenuRokLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuRokLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuRokLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuRokLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuRokLabel.setText("ROK");
        MenuRokLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuRokLabel.setOpaque(true);
        MenuRokLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuRokLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelRokLayout = new javax.swing.GroupLayout(PanelRok);
        PanelRok.setLayout(PanelRokLayout);
        PanelRokLayout.setHorizontalGroup(
            PanelRokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRokLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoRok, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuRokLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelRokLayout.setVerticalGroup(
            PanelRokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRokLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoRok, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuRokLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelRok);
        PanelRok.setBounds(105, 219, 150, 130);

        PanelKaos.setBackground(new java.awt.Color(51, 0, 97));
        PanelKaos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKaos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKaos.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoKaos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-t-shirt-64.png"))); // NOI18N

        MenuKaosLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKaosLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuKaosLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuKaosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKaosLabel.setText("KAOS");
        MenuKaosLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuKaosLabel.setOpaque(true);
        MenuKaosLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKaosLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelKaosLayout = new javax.swing.GroupLayout(PanelKaos);
        PanelKaos.setLayout(PanelKaosLayout);
        PanelKaosLayout.setHorizontalGroup(
            PanelKaosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKaosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoKaos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuKaosLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelKaosLayout.setVerticalGroup(
            PanelKaosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKaosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoKaos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuKaosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelKaos);
        PanelKaos.setBounds(285, 219, 150, 130);

        PanelTopi.setBackground(new java.awt.Color(51, 0, 97));
        PanelTopi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelTopi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelTopi.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoTopi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-baseball-cap-64.png"))); // NOI18N

        MenuTopiLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuTopiLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuTopiLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuTopiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuTopiLabel.setText("TOPI");
        MenuTopiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuTopiLabel.setOpaque(true);
        MenuTopiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuTopiLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelTopiLayout = new javax.swing.GroupLayout(PanelTopi);
        PanelTopi.setLayout(PanelTopiLayout);
        PanelTopiLayout.setHorizontalGroup(
            PanelTopiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTopiLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoTopi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuTopiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelTopiLayout.setVerticalGroup(
            PanelTopiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTopiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoTopi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuTopiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelTopi);
        PanelTopi.setBounds(465, 219, 150, 130);

        PanelKacaMata.setBackground(new java.awt.Color(51, 0, 97));
        PanelKacaMata.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelKacaMata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelKacaMata.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoKacamata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-glasses-64.png"))); // NOI18N

        MenuKacamataLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKacamataLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuKacamataLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuKacamataLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKacamataLabel.setText("KACAMATA");
        MenuKacamataLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuKacamataLabel.setOpaque(true);
        MenuKacamataLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKacamataLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelKacaMataLayout = new javax.swing.GroupLayout(PanelKacaMata);
        PanelKacaMata.setLayout(PanelKacaMataLayout);
        PanelKacaMataLayout.setHorizontalGroup(
            PanelKacaMataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelKacaMataLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoKacamata, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuKacamataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelKacaMataLayout.setVerticalGroup(
            PanelKacaMataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelKacaMataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoKacamata, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuKacamataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelKacaMata);
        PanelKacaMata.setBounds(105, 399, 150, 130);

        PanelSepatu.setBackground(new java.awt.Color(51, 0, 97));
        PanelSepatu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelSepatu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelSepatu.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoSepatu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-trainers-64.png"))); // NOI18N

        MenuSepatuLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSepatuLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuSepatuLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuSepatuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSepatuLabel.setText("SEPATU");
        MenuSepatuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuSepatuLabel.setOpaque(true);
        MenuSepatuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSepatuLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelSepatuLayout = new javax.swing.GroupLayout(PanelSepatu);
        PanelSepatu.setLayout(PanelSepatuLayout);
        PanelSepatuLayout.setHorizontalGroup(
            PanelSepatuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSepatuLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoSepatu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuSepatuLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSepatuLayout.setVerticalGroup(
            PanelSepatuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSepatuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoSepatu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuSepatuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelSepatu);
        PanelSepatu.setBounds(285, 399, 150, 130);

        PanelSandal.setBackground(new java.awt.Color(51, 0, 97));
        PanelSandal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        PanelSandal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelSandal.setPreferredSize(new java.awt.Dimension(150, 130));

        LogoSandal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-flip-flops-64.png"))); // NOI18N

        MenuSandalLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSandalLabel.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        MenuSandalLabel.setForeground(new java.awt.Color(150, 114, 182));
        MenuSandalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSandalLabel.setText("SANDAL");
        MenuSandalLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MenuSandalLabel.setOpaque(true);
        MenuSandalLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSandalLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PanelSandalLayout = new javax.swing.GroupLayout(PanelSandal);
        PanelSandal.setLayout(PanelSandalLayout);
        PanelSandalLayout.setHorizontalGroup(
            PanelSandalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSandalLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(LogoSandal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addComponent(MenuSandalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelSandalLayout.setVerticalGroup(
            PanelSandalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSandalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoSandal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MenuSandalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
        );

        PanelKananDepan.add(PanelSandal);
        PanelSandal.setBounds(465, 399, 150, 130);

        Namalabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Namalabel.setForeground(new java.awt.Color(255, 255, 255));
        Namalabel.setText("Dafi");
        PanelKananDepan.add(Namalabel);
        Namalabel.setBounds(190, 10, 160, 20);

        SelamatDatang.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        SelamatDatang.setForeground(new java.awt.Color(255, 255, 255));
        SelamatDatang.setText("SELAMAT DATANG");
        PanelKananDepan.add(SelamatDatang);
        SelamatDatang.setBounds(10, 10, 260, 20);

        NIKlabel.setBackground(new java.awt.Color(51, 0, 97));
        NIKlabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        NIKlabel.setForeground(new java.awt.Color(255, 255, 255));
        NIKlabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NIKlabel.setText("1402017101");
        NIKlabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NIKlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NIKlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NIKlabelMousePressed(evt);
            }
        });
        PanelKananDepan.add(NIKlabel);
        NIKlabel.setBounds(470, 10, 200, 20);

        PanelKanan.add(PanelKananDepan);
        PanelKananDepan.setBounds(0, 0, 720, 550);

        BackGroundPanelKanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_23171_1.jpg"))); // NOI18N
        BackGroundPanelKanan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 114, 182), 2));
        BackGroundPanelKanan.setPreferredSize(new java.awt.Dimension(720, 550));
        PanelKanan.add(BackGroundPanelKanan);
        BackGroundPanelKanan.setBounds(0, 0, 720, 550);

        BackGroundKiriKanan.add(PanelKanan);
        PanelKanan.setBounds(180, 0, 720, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundKiriKanan, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGroundKiriKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuSweaterJumperLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSweaterJumperLabelMousePressed
        // TODO add your handling code here:


    }//GEN-LAST:event_MenuSweaterJumperLabelMousePressed

    private void MenuRomperLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRomperLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuRomperLabelMousePressed

    private void MenuKemejaLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKemejaLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuKemejaLabelMousePressed

    private void MenuRokLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRokLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuRokLabelMousePressed

    private void MenuKaosLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKaosLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuKaosLabelMousePressed

    private void MenuTopiLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTopiLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuTopiLabelMousePressed

    private void MenuKacamataLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKacamataLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuKacamataLabelMousePressed

    private void MenuSepatuLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSepatuLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuSepatuLabelMousePressed

    private void MenuSandalLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSandalLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuSandalLabelMousePressed

    private void MenuKasirLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKasirLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuKasirLabelMousePressed

    private void MenuPersediaanLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPersediaanLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuPersediaanLabelMousePressed

    private void MenuProfileLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuProfileLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuProfileLabelMousePressed

    private void MenuAdminLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAdminLabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAdminLabelMousePressed

    private void PanelSweaterJumperMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSweaterJumperMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_PanelSweaterJumperMousePressed

    private void PanelSweaterJumper1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSweaterJumper1MousePressed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_PanelSweaterJumper1MousePressed

    private void PanelSweaterJumper1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSweaterJumper1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSweaterJumperLabel, "Released", "1");
    }//GEN-LAST:event_PanelSweaterJumper1MouseReleased

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked

    }//GEN-LAST:event_exitMouseClicked

    private void HelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpMouseClicked
        // TODO add your handling code here:
        
        helppane.setEnabled(true);
        helppane.setVisible(true);
        p.show(); 
        

//        helppane.setLocation(300, 150);
       
    }//GEN-LAST:event_HelpMouseClicked

    private void Settings2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings2MouseClicked
        // TODO add your handling code here:
        viewpane.setEnabled(true);
        viewpane.setVisible(true);
        Settings1.setEnabled(true);
        Settings1.setVisible(true);
        Settings2.setEnabled(false);
        Settings2.setVisible(false);
    }//GEN-LAST:event_Settings2MouseClicked

    private void Settings1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Settings1MouseClicked
        // TODO add your handling code here:
        viewpane.setEnabled(false);
        viewpane.setVisible(false);
        Settings1.setEnabled(false);
        Settings1.setVisible(false);
        Settings2.setEnabled(true);
        Settings2.setVisible(true);
    }//GEN-LAST:event_Settings1MouseClicked

    private void PanelSweaterJumper1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSweaterJumper1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSweaterJumperLabel, "Entered", "1");
        

    }//GEN-LAST:event_PanelSweaterJumper1MouseEntered

    private void kontakdafiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontakdafiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakdafiMouseClicked

    private void helpjudulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpjudulMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_helpjudulMouseClicked

    private void closeLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLogoMouseClicked
        // TODO add your handling code here:
        helppane.setEnabled(false);
        helppane.setVisible(false);
        p.hide();
        // create a popup 
           JPanel p2 = helppane; 
        // create a popup 
        p = pf.getPopup(p1, p2, 600, 275);
    }//GEN-LAST:event_closeLogoMouseClicked

    private void kontakidhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontakidhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakidhamMouseClicked

    private void kontakcaesarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontakcaesarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakcaesarMouseClicked

    private void hubungilabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hubungilabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hubungilabelMouseClicked

    private void PanelRomper1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRomper1MouseEntered
        // TODO add your handling code here:
         mouseEnteredExitedReleasedPanelKanan(MenuRomperLabel, "Entered", "5");
    }//GEN-LAST:event_PanelRomper1MouseEntered

    private void PanelSweaterJumper1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSweaterJumper1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSweaterJumperLabel, "Exited", "1");
    }//GEN-LAST:event_PanelSweaterJumper1MouseExited

    private void PanelRomper1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRomper1MouseExited
        // TODO add your handling code here:
          mouseEnteredExitedReleasedPanelKanan(MenuRomperLabel, "Exited", "5");
    }//GEN-LAST:event_PanelRomper1MouseExited

    private void PanelRomper1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRomper1MouseReleased
        // TODO add your handling code here:
        
         mouseEnteredExitedReleasedPanelKanan(MenuRomperLabel, "Released", "5");
    }//GEN-LAST:event_PanelRomper1MouseReleased

    private void PanelKemeja1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKemeja1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKemejaLabel, "Entered", "8");
    }//GEN-LAST:event_PanelKemeja1MouseEntered

    private void PanelKemeja1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKemeja1MouseExited
        // TODO add your handling code here:
         mouseEnteredExitedReleasedPanelKanan(MenuKemejaLabel, "Exited", "8");
    }//GEN-LAST:event_PanelKemeja1MouseExited

    private void PanelKemeja1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKemeja1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKemejaLabel, "Released", "8");
    }//GEN-LAST:event_PanelKemeja1MouseReleased

    private void PanelRok1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRok1MouseEntered
        // TODO add your handling code here:
         mouseEnteredExitedReleasedPanelKanan(MenuRokLabel, "Entered", "4");
    }//GEN-LAST:event_PanelRok1MouseEntered

    private void PanelRok1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRok1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuRokLabel, "Exited", "4");
    }//GEN-LAST:event_PanelRok1MouseExited

    private void PanelRok1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRok1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuRokLabel, "Released", "4");
    }//GEN-LAST:event_PanelRok1MouseReleased

    private void helppaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helppaneMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_helppaneMouseEntered

    private void PanelKaos1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKaos1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKaosLabel, "Entered", "2");
    }//GEN-LAST:event_PanelKaos1MouseEntered

    private void PanelKaos1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKaos1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKaosLabel, "Exited", "2");
    }//GEN-LAST:event_PanelKaos1MouseExited

    private void PanelKaos1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKaos1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKaosLabel, "Released", "2");
    }//GEN-LAST:event_PanelKaos1MouseReleased

    private void PanelTopi1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTopi1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuTopiLabel, "Entered", "3");
    }//GEN-LAST:event_PanelTopi1MouseEntered

    private void PanelTopi1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTopi1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuTopiLabel, "Exited", "3");
    }//GEN-LAST:event_PanelTopi1MouseExited

    private void PanelTopi1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTopi1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuTopiLabel, "Released", "3");
    }//GEN-LAST:event_PanelTopi1MouseReleased

    private void PanelKacamata1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKacamata1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKacamataLabel, "Entered", "6");
    }//GEN-LAST:event_PanelKacamata1MouseEntered

    private void PanelKacamata1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKacamata1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKacamataLabel, "Exited", "6");
    }//GEN-LAST:event_PanelKacamata1MouseExited

    private void PanelKacamata1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKacamata1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuKacamataLabel, "Released", "6");
    }//GEN-LAST:event_PanelKacamata1MouseReleased

    private void PanelSepatu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSepatu1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSepatuLabel, "Entered", "7");
    }//GEN-LAST:event_PanelSepatu1MouseEntered

    private void PanelSepatu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSepatu1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSepatuLabel, "Exited", "7");
    }//GEN-LAST:event_PanelSepatu1MouseExited

    private void PanelSepatu1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSepatu1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSepatuLabel, "Released", "7");
    }//GEN-LAST:event_PanelSepatu1MouseReleased

    private void PanelSandal1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSandal1MouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSandalLabel, "Entered", "9");
    }//GEN-LAST:event_PanelSandal1MouseEntered

    private void PanelSandal1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSandal1MouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSandalLabel, "Exited", "9");
    }//GEN-LAST:event_PanelSandal1MouseExited

    private void PanelSandal1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSandal1MouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKanan(MenuSandalLabel, "Released", "9");
    }//GEN-LAST:event_PanelSandal1MouseReleased

    private void PanelKasirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKasirMouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuKasirLabel, "Entered", "Kasir");
    }//GEN-LAST:event_PanelKasirMouseEntered

    private void PanelKasirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKasirMouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuKasirLabel, "Exited", "Kasir");
    }//GEN-LAST:event_PanelKasirMouseExited

    private void PanelKasirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelKasirMouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuKasirLabel, "Released", "Kasir");
    }//GEN-LAST:event_PanelKasirMouseReleased

    private void PanelPersediaanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPersediaanMouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuPersediaanLabel, "Entered", "Persediaan");
    }//GEN-LAST:event_PanelPersediaanMouseEntered

    private void PanelPersediaanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPersediaanMouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuPersediaanLabel, "Exited", "Persediaan");
    }//GEN-LAST:event_PanelPersediaanMouseExited

    private void PanelPersediaanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelPersediaanMouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuPersediaanLabel, "Released", "Persediaan");
    }//GEN-LAST:event_PanelPersediaanMouseReleased

    private void PanelProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelProfileMouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuProfileLabel, "Entered", "Profile");
    }//GEN-LAST:event_PanelProfileMouseEntered

    private void PanelProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelProfileMouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuProfileLabel, "Exited", "Profile");
    }//GEN-LAST:event_PanelProfileMouseExited

    private void PanelProfileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelProfileMouseReleased
        // TODO add your handling code here:
        
           
        profileSetter(operanAll.getNama()); 
        mouseEnteredExitedReleasedPanelKiri(MenuProfileLabel, "Released", "Profile");
        
    }//GEN-LAST:event_PanelProfileMouseReleased

    private void PanelAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelAdminMouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuAdminLabel, "Entered", "Admin");
    }//GEN-LAST:event_PanelAdminMouseEntered

    private void PanelAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelAdminMouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuAdminLabel, "Exited", "Admin");
    }//GEN-LAST:event_PanelAdminMouseExited

    private void PanelAdminMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelAdminMouseReleased
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(MenuAdminLabel, "Released", "Admin");
    }//GEN-LAST:event_PanelAdminMouseReleased

    private void HelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpMouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(Help, "Entered", "");
    }//GEN-LAST:event_HelpMouseEntered

    private void HelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HelpMouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(Help, "Exited", "");
    }//GEN-LAST:event_HelpMouseExited

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(exit, "Entered", "");
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        // TODO add your handling code here:
        mouseEnteredExitedReleasedPanelKiri(exit, "Exited", "");
    }//GEN-LAST:event_exitMouseExited

    private void profilejudulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilejudulMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_profilejudulMouseClicked

    private void closeLogo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLogo1MouseClicked
        // TODO add your handling code here:
        profilepane.setEnabled(false);
        profilepane.setVisible(false);
        p3.hide();
        // create a popup 
           JPanel p5 = profilepane; 
        // create a popup 
        p3 = pf.getPopup(p4, p5, 600, 275);
    }//GEN-LAST:event_closeLogo1MouseClicked

    private void NikKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NikKiriMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NikKiriMouseClicked

    private void profilepaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilepaneMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_profilepaneMouseEntered

    private void NamaKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NamaKiriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaKiriMouseClicked

    private void KataSandiKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KataSandiKiriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_KataSandiKiriMouseClicked

    private void TanggalLahirKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TanggalLahirKiriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TanggalLahirKiriMouseClicked

    private void GajiKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GajiKiriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GajiKiriMouseClicked

    private void GajiKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GajiKananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GajiKananMouseClicked

    private void NikKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NikKananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NikKananMouseClicked

    private void NamaKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NamaKananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaKananMouseClicked

    private void KataSandiKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KataSandiKananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_KataSandiKananMouseClicked

    private void TanggalLahirKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TanggalLahirKananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TanggalLahirKananMouseClicked

    private void exitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseReleased
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        int state = log.getExtendedState();
        state &= ~JFrame.ICONIFIED;
        log.setExtendedState(state);
        log.setAlwaysOnTop(true);
        log.toFront();
        log.requestFocus();
        log.setAlwaysOnTop(false);
        this.dispose();
    }//GEN-LAST:event_exitMouseReleased

    private void PanelProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelProfileMouseClicked
        // TODO add your handling code here:
        profilepane.setEnabled(true);
        profilepane.setVisible(true);
        p3.show();
    }//GEN-LAST:event_PanelProfileMouseClicked

    private void JabatanKiriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JabatanKiriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JabatanKiriMouseClicked

    private void JabatanKananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JabatanKananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JabatanKananMouseClicked

    private void NIKlabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NIKlabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIKlabelMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGroundKiriKanan;
    private javax.swing.JLabel BackGroundPanelKanan;
    private javax.swing.JLabel BackgroundKiri;
    private javax.swing.JLabel GajiKanan;
    private javax.swing.JLabel GajiKiri;
    private javax.swing.JLabel Help;
    public static final javax.swing.JLabel JabatanKanan = new javax.swing.JLabel();
    private javax.swing.JLabel JabatanKiri;
    private javax.swing.JLabel KataSandiKanan;
    private javax.swing.JLabel KataSandiKiri;
    private javax.swing.JLabel LogoAdmin;
    private javax.swing.JLabel LogoKacamata;
    private javax.swing.JLabel LogoKaos;
    private javax.swing.JLabel LogoKasir;
    private javax.swing.JLabel LogoKemeja;
    private javax.swing.JLabel LogoMrMeat;
    private javax.swing.JLabel LogoPersediaan;
    private javax.swing.JLabel LogoProfile;
    private javax.swing.JLabel LogoRok;
    private javax.swing.JLabel LogoRomper;
    private javax.swing.JLabel LogoSandal;
    private javax.swing.JLabel LogoSepatu;
    private javax.swing.JLabel LogoSweaterJumper;
    private javax.swing.JLabel LogoTopi;
    private javax.swing.JLabel MenuAdminLabel;
    private javax.swing.JLabel MenuKacamataLabel;
    private javax.swing.JLabel MenuKaosLabel;
    private javax.swing.JLabel MenuKasirLabel;
    private javax.swing.JLabel MenuKemejaLabel;
    private javax.swing.JLabel MenuPersediaanLabel;
    private javax.swing.JLabel MenuProfileLabel;
    private javax.swing.JLabel MenuRokLabel;
    private javax.swing.JLabel MenuRomperLabel;
    private javax.swing.JLabel MenuSandalLabel;
    private javax.swing.JLabel MenuSepatuLabel;
    private javax.swing.JLabel MenuSweaterJumperLabel;
    private javax.swing.JLabel MenuTopiLabel;
    private javax.swing.JLabel NIKlabel;
    private javax.swing.JLabel NamaKanan;
    private javax.swing.JLabel NamaKiri;
    public static final javax.swing.JLabel Namalabel = new javax.swing.JLabel();
    public static final javax.swing.JLabel NikKanan = new javax.swing.JLabel();
    private javax.swing.JLabel NikKiri;
    private javax.swing.JPanel PanelAdmin;
    private javax.swing.JPanel PanelKacaMata;
    private javax.swing.JPanel PanelKacamata1;
    private javax.swing.JPanel PanelKanan;
    private javax.swing.JPanel PanelKananDepan;
    private javax.swing.JPanel PanelKaos;
    private javax.swing.JPanel PanelKaos1;
    private javax.swing.JPanel PanelKasir;
    private javax.swing.JPanel PanelKemeja;
    private javax.swing.JPanel PanelKemeja1;
    private javax.swing.JPanel PanelKiri;
    private javax.swing.JPanel PanelLogoMrMeat;
    private javax.swing.JPanel PanelPersediaan;
    private javax.swing.JPanel PanelProfile;
    private javax.swing.JPanel PanelRok;
    private javax.swing.JPanel PanelRok1;
    private javax.swing.JPanel PanelRomper;
    private javax.swing.JPanel PanelRomper1;
    private javax.swing.JPanel PanelSandal;
    private javax.swing.JPanel PanelSandal1;
    private javax.swing.JPanel PanelSepatu;
    private javax.swing.JPanel PanelSepatu1;
    private javax.swing.JPanel PanelSweaterJumper;
    private javax.swing.JPanel PanelSweaterJumper1;
    private javax.swing.JPanel PanelTopi;
    private javax.swing.JPanel PanelTopi1;
    public static final javax.swing.JLabel SelamatDatang = new javax.swing.JLabel();
    private javax.swing.JLabel Settings1;
    private javax.swing.JLabel Settings2;
    private javax.swing.JLabel TanggalLahirKanan;
    private javax.swing.JLabel TanggalLahirKiri;
    private javax.swing.JLabel closeLogo;
    private javax.swing.JLabel closeLogo1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel helpjudul;
    private javax.swing.JPanel helppane;
    private javax.swing.JLabel hubungilabel;
    private javax.swing.JLabel kontakcaesar;
    private javax.swing.JLabel kontakdafi;
    private javax.swing.JLabel kontakidham;
    public static final javax.swing.JLabel pilih = new javax.swing.JLabel();
    private javax.swing.JLabel profilejudul;
    private javax.swing.JPanel profilepane;
    public static final javax.swing.JLabel sqlrubah = new javax.swing.JLabel();
    private javax.swing.JPanel viewpane;
    // End of variables declaration//GEN-END:variables
}
