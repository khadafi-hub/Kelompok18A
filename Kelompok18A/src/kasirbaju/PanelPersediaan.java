/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbaju;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.TOP;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MDafi
 */
public class PanelPersediaan extends javax.swing.JFrame {

    /**
     * Creates new form Pos
     */
    
    
    DefaultTableModel model;
    private static dashboard dashBoard = new dashboard();
    private static KoneksiDB kdb = new KoneksiDB();
    private static String pilihan = dashboard.pilih.getText();
    
    private static inheritanceAll operanAll = new inheritanceAll();
    
    private static String NIK = "";
    private static String jabatan = "";
    private static String nama = "";
    private static String katasandi = "";
    private static String tanggallahir = "";
    private static String gaji = "";
    
    public PanelPersediaan() {
       
        initComponents();
           if(pilihan.equalsIgnoreCase("0")){
        MenuSemuaLabel.setBackground(new Color(242,37,200));
        MenuSemuaLabel.setVerticalAlignment(TOP);
        repaint();
        
        } else if(pilihan.equalsIgnoreCase("1")){
        MenuSweaterJumperLabel.setBackground(new Color(242,37,200));
        MenuSweaterJumperLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("2")){
        MenuKaosLabel.setBackground(new Color(242,37,200));
        MenuKaosLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("3")){
        MenuTopiLabel.setBackground(new Color(242,37,200));
        MenuTopiLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("4")){
        MenuRokLabel.setBackground(new Color(242,37,200));
        MenuRokLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("5")){
        MenuRomperLabel.setBackground(new Color(242,37,200));
        MenuRomperLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("6")){
        MenuKacamataLabel.setBackground(new Color(242,37,200));
        MenuKacamataLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("7")){
        MenuSepatuLabel.setBackground(new Color(242,37,200));
        MenuSepatuLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("8")){
        MenuKemejaLabel.setBackground(new Color(242,37,200));
        MenuKemejaLabel.setVerticalAlignment(TOP);
        repaint();
        } else if(pilihan.equalsIgnoreCase("9")){
        MenuSandalLabel.setBackground(new Color(242,37,200));
        MenuSandalLabel.setVerticalAlignment(TOP);
        repaint();
        }     
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
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
         
        
        kdb.koneksiDatabase();
         try {
            String sql = "SELECT * FROM stock";
            Statement stat = kdb.getKoneksi().createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                
                String jenisProduk = hasil.getString("JenisProduk") ;
                String namaProduk = hasil.getString("NamaProduk");
                String jenis = hasil.getString("Jenis");
                String satuan = hasil.getString("Satuan") ;
                String persediaan = hasil.getString("Persediaan");
                String harga = hasil.getString("Harga");
                
                model = (DefaultTableModel)ViewTable.getModel();
                
                 model.addRow(new Object[]
                    {
                        jenisProduk,
                        namaProduk,
                        jenis,
                        satuan,
                        persediaan,
                        harga,
                    });
                 
                            
            }
         }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Menampilkan data GAGAL","Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
         
       
        listed("", "");
        code();
         
         
        
    }
    
    public void sunting(){
        SuntingLabel.setBackground(new Color(242,37,200));
        repaint();
        
        SuntingLabel.setVerticalAlignment(TOP);
        repaint();
        System.out.println("q01");
        try {
            System.out.println("q02");
            String jenisProduk = (String) JenisProdukComboBox.getSelectedItem();
            System.out.println("q03");
            String namaProduk = NamaProdukTextField.getText();
            System.out.println("q04");
            String jenis = JenisTextField.getText();
            System.out.println("q05");
            String satuan = (String) SatuanComboBox.getSelectedItem();
            System.out.println("q06");
            String persediaan = PersediaanTextField.getText();
            System.out.println("q07");
            String harga = HargaTextField.getText();
            System.out.println("q08");
            if( ViewTable.getSelectedRow() != -1){
                System.out.println("q1");
                String aSQL = "UPDATE stock SET JenisProduk='"+jenisProduk+"',NamaProduk='"+namaProduk+"',Jenis='"+jenis+"',Satuan='"+satuan+"',Persediaan='"+persediaan+"',Harga='"+harga+"' WHERE Id='"+no_id.getText()+"'";
                System.out.println("q2");
                Statement S = kdb.getKoneksi().createStatement();
                System.out.println("q3");
                int R = S.executeUpdate(aSQL);
                System.out.println("q4");
                listed("","");
                System.out.println("q5");
                JOptionPane.showMessageDialog(this, "BERHASIL DI EDIT");
                JenisProdukComboBox.setSelectedItem("-- PILIHAN --");
                NamaProdukTextField.setText(null);
                JenisTextField.setText(null);
                SatuanComboBox.setSelectedItem("-- PILIHAN --"); 
                PersediaanTextField.setText(null);
                HargaTextField.setText(null);

                System.out.println(aSQL);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang mau diedit");
            }
        
            }
        catch(Exception t){
                t.printStackTrace();
                JOptionPane.showMessageDialog(null, "data gagal diedit");
        }
        
                JenisProdukComboBox.setSelectedItem("-- PILIHAN --");
                NamaProdukTextField.setText(null);
                JenisTextField.setText(null);
                SatuanComboBox.setSelectedItem("-- PILIHAN --"); 
                PersediaanTextField.setText(null);
                HargaTextField.setText(null);
        
        
    }
    
    public void hapus(){
        String id1 = no_id.getText();
        
        try {
            if( ViewTable.getSelectedRow() != -1){
                System.out.println("disini 1");
                String sql2 = "ALTER TABLE stock DROP COLUMN Id";
                System.out.println("disini 2");
                String sql3 = "ALTER TABLE `stock` ADD `Id` INT(11) NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (`Id`); ";
                System.out.println("disini 3");

           
                String SQL="DELETE FROM stock WHERE Id='"+id1+"'";
                System.out.println("disini 4");
                Statement S = kdb.getKoneksi().createStatement();
                System.out.println("disini 5");
                int R = S.executeUpdate(SQL);
                System.out.println("disini 6");
                S.executeUpdate(sql2);
                System.out.println("disini 7");
                S.executeUpdate(sql3);
                System.out.println("disini 8");
                              
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
             
                listed("","");
                JenisProdukComboBox.setSelectedItem("-- PILIHAN --");
                NamaProdukTextField.setText(null);
                JenisTextField.setText(null);
                SatuanComboBox.setSelectedItem("-- PILIHAN --"); 
                PersediaanTextField.setText(null);
                HargaTextField.setText(null);

            
            
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang mau dihapus");
            }
            


        }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
    
    }
    
    public void menyimpan(){
        if("-- PILIHAN --".equals(JenisProdukComboBox.getSelectedItem())||"".equals(JenisProdukComboBox.getSelectedItem())||"".equals(NamaProdukTextField.getText())||"".equals(JenisTextField.getText())||"-- PILIHAN --".equals(SatuanComboBox.getSelectedItem())||"".equals(SatuanComboBox.getSelectedItem())||"".equals(PersediaanTextField.getText())||"".equals(HargaTextField.getText())){
                JOptionPane.showMessageDialog(this, "DATA IS NOT VALID","Error",JOptionPane.WARNING_MESSAGE);
            }
        else{
            
                if(!"-- PILIHAN --".equals(JenisProdukComboBox.getSelectedItem())||!"".equals(JenisProdukComboBox.getSelectedItem())&&!"".equals(NamaProdukTextField.getText())&&!"".equals(JenisTextField.getText())&&!"-- PILIHAN --".equals(SatuanComboBox.getSelectedItem())||!"".equals(SatuanComboBox.getSelectedItem())&&!"".equals(PersediaanTextField.getText())&&!"".equals(HargaTextField.getText())){
                    String aSQL = "INSERT INTO stock (JenisProduk, NamaProduk, Jenis, Satuan, Persediaan, Harga)VALUES('"+JenisProdukComboBox.getSelectedItem()+"','"+NamaProdukTextField.getText()+"','"+JenisTextField.getText()+"','"+SatuanComboBox.getSelectedItem()+"','"+Integer.parseInt(PersediaanTextField.getText())+"','"+Integer.parseInt(HargaTextField.getText())+"')";
                    String cek = "SELECT * FROM stock where NamaProduk = '"+NamaProdukTextField.getText()+"'" + "AND Jenis = '"+JenisTextField.getText()+"'";
                    
                    try {
                        
                        System.out.println("tidak sukses 1");
                        Statement S = kdb.getKoneksi().createStatement();
                        System.out.println("tidak sukses 2");
                        
                        ResultSet rs = S.executeQuery(cek);
                        System.out.println("tidak sukses 3");
                            if (rs.next()){
                                System.out.println("tidak sukses 4");
                                JOptionPane.showMessageDialog(this, "Data Sudah Ada");
                            }
                            else{
                                System.out.println("tidak sukses 5");
                                int R = S.executeUpdate(aSQL);
                                System.out.println("tidak sukses 6");
                                listed("", "");
                                System.out.println("tidak sukses 7");
                            }
                            System.out.println("tidak sukses 8");
                        
                    } catch (SQLException ex) {
                        System.out.println("tidak sukses");
                        
                    }
                    System.out.println("sukses");
                }
                else
                {
                    System.out.println("gagal");
                }
        }
    }
   

    public void code(){
        try{
            
            Connection cn1 = kdb.getKoneksi();
            String sql = "SELECT nama FROM jenisproduk GROUP BY nama";
            Statement S = cn1.createStatement();
            ResultSet r = S.executeQuery(sql);
            
            
            while (r.next())
            {
                String cod;
                cod = r.getString(1);
                JenisProdukComboBox.addItem(cod);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR"+ex.getMessage());
        }
        try{
            
            Connection cn1 = kdb.getKoneksi();
            String sql = "SELECT nama FROM tipepencarian GROUP BY nama";
            Statement S = cn1.createStatement();
            ResultSet r = S.executeQuery(sql);
            
            
            while (r.next())
            {
                String cod;
                cod = r.getString(1);
                TipePencarianComboBox.addItem(cod);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR"+ex.getMessage());
        }
        
        try{
            
            Connection cn1 = kdb.getKoneksi();
            String sql = "SELECT nama FROM tipesatuan GROUP BY nama";
            Statement S = cn1.createStatement();
            ResultSet r = S.executeQuery(sql);
            
            
            while (r.next())
            {
                String cod;
                cod = r.getString(1);
                SatuanComboBox.addItem(cod);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR"+ex.getMessage());
        }
    }
     
    
    public void listed(String tipePencarian, String cariSesuatu)
    {
        
        
        //model = (DefaultTableModel)viewTable.getModel();
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Id");
        model.addColumn("JenisProduk");
        model.addColumn("NamaProduk");
        model.addColumn("Jenis");
        model.addColumn("Satuan");
        model.addColumn("Persediaan");
        model.addColumn("Harga");
        
        try{   
        Connection cn1 = kdb.getKoneksi();
        Statement S;
        ResultSet r = null;
            
        String sql = dashboard.sqlrubah.getText();
        if(!"".equals(TipePencarianComboBox.getSelectedItem()) && !"".equalsIgnoreCase(PencarianTextField.getText())){
            try{
            
            
            PreparedStatement pst;
            String sqlPil = dashboard.sqlrubah.getText();
            
            
            String condition0 =  "SELECT * FROM stock";
            String untuk0 = " WHERE "+tipePencarian+" Like ?";
            String untuk1_9 = " AND "+tipePencarian+" Like ?";
            String sqlFinal = "";
                
                if(sqlPil.equalsIgnoreCase(condition0)){
                        sqlFinal = sqlPil + untuk0;
                        System.out.println(sqlFinal);
                        pst = kdb.getKoneksi().prepareStatement(sqlFinal);
                        System.out.println("lewt 1_1");
                        pst.setString(1, "%"+cariSesuatu+"%");
                        System.out.println(pst);
                        r = pst.executeQuery();
                } else {
                        sqlFinal = sqlPil + untuk1_9;
                        System.out.println(sqlFinal);
                        pst = kdb.getKoneksi().prepareStatement(sqlFinal);
                        System.out.println("lewt 2_1");
                        pst.setString(1, "%"+cariSesuatu+"%");
                        System.out.println(pst);
                        r = pst.executeQuery();
                }
                while (r.next()){
                        model.addRow(new Object[]{
                                   r.getString(1),
                                   r.getString(2),
                                   r.getString(3),
                                   r.getString(4),
                                   r.getString(5),
                                   r.getString(6),
                                   r.getString(7),
                           });
                        }
                ViewTable.setModel(model);
            
            } catch (SQLException ex) {
              System.out.println("ERROR"+ex.getMessage());        
            }

            } else {
                S = cn1.createStatement();
                r = S.executeQuery(sql);
                while (r.next()){
                    model.addRow(new Object[]{
                            r.getString(1),
                            r.getString(2),
                            r.getString(3),
                            r.getString(4),
                            r.getString(5),
                            r.getString(6),
                            r.getString(7),
                    });

                }
                  ViewTable.setModel(model);
            }
        }catch (SQLException ex) {
            System.out.println("ERROR"+ex.getMessage());
        }
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        JudulLabel = new javax.swing.JLabel();
        JudulLabel1 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        DataScrollPane = new javax.swing.JScrollPane();
        ViewTable = new javax.swing.JTable();
        MenuPanel1 = new javax.swing.JPanel();
        MenuSemuaLabel = new javax.swing.JLabel();
        MenuSweaterJumperLabel = new javax.swing.JLabel();
        MenuKaosLabel = new javax.swing.JLabel();
        MenuTopiLabel = new javax.swing.JLabel();
        MenuRokLabel = new javax.swing.JLabel();
        MenuSandalLabel = new javax.swing.JLabel();
        MenuKemejaLabel = new javax.swing.JLabel();
        MenuSepatuLabel = new javax.swing.JLabel();
        MenuKacamataLabel = new javax.swing.JLabel();
        MenuRomperLabel = new javax.swing.JLabel();
        SearchPanel = new javax.swing.JPanel();
        TipePencarianiLabel = new javax.swing.JLabel();
        PencarianLabel = new javax.swing.JLabel();
        TipePencarianComboBox = new javax.swing.JComboBox<>();
        MenuSemuaLabel1 = new javax.swing.JLabel();
        JenisProdukLabel = new javax.swing.JLabel();
        JenisProdukComboBox = new javax.swing.JComboBox<>();
        NamaProdukLabel = new javax.swing.JLabel();
        JenisLabel = new javax.swing.JLabel();
        SatuanLabel = new javax.swing.JLabel();
        SatuanComboBox = new javax.swing.JComboBox<>();
        PersediaanLabel = new javax.swing.JLabel();
        HargaLabel = new javax.swing.JLabel();
        SimpanLabel = new javax.swing.JLabel();
        SuntingLabel = new javax.swing.JLabel();
        HapusLabel = new javax.swing.JLabel();
        KeluarLabel = new javax.swing.JLabel();
        no_id = new javax.swing.JLabel();
        BackGroundIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.pink);
        setPreferredSize(new java.awt.Dimension(1366, 786));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackGround.setBackground(new java.awt.Color(117, 84, 155));
        BackGround.setForeground(new java.awt.Color(255, 255, 255));
        BackGround.setPreferredSize(new java.awt.Dimension(1366, 786));
        BackGround.setLayout(null);

        JudulLabel.setBackground(new java.awt.Color(255, 255, 255));
        JudulLabel.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        JudulLabel.setForeground(new java.awt.Color(204, 204, 204));
        JudulLabel.setText("PANEL");
        BackGround.add(JudulLabel);
        JudulLabel.setBounds(30, 30, 90, 50);

        JudulLabel1.setBackground(new java.awt.Color(255, 255, 255));
        JudulLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        JudulLabel1.setForeground(new java.awt.Color(255, 255, 255));
        JudulLabel1.setText("PERSEDIAAN");
        BackGround.add(JudulLabel1);
        JudulLabel1.setBounds(120, 30, 170, 50);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-new-product-70.png"))); // NOI18N
        BackGround.add(Logo);
        Logo.setBounds(290, 10, 70, 70);

        ViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Jenis Produk", "Nama Produk", "Jenis", "Satuan", "Persediaan", "Harga"
            }
        ));
        ViewTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewTableMouseClicked(evt);
            }
        });
        DataScrollPane.setViewportView(ViewTable);

        BackGround.add(DataScrollPane);
        DataScrollPane.setBounds(20, 260, 1310, 280);

        MenuPanel1.setBackground(new java.awt.Color(148, 112, 189));
        MenuPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 37, 200), 2));
        MenuPanel1.setForeground(new java.awt.Color(204, 204, 204));
        MenuPanel1.setOpaque(false);
        MenuPanel1.setPreferredSize(new java.awt.Dimension(100, 50));

        MenuSemuaLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSemuaLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuSemuaLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuSemuaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSemuaLabel.setText("Semua Produk");
        MenuSemuaLabel.setToolTipText("");
        MenuSemuaLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuSemuaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuSemuaLabel.setOpaque(true);
        MenuSemuaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSemuaLabelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSemuaLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuSemuaLabelMouseReleased(evt);
            }
        });

        MenuSweaterJumperLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSweaterJumperLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuSweaterJumperLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuSweaterJumperLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSweaterJumperLabel.setText("Sweater Jumper");
        MenuSweaterJumperLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuSweaterJumperLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuSweaterJumperLabel.setOpaque(true);
        MenuSweaterJumperLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSweaterJumperLabelMousePressed(evt);
            }
        });

        MenuKaosLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKaosLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuKaosLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuKaosLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKaosLabel.setText("Kaos");
        MenuKaosLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuKaosLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuKaosLabel.setOpaque(true);
        MenuKaosLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKaosLabelMousePressed(evt);
            }
        });

        MenuTopiLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuTopiLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuTopiLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuTopiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuTopiLabel.setText("Topi");
        MenuTopiLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuTopiLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuTopiLabel.setOpaque(true);
        MenuTopiLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuTopiLabelMousePressed(evt);
            }
        });

        MenuRokLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuRokLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuRokLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuRokLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuRokLabel.setText("Rok");
        MenuRokLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuRokLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuRokLabel.setOpaque(true);
        MenuRokLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuRokLabelMousePressed(evt);
            }
        });

        MenuSandalLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSandalLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuSandalLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuSandalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSandalLabel.setText("Sandal");
        MenuSandalLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuSandalLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuSandalLabel.setOpaque(true);
        MenuSandalLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSandalLabelMousePressed(evt);
            }
        });

        MenuKemejaLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKemejaLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuKemejaLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuKemejaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKemejaLabel.setText("Kemeja");
        MenuKemejaLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuKemejaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuKemejaLabel.setOpaque(true);
        MenuKemejaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKemejaLabelMousePressed(evt);
            }
        });

        MenuSepatuLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSepatuLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuSepatuLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuSepatuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSepatuLabel.setText("Sepatu");
        MenuSepatuLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuSepatuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuSepatuLabel.setOpaque(true);
        MenuSepatuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSepatuLabelMousePressed(evt);
            }
        });

        MenuKacamataLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuKacamataLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuKacamataLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuKacamataLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuKacamataLabel.setText("Kacamata");
        MenuKacamataLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuKacamataLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuKacamataLabel.setOpaque(true);
        MenuKacamataLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuKacamataLabelMousePressed(evt);
            }
        });

        MenuRomperLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuRomperLabel.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        MenuRomperLabel.setForeground(new java.awt.Color(255, 255, 255));
        MenuRomperLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuRomperLabel.setText("Romper");
        MenuRomperLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        MenuRomperLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuRomperLabel.setOpaque(true);
        MenuRomperLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuRomperLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanel1Layout = new javax.swing.GroupLayout(MenuPanel1);
        MenuPanel1.setLayout(MenuPanel1Layout);
        MenuPanel1Layout.setHorizontalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MenuSemuaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuKaosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuTopiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuSweaterJumperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuKacamataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuRomperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSepatuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuKemejaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSandalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuRokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        MenuPanel1Layout.setVerticalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(MenuSemuaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MenuKaosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuPanel1Layout.createSequentialGroup()
                        .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MenuSweaterJumperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuRomperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MenuTopiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuKacamataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MenuPanel1Layout.createSequentialGroup()
                        .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MenuKemejaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuRokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MenuSepatuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuSandalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        BackGround.add(MenuPanel1);
        MenuPanel1.setBounds(30, 80, 1080, 170);

        SearchPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        SearchPanel.setOpaque(false);
        SearchPanel.setLayout(null);

        TipePencarianiLabel.setBackground(new java.awt.Color(255, 255, 255));
        TipePencarianiLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        TipePencarianiLabel.setForeground(new java.awt.Color(255, 255, 255));
        TipePencarianiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TipePencarianiLabel.setText("Tipe Pencarian");
        TipePencarianiLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        SearchPanel.add(TipePencarianiLabel);
        TipePencarianiLabel.setBounds(0, 0, 230, 30);

        PencarianTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PencarianTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(117, 84, 155), 2));
        PencarianTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PencarianTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PencarianTextFieldActionPerformed(evt);
            }
        });
        PencarianTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PencarianTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PencarianTextFieldKeyReleased(evt);
            }
        });
        SearchPanel.add(PencarianTextField);
        PencarianTextField.setBounds(10, 110, 210, 30);

        PencarianLabel.setBackground(new java.awt.Color(255, 255, 255));
        PencarianLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        PencarianLabel.setForeground(new java.awt.Color(255, 255, 255));
        PencarianLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PencarianLabel.setText("Pencarian");
        PencarianLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        SearchPanel.add(PencarianLabel);
        PencarianLabel.setBounds(0, 80, 230, 30);

        TipePencarianComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TipePencarianComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIHAN --" }));
        TipePencarianComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipePencarianComboBoxActionPerformed(evt);
            }
        });
        SearchPanel.add(TipePencarianComboBox);
        TipePencarianComboBox.setBounds(10, 40, 210, 30);

        MenuSemuaLabel1.setBackground(new java.awt.Color(51, 0, 97));
        MenuSemuaLabel1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        MenuSemuaLabel1.setForeground(new java.awt.Color(255, 255, 255));
        MenuSemuaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuSemuaLabel1.setText("?");
        MenuSemuaLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        MenuSemuaLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 37, 200)));
        MenuSemuaLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuSemuaLabel1.setOpaque(true);
        MenuSemuaLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSemuaLabel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuSemuaLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuSemuaLabel1MouseReleased(evt);
            }
        });
        SearchPanel.add(MenuSemuaLabel1);
        MenuSemuaLabel1.setBounds(190, 149, 40, 20);

        BackGround.add(SearchPanel);
        SearchPanel.setBounds(1110, 80, 230, 170);

        JenisProdukLabel.setBackground(new java.awt.Color(255, 255, 255));
        JenisProdukLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        JenisProdukLabel.setForeground(new java.awt.Color(255, 255, 255));
        JenisProdukLabel.setText("Jenis Produk");
        JenisProdukLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackGround.add(JenisProdukLabel);
        JenisProdukLabel.setBounds(30, 550, 230, 30);

        JenisProdukComboBox.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        JenisProdukComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIHAN --" }));
        JenisProdukComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisProdukComboBoxActionPerformed(evt);
            }
        });
        BackGround.add(JenisProdukComboBox);
        JenisProdukComboBox.setBounds(30, 580, 200, 30);

        NamaProdukLabel.setBackground(new java.awt.Color(255, 255, 255));
        NamaProdukLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        NamaProdukLabel.setForeground(new java.awt.Color(255, 255, 255));
        NamaProdukLabel.setText("Nama Produk :");
        NamaProdukLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackGround.add(NamaProdukLabel);
        NamaProdukLabel.setBounds(300, 550, 230, 30);

        NamaProdukTextField.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        NamaProdukTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(117, 84, 155), 2));
        NamaProdukTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        NamaProdukTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukTextFieldActionPerformed(evt);
            }
        });
        BackGround.add(NamaProdukTextField);
        NamaProdukTextField.setBounds(300, 580, 200, 30);

        JenisLabel.setBackground(new java.awt.Color(255, 255, 255));
        JenisLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        JenisLabel.setForeground(new java.awt.Color(255, 255, 255));
        JenisLabel.setText("Jenis :");
        JenisLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackGround.add(JenisLabel);
        JenisLabel.setBounds(570, 550, 230, 30);

        JenisTextField.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        JenisTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(117, 84, 155), 2));
        JenisTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JenisTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisTextFieldActionPerformed(evt);
            }
        });
        BackGround.add(JenisTextField);
        JenisTextField.setBounds(570, 580, 210, 30);

        SatuanLabel.setBackground(new java.awt.Color(255, 255, 255));
        SatuanLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        SatuanLabel.setForeground(new java.awt.Color(255, 255, 255));
        SatuanLabel.setText("Satuan");
        SatuanLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackGround.add(SatuanLabel);
        SatuanLabel.setBounds(30, 640, 230, 30);

        SatuanComboBox.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        SatuanComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIHAN --" }));
        SatuanComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SatuanComboBoxActionPerformed(evt);
            }
        });
        BackGround.add(SatuanComboBox);
        SatuanComboBox.setBounds(30, 670, 200, 30);

        PersediaanLabel.setBackground(new java.awt.Color(255, 255, 255));
        PersediaanLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        PersediaanLabel.setForeground(new java.awt.Color(255, 255, 255));
        PersediaanLabel.setText("Persediaan :");
        PersediaanLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackGround.add(PersediaanLabel);
        PersediaanLabel.setBounds(300, 640, 230, 30);

        PersediaanTextField.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        PersediaanTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(117, 84, 155), 2));
        PersediaanTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PersediaanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersediaanTextFieldActionPerformed(evt);
            }
        });
        BackGround.add(PersediaanTextField);
        PersediaanTextField.setBounds(300, 670, 200, 30);

        HargaLabel.setBackground(new java.awt.Color(255, 255, 255));
        HargaLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        HargaLabel.setForeground(new java.awt.Color(255, 255, 255));
        HargaLabel.setText("Harga Per Satuan :");
        HargaLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BackGround.add(HargaLabel);
        HargaLabel.setBounds(570, 640, 240, 30);

        HargaTextField.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        HargaTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(117, 84, 155), 2));
        HargaTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        HargaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HargaTextFieldActionPerformed(evt);
            }
        });
        BackGround.add(HargaTextField);
        HargaTextField.setBounds(570, 670, 210, 30);

        SimpanLabel.setBackground(new java.awt.Color(51, 0, 97));
        SimpanLabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        SimpanLabel.setForeground(new java.awt.Color(255, 255, 255));
        SimpanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SimpanLabel.setText("SIMPAN");
        SimpanLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        SimpanLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SimpanLabel.setOpaque(true);
        SimpanLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SimpanLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SimpanLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SimpanLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SimpanLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SimpanLabelMouseReleased(evt);
            }
        });
        BackGround.add(SimpanLabel);
        SimpanLabel.setBounds(880, 550, 140, 60);

        SuntingLabel.setBackground(new java.awt.Color(51, 0, 97));
        SuntingLabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        SuntingLabel.setForeground(new java.awt.Color(255, 255, 255));
        SuntingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SuntingLabel.setText("SUNTING");
        SuntingLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        SuntingLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SuntingLabel.setOpaque(true);
        SuntingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuntingLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SuntingLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SuntingLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SuntingLabelMouseReleased(evt);
            }
        });
        BackGround.add(SuntingLabel);
        SuntingLabel.setBounds(1040, 550, 140, 60);

        HapusLabel.setBackground(new java.awt.Color(51, 0, 97));
        HapusLabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        HapusLabel.setForeground(new java.awt.Color(255, 255, 255));
        HapusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HapusLabel.setText("HAPUS");
        HapusLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        HapusLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HapusLabel.setOpaque(true);
        HapusLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HapusLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HapusLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HapusLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HapusLabelMouseReleased(evt);
            }
        });
        BackGround.add(HapusLabel);
        HapusLabel.setBounds(1200, 550, 140, 60);

        KeluarLabel.setBackground(new java.awt.Color(51, 0, 97));
        KeluarLabel.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        KeluarLabel.setForeground(new java.awt.Color(255, 255, 255));
        KeluarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KeluarLabel.setText("KELUAR");
        KeluarLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(242, 37, 200), 2, true));
        KeluarLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KeluarLabel.setOpaque(true);
        KeluarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KeluarLabelMouseExited(evt);
            }
        });
        BackGround.add(KeluarLabel);
        KeluarLabel.setBounds(1200, 630, 140, 60);
        BackGround.add(no_id);
        no_id.setBounds(0, 0, 0, 0);

        BackGroundIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_2680024.jpg"))); // NOI18N
        BackGroundIcon.setOpaque(true);
        BackGroundIcon.setPreferredSize(new java.awt.Dimension(1366, 786));
        BackGround.add(BackGroundIcon);
        BackGroundIcon.setBounds(0, 0, 1366, 770);

        getContentPane().add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void NamaProdukTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukTextFieldActionPerformed

    private void PersediaanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersediaanTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PersediaanTextFieldActionPerformed

    private void HargaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HargaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HargaTextFieldActionPerformed

    private void SimpanLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanLabelMouseClicked
        // TODO add your handling code here:
      
        
        
    }//GEN-LAST:event_SimpanLabelMouseClicked

    private void JenisProdukComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisProdukComboBoxActionPerformed
        // TODO add your handling code here:
        
        String nilaicbx = (String) JenisProdukComboBox.getSelectedItem();
        System.out.println(nilaicbx);
        
    }//GEN-LAST:event_JenisProdukComboBoxActionPerformed

    private void MenuSemuaLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(242,37,200));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51, 0, 97));
        MenuRomperLabel.setBackground(new Color(51,0,97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(TOP);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();
        
        
        pilihan = "0";
        dashBoard.pil(pilihan);
       
        String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
       
    }//GEN-LAST:event_MenuSemuaLabelMousePressed

    private void MenuSemuaLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabelMouseReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_MenuSemuaLabelMouseReleased

    private void MenuSweaterJumperLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSweaterJumperLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(242,37,200));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51, 0, 97));
        MenuRomperLabel.setBackground(new Color(51,0,97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(TOP);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        
        pilihan = "1";
        
        dashBoard.pil(pilihan);
        
        String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
        
        
       
    }//GEN-LAST:event_MenuSweaterJumperLabelMousePressed

    private void JenisTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisTextFieldActionPerformed

    private void PencarianTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PencarianTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_PencarianTextFieldActionPerformed

    private void PencarianTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PencarianTextFieldKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_PencarianTextFieldKeyPressed

    private void PencarianTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PencarianTextFieldKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            DefaultTableModel model = new DefaultTableModel();
        
            model.addColumn("Id");
            model.addColumn("JenisProduk");
            model.addColumn("NamaProduk");
            model.addColumn("Jenis");
            model.addColumn("Satuan");
            model.addColumn("Persediaan");
            model.addColumn("HARGA");

            try{   
               
                ResultSet r = null;

                PreparedStatement pst;
                String sqlPil = dashboard.sqlrubah.getText();
                String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
                String cariSesuatu = PencarianTextField.getText();
               

                String condition0 =  "SELECT * FROM stock";
                    String untuk0 = " WHERE "+"("+tipePencarian+")"+" IN "+"("+"?"+")";
                    String untuk1_9 = " AND "+"("+tipePencarian+")"+" IN "+"("+"?"+")";
                    String sqlFinal = "";

                        if(sqlPil.equalsIgnoreCase(condition0)){
                                sqlFinal = sqlPil + untuk0;
                                System.out.println(sqlFinal);
                                pst = kdb.getKoneksi().prepareStatement(sqlFinal);
                                System.out.println("lewt 1_1");
                                pst.setString(1, cariSesuatu);
                                System.out.println(pst);
                                r = pst.executeQuery();
                        } else {
                                sqlFinal = sqlPil + untuk1_9;
                                System.out.println(sqlFinal);
                                pst = kdb.getKoneksi().prepareStatement(sqlFinal);
                                System.out.println("lewt 2_1");
                                pst.setString(1, cariSesuatu);
                                System.out.println(pst);
                                r = pst.executeQuery();
                        }
                        while (r.next()){
                                model.addRow(new Object[]{
                                           r.getString(1),
                                           r.getString(2),
                                           r.getString(3),
                                           r.getString(4),
                                           r.getString(5),
                                           r.getString(6),
                                           r.getString(7),
                                   });
                                }
                        ViewTable.setModel(model);
            }catch (SQLException ex) {
             System.out.println("ERROR"+ex.getMessage());
            }
            
        }else {
            
            String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
            String cariSesuatu = PencarianTextField.getText();
            listed(tipePencarian, cariSesuatu);     
        } 
    }//GEN-LAST:event_PencarianTextFieldKeyReleased

    private void MenuKaosLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKaosLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(242,37,200));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51,0,97));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(TOP);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();
        
        pilihan = "2";
        dashBoard.pil(pilihan);
        String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
       
        
    }//GEN-LAST:event_MenuKaosLabelMousePressed

    private void MenuTopiLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTopiLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(242,37,200));
        MenuRokLabel.setBackground(new Color(51,0,97));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(TOP);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();
        
        pilihan = "3";
        dashBoard.pil(pilihan);
         String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
     
        
    }//GEN-LAST:event_MenuTopiLabelMousePressed

    private void SuntingLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuntingLabelMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_SuntingLabelMouseClicked

    private void ViewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewTableMouseClicked
        // TODO add your handling code here:
        try {
            int i= ViewTable.getSelectedRow();
            
            TableModel model = ViewTable.getModel();
            no_id.setText(model.getValueAt(i, 0).toString());
            JenisProdukComboBox.setSelectedItem(model.getValueAt(i, 1).toString());
            NamaProdukTextField.setText(model.getValueAt(i, 2).toString());
            JenisTextField.setText(model.getValueAt(i, 3).toString());
            SatuanComboBox.setSelectedItem(model.getValueAt(i, 4).toString());
            PersediaanTextField.setText(model.getValueAt(i, 5).toString());
            HargaTextField.setText(model.getValueAt(i, 6).toString());
            System.out.println("E"+no_id.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"waw "+ ex.getMessage());
            
        }
    }//GEN-LAST:event_ViewTableMouseClicked

    private void HapusLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusLabelMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_HapusLabelMouseClicked

    private void MenuSemuaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabelMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_MenuSemuaLabelMouseClicked

    private void TipePencarianComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipePencarianComboBoxActionPerformed
        // TODO add your handling code here:
        
        String nilaicbx = (String) TipePencarianComboBox.getSelectedItem();
        System.out.println(nilaicbx);
    }//GEN-LAST:event_TipePencarianComboBoxActionPerformed

    private void MenuRokLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRokLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(242,37,200));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(TOP);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();
        
        pilihan = "4";
        dashBoard.pil(pilihan);
         String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
       
    }//GEN-LAST:event_MenuRokLabelMousePressed

    private void MenuRomperLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuRomperLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51, 0, 97));
        MenuRomperLabel.setBackground(new Color(242,37,200));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(TOP);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        
        pilihan = "5";
        dashBoard.pil(pilihan);
         String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
     
    }//GEN-LAST:event_MenuRomperLabelMousePressed

    private void MenuKacamataLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKacamataLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51, 0, 97));
        MenuRokLabel.setBackground(new Color(51,0,97));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(242,37,200));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51, 0, 97));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(TOP);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();
        
        pilihan = "6";
        dashBoard.pil(pilihan);
         String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
      
    }//GEN-LAST:event_MenuKacamataLabelMousePressed

    private void MenuKemejaLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKemejaLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51, 0, 97));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(242,37,200));
        MenuSandalLabel.setBackground(new Color(51,0,97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(TOP);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();
        
        pilihan = "8";
        dashBoard.pil(pilihan);
         String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
        
    }//GEN-LAST:event_MenuKemejaLabelMousePressed

    private void MenuSandalLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSandalLabelMousePressed
        // TODO add your handling code here:
         MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51, 0, 97));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(51, 0, 97));
        MenuKemejaLabel.setBackground(new Color(51,0,97));
        MenuSandalLabel.setBackground(new Color(242,37,200));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(CENTER);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(TOP);
        repaint();
        
        pilihan = "9";
        dashBoard.pil(pilihan);
         String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);
      
      
    }//GEN-LAST:event_MenuSandalLabelMousePressed

    private void KeluarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarLabelMouseClicked
        // TODO add your handling code here:
        dashboard dashB = new dashboard();
        dashB.setVisible(true);
        int state = dashB.getExtendedState();
        state &= ~JFrame.ICONIFIED;
        dashB.setExtendedState(state);
        dashB.setAlwaysOnTop(true);
        dashB.toFront();
        dashB.requestFocus();
        dashB.setAlwaysOnTop(false);

        this.dispose();
        
    }//GEN-LAST:event_KeluarLabelMouseClicked

    private void MenuSepatuLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSepatuLabelMousePressed
        // TODO add your handling code here:
        MenuSemuaLabel.setBackground(new Color(51,0,97));
        MenuSweaterJumperLabel.setBackground(new Color(51,0,97));
        MenuKaosLabel.setBackground(new Color(51,0,97));
        MenuTopiLabel.setBackground(new Color(51,0,97));
        MenuRokLabel.setBackground(new Color(51, 0, 97));
        MenuRomperLabel.setBackground(new Color(51, 0, 97));
        MenuKacamataLabel.setBackground(new Color(51, 0, 97));
        MenuSepatuLabel.setBackground(new Color(242,37,200));
        MenuKemejaLabel.setBackground(new Color(51,0,97));
        MenuSandalLabel.setBackground(new Color(51, 0, 97));
        
        MenuSemuaLabel.setVerticalAlignment(CENTER);
        MenuSweaterJumperLabel.setVerticalAlignment(CENTER);
        MenuKaosLabel.setVerticalAlignment(CENTER);
        MenuTopiLabel.setVerticalAlignment(CENTER);
        MenuRokLabel.setVerticalAlignment(CENTER);
        MenuRomperLabel.setVerticalAlignment(CENTER);
        MenuKacamataLabel.setVerticalAlignment(CENTER);
        MenuSepatuLabel.setVerticalAlignment(TOP);
        MenuKemejaLabel.setVerticalAlignment(CENTER);
        MenuSandalLabel.setVerticalAlignment(CENTER);
        repaint();

        pilihan = "7";
        dashBoard.pil(pilihan);
        String tipePencarian = (String) TipePencarianComboBox.getSelectedItem();
        String cariSesuatu = PencarianTextField.getText();
        listed(tipePencarian, cariSesuatu);

    }//GEN-LAST:event_MenuSepatuLabelMousePressed

    private void MenuSemuaLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabel1MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, " Gunakan Fitur Pencarian Untuk Mencari Data Persediaan Sesuai Tipe Pencarian dan Sesuatu Yang Ingin Dicari\n\n"
                                          + " Pilih Tipe Pencarian Untuk Mencari Sesuatu Berdasarkan Tipe Pencarian, Contoh : Harga\n\n"
                                          + " Ketik Pada Kolom Pencarian Untuk Mencari Sesuatu, Contoh : 9000 \n\n"
                                          + " Dari Contoh Di Atas, Program Akan Mencari Data Dengan Harga Yang Mengandung Angka 9000 \n\n"
                                          + " Tekan Enter Pada Kolom Pencarian Untuk Mencari Data Yang Lebih Spesifik \n"
                                          + " Contoh : Anda Ingin Mencari Data Dengan Harga 9000 Tetapi Yang Keluar Adalah Semua Data Yang Mengandung Angka 9000 Seperti 90000 atau 900000 dst\n"
                                          + "          Maka Dari Itu Tekan Enter Pada Kolom Pencarian Jika Ingin Menemukan Harga 9000 Dengan Spesifik","Informasi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_MenuSemuaLabel1MouseClicked

    private void MenuSemuaLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuSemuaLabel1MousePressed

    private void MenuSemuaLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabel1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuSemuaLabel1MouseReleased

    private void SimpanLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanLabelMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SimpanLabelMouseEntered

    private void SimpanLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanLabelMouseExited
        // TODO add your handling code here:
        SimpanLabel.setBackground(new Color(51,0,97));
        repaint();
        
        SimpanLabel.setVerticalAlignment(CENTER);
        repaint();
        
    }//GEN-LAST:event_SimpanLabelMouseExited

    private void SimpanLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanLabelMouseReleased
        // TODO add your handling code here:
        SimpanLabel.setBackground(new Color(51,0,97));
        repaint();
        
        SimpanLabel.setVerticalAlignment(CENTER);
        repaint();
        
    }//GEN-LAST:event_SimpanLabelMouseReleased

    private void SimpanLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimpanLabelMousePressed
        // TODO add your handling code here:
         SimpanLabel.setBackground(new Color(242,37,200));
        repaint();
        
        SimpanLabel.setVerticalAlignment(TOP);
        repaint();
        
        
        
         if(operanAll.getJabatan().equalsIgnoreCase("Admin")){
                menyimpan();
                listed("","");
             
                }else {
                    JOptionPane.showMessageDialog(null, "Hanya admin yang boleh memakai fitur ini","Informasi", JOptionPane.INFORMATION_MESSAGE);
                    
                }
        
        JenisProdukComboBox.setSelectedItem("-- PILIHAN --");
        NamaProdukTextField.setText(null);
        JenisTextField.setText(null);
        SatuanComboBox.setSelectedItem("-- PILIHAN --");
        PersediaanTextField.setText(null);
        HargaTextField.setText(null);
        
    }//GEN-LAST:event_SimpanLabelMousePressed

    private void SuntingLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuntingLabelMousePressed
        // TODO add your handling code here:
        
        SuntingLabel.setBackground(new Color(242,37,200));
        repaint();
        
        SuntingLabel.setVerticalAlignment(TOP);
        repaint();
        
        if(operanAll.getJabatan().equalsIgnoreCase("Admin")){
               sunting();;
             
                }else {
                    JOptionPane.showMessageDialog(null, "Hanya admin yang boleh memakai fitur ini","Informasi", JOptionPane.INFORMATION_MESSAGE);
                    
                }
        
        
        
    }//GEN-LAST:event_SuntingLabelMousePressed

    private void SuntingLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuntingLabelMouseExited
        // TODO add your handling code here:
        SuntingLabel.setBackground(new Color(51,0,97));
        repaint();
        
        SuntingLabel.setVerticalAlignment(CENTER);
        repaint();
    }//GEN-LAST:event_SuntingLabelMouseExited

    private void HapusLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusLabelMouseExited
        // TODO add your handling code here:
        HapusLabel.setBackground(new Color(51,0,97));
        repaint();
        
        HapusLabel.setVerticalAlignment(CENTER);
        repaint();
    }//GEN-LAST:event_HapusLabelMouseExited

    private void KeluarLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarLabelMouseExited
        // TODO add your handling code here:
        KeluarLabel.setBackground(new Color(51,0,97));
        repaint();
        
        KeluarLabel.setVerticalAlignment(CENTER);
        repaint();
    }//GEN-LAST:event_KeluarLabelMouseExited

    private void SuntingLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuntingLabelMouseReleased
        // TODO add your handling code here:
        SuntingLabel.setBackground(new Color(51,0,97));
        repaint();
        
        SuntingLabel.setVerticalAlignment(CENTER);
        repaint();
    }//GEN-LAST:event_SuntingLabelMouseReleased

    private void HapusLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusLabelMousePressed
        // TODO add your handling code here:
        HapusLabel.setBackground(new Color(242,37,200));
        repaint();
        
        HapusLabel.setVerticalAlignment(TOP);
        repaint();
        
        if(operanAll.getJabatan().equalsIgnoreCase("Admin")){
               hapus();
             
                }else {
                    JOptionPane.showMessageDialog(null, "Hanya admin yang boleh memakai fitur ini","Informasi", JOptionPane.INFORMATION_MESSAGE);
                    
                }
        
    }//GEN-LAST:event_HapusLabelMousePressed

    private void HapusLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusLabelMouseReleased
        // TODO add your handling code here:
        HapusLabel.setBackground(new Color(51,0,97));
        repaint();
        
        HapusLabel.setVerticalAlignment(CENTER);
        repaint();
    }//GEN-LAST:event_HapusLabelMouseReleased

    private void SatuanComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SatuanComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SatuanComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(PanelPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPersediaan().setVisible(true);
                
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JLabel BackGroundIcon;
    private javax.swing.JScrollPane DataScrollPane;
    private javax.swing.JLabel HapusLabel;
    private javax.swing.JLabel HargaLabel;
    public static final javax.swing.JTextField HargaTextField = new javax.swing.JTextField();
    private javax.swing.JLabel JenisLabel;
    private javax.swing.JComboBox<String> JenisProdukComboBox;
    private javax.swing.JLabel JenisProdukLabel;
    public static final javax.swing.JTextField JenisTextField = new javax.swing.JTextField();
    private javax.swing.JLabel JudulLabel;
    private javax.swing.JLabel JudulLabel1;
    private javax.swing.JLabel KeluarLabel;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MenuKacamataLabel;
    private javax.swing.JLabel MenuKaosLabel;
    private javax.swing.JLabel MenuKemejaLabel;
    private javax.swing.JPanel MenuPanel1;
    private javax.swing.JLabel MenuRokLabel;
    private javax.swing.JLabel MenuRomperLabel;
    private javax.swing.JLabel MenuSandalLabel;
    private javax.swing.JLabel MenuSemuaLabel;
    private javax.swing.JLabel MenuSemuaLabel1;
    private javax.swing.JLabel MenuSepatuLabel;
    private javax.swing.JLabel MenuSweaterJumperLabel;
    private javax.swing.JLabel MenuTopiLabel;
    private javax.swing.JLabel NamaProdukLabel;
    public static final javax.swing.JTextField NamaProdukTextField = new javax.swing.JTextField();
    private javax.swing.JLabel PencarianLabel;
    public static final javax.swing.JTextField PencarianTextField = new javax.swing.JTextField();
    private javax.swing.JLabel PersediaanLabel;
    public static final javax.swing.JTextField PersediaanTextField = new javax.swing.JTextField();
    private javax.swing.JComboBox<String> SatuanComboBox;
    private javax.swing.JLabel SatuanLabel;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JLabel SimpanLabel;
    private javax.swing.JLabel SuntingLabel;
    private javax.swing.JComboBox<String> TipePencarianComboBox;
    private javax.swing.JLabel TipePencarianiLabel;
    private javax.swing.JTable ViewTable;
    private javax.swing.JLabel no_id;
    // End of variables declaration//GEN-END:variables
}
