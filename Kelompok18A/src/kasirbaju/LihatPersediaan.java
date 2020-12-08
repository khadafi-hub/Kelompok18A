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
import static kasirbaju.PanelPersediaan.HargaTextField;
import static kasirbaju.PanelPersediaan.JenisTextField;
import static kasirbaju.PanelPersediaan.NamaProdukTextField;
import static kasirbaju.PanelPersediaan.PersediaanTextField;

/**
 *
 * @author MDafi
 */
public class LihatPersediaan extends javax.swing.JFrame {

    /**
     * Creates new form Pos
     */
    
    private static PanelKasir pk;
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
    
    public LihatPersediaan() {
       
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
            String sql = "SELECT * FROM stock " ;
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
    
  

    public void code(){
        
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
        no_id = new javax.swing.JLabel();
        PanelPencarian = new javax.swing.JPanel();
        TipePencarianiLabel = new javax.swing.JLabel();
        TipePencarianComboBox = new javax.swing.JComboBox<>();
        PencarianLabel = new javax.swing.JLabel();
        MenuSemuaLabel1 = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
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
        BackGroundIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 51, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.pink);
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setSize(new java.awt.Dimension(1000, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackGround.setBackground(new java.awt.Color(117, 84, 155));
        BackGround.setForeground(new java.awt.Color(255, 255, 255));
        BackGround.setPreferredSize(new java.awt.Dimension(1000, 700));
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
        DataScrollPane.setBounds(30, 260, 940, 320);
        BackGround.add(no_id);
        no_id.setBounds(0, 0, 0, 0);

        PanelPencarian.setBackground(new java.awt.Color(148, 112, 189));
        PanelPencarian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 37, 200), 2));
        PanelPencarian.setForeground(new java.awt.Color(204, 204, 204));
        PanelPencarian.setOpaque(false);
        PanelPencarian.setPreferredSize(new java.awt.Dimension(100, 50));

        TipePencarianiLabel.setBackground(new java.awt.Color(255, 255, 255));
        TipePencarianiLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        TipePencarianiLabel.setForeground(new java.awt.Color(255, 255, 255));
        TipePencarianiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TipePencarianiLabel.setText("Tipe Pencarian");
        TipePencarianiLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        TipePencarianComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TipePencarianComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIHAN --" }));
        TipePencarianComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipePencarianComboBoxActionPerformed(evt);
            }
        });

        PencarianLabel.setBackground(new java.awt.Color(255, 255, 255));
        PencarianLabel.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        PencarianLabel.setForeground(new java.awt.Color(255, 255, 255));
        PencarianLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PencarianLabel.setText("Pencarian");
        PencarianLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        PencarianTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout PanelPencarianLayout = new javax.swing.GroupLayout(PanelPencarian);
        PanelPencarian.setLayout(PanelPencarianLayout);
        PanelPencarianLayout.setHorizontalGroup(
            PanelPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPencarianLayout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(MenuSemuaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(PanelPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPencarianLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(PanelPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TipePencarianiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PencarianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelPencarianLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(PanelPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TipePencarianComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PencarianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PanelPencarianLayout.setVerticalGroup(
            PanelPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPencarianLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(MenuSemuaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(PanelPencarianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPencarianLayout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(TipePencarianiLabel)
                    .addGap(10, 10, 10)
                    .addComponent(TipePencarianComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(PencarianLabel)
                    .addGap(0, 0, 0)
                    .addComponent(PencarianTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
        );

        BackGround.add(PanelPencarian);
        PanelPencarian.setBounds(750, 90, 220, 160);

        MenuPanel.setBackground(new java.awt.Color(148, 112, 189));
        MenuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 37, 200), 2));
        MenuPanel.setForeground(new java.awt.Color(204, 204, 204));
        MenuPanel.setOpaque(false);
        MenuPanel.setPreferredSize(new java.awt.Dimension(100, 50));

        MenuSemuaLabel.setBackground(new java.awt.Color(51, 0, 97));
        MenuSemuaLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuSweaterJumperLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuKaosLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuTopiLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuRokLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuSandalLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuKemejaLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuSepatuLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuKacamataLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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
        MenuRomperLabel.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
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

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MenuSemuaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuKaosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuTopiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuSweaterJumperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuKacamataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuRomperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSepatuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuKemejaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuSandalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuRokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(MenuSemuaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MenuKaosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MenuSweaterJumperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuRomperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MenuTopiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuKacamataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MenuKemejaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuRokLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MenuSepatuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MenuSandalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );

        BackGround.add(MenuPanel);
        MenuPanel.setBounds(30, 90, 720, 140);

        BackGroundIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rsz_2680024.jpg"))); // NOI18N
        BackGroundIcon.setMaximumSize(new java.awt.Dimension(1000, 700));
        BackGroundIcon.setMinimumSize(new java.awt.Dimension(1000, 700));
        BackGroundIcon.setOpaque(true);
        BackGroundIcon.setPreferredSize(new java.awt.Dimension(1000, 700));
        BackGroundIcon.setRequestFocusEnabled(false);
        BackGround.add(BackGroundIcon);
        BackGroundIcon.setBounds(0, 0, 1000, 700);

        getContentPane().add(BackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        BackGround.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void ViewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewTableMouseClicked

        try {
            int i= ViewTable.getSelectedRow();
            
            TableModel model = ViewTable.getModel();
            pk.IdTextField.setText(model.getValueAt(i, 0).toString());
            pk.NamaProdukTextField.setText(model.getValueAt(i, 2).toString());
            pk.JenisTextField.setText(model.getValueAt(i, 3).toString());
            pk.SatuanTextField.setText(model.getValueAt(i, 4).toString());
            pk.HargaTextField.setText(model.getValueAt(i, 6).toString());
            
            //pk.JenisProdukComboBox.setSelectedItem(model.getValueAt(i, 1).toString());
            //pk.PersediaanTextField.setText(model.getValueAt(i, 5).toString());
            
            System.out.println("E"+no_id.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"waw "+ ex.getMessage());
            
        }
        
    }//GEN-LAST:event_ViewTableMouseClicked

    private void MenuSemuaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSemuaLabelMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_MenuSemuaLabelMouseClicked

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

    private void TipePencarianComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipePencarianComboBoxActionPerformed
        // TODO add your handling code here:

        String nilaicbx = (String) TipePencarianComboBox.getSelectedItem();
        System.out.println(nilaicbx);
    }//GEN-LAST:event_TipePencarianComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(LihatPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LihatPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LihatPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LihatPersediaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new LihatPersediaan().setVisible(true);
                
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JLabel BackGroundIcon;
    private javax.swing.JScrollPane DataScrollPane;
    private javax.swing.JLabel JudulLabel;
    private javax.swing.JLabel JudulLabel1;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MenuKacamataLabel;
    private javax.swing.JLabel MenuKaosLabel;
    private javax.swing.JLabel MenuKemejaLabel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLabel MenuRokLabel;
    private javax.swing.JLabel MenuRomperLabel;
    private javax.swing.JLabel MenuSandalLabel;
    private javax.swing.JLabel MenuSemuaLabel;
    private javax.swing.JLabel MenuSemuaLabel1;
    private javax.swing.JLabel MenuSepatuLabel;
    private javax.swing.JLabel MenuSweaterJumperLabel;
    private javax.swing.JLabel MenuTopiLabel;
    private javax.swing.JPanel PanelPencarian;
    private javax.swing.JLabel PencarianLabel;
    public static final javax.swing.JTextField PencarianTextField = new javax.swing.JTextField();
    private javax.swing.JComboBox<String> TipePencarianComboBox;
    private javax.swing.JLabel TipePencarianiLabel;
    private javax.swing.JTable ViewTable;
    private javax.swing.JLabel no_id;
    // End of variables declaration//GEN-END:variables
}
