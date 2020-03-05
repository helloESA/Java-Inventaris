/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.view;

import autonumber.autoNumber_interface;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import dao.adminDao;
import dao.barangkeluarDao;
import dao.customerDao;
import dao.lokasidao;
import dao.stokdao;
import dao.masterbarangDao;
import entity.Admin;
import entity.Customer;
import entity.BarangKeluar;
import entity.BarangKeluarDetail;
import entity.BarangMasukDetail;
import entity.NumberField;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import stokgudang.client.dialog.JD_BarangInputK;
import stokgudang.client.dialog.JD_BarangInputM;
import stokgudang.client.dialog.JD_CariCutomer;


/**
 *
 * @author moher
 */

public class JIF_TransaksiKeluar extends javax.swing.JInternalFrame {

    private static final long serialVersionUID = 1L;
    
    private autoNumber_interface autoNumber_interface1 ;
    private customerDao customerDao;
    private masterbarangDao masterbarangdao;
    private Customer customer;
    private lokasidao l_dao;
    private adminDao AdminDAO;
    Admin admin;
    private stokdao stokkd;
    private DynamicTableModel tableModel;
    private barangkeluarDao barangKeluarDAO;
    private lokasidao lokasidao;
    
    public JIF_TransaksiKeluar(autoNumber_interface autonumber_interface, customerDao customerDao, 
            masterbarangDao masterbarangDao, Admin ad,lokasidao lokasidao, barangkeluarDao barangkeluarDAO,stokdao stokks) {
        this.autoNumber_interface1 = autonumber_interface;
        this.barangKeluarDAO = barangkeluarDAO;
        this.customerDao = customerDao;
        this.l_dao = lokasidao;
        this.admin = ad;
        this.masterbarangdao = masterbarangDao;
        this.stokkd=stokks;
        initComponents();
        txt_petugas.setText(ad.getNm_user());
    }
    

    public BarangKeluar getKeluar(){ 
        BarangKeluar bk=new BarangKeluar();
        bk.setKode_transaksi(txt_kode.getText());
        bk.setTgl(dc_Time.getDate());
        bk.setCustomer(customer);
        bk.setPetugas(admin);
        List data = new ArrayList();
        for(int i=0;i<tabelPembelian.getRowCount();i++){
            BarangKeluarDetail pd=(BarangKeluarDetail) tableModel.get(tabelPembelian.convertRowIndexToModel(i));
            data.add(pd);
        }
        bk.setDetailkeluar(data);
        return bk;
    }
    
   
    public void loadAwal(){
         tableModel = new DynamicTableModel(BarangKeluarDetail.class);
         tabelPembelian.setModel(tableModel);
    }
    
    public boolean validasiInput(){
        boolean valid=false;
        if(txt_kode .getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Masih Kosong !");
        }else if(dc_Time.getDate()==null){
            JOptionPane.showMessageDialog(null, "Tanggal Masih Kosong !");
        }else if(txt_cust.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Pemasok Masih Kosong !");
        }else if(tabelPembelian.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "Barang Detil Masih Kosong !");
        }else{
            valid=true;
        }
        return valid;
     }
    
    private void reset(){
     txt_kode.setText("");
     txt_cust.setText("");
     txt_kodecustomer.setText("");
     dc_Time.setDate(null);
     txt_cust.setEnabled(false);
     dc_Time.setEnabled(false);
     bt_New.setEnabled(true);
     bt_SaveT.setEnabled(false);
     bt_AddB.setEnabled(false);
     bt_DeleteB.setEnabled(false);
    
     bt_Reset.setEnabled(true);
     bt_UpdateB.setEnabled(false);
     tableModel.clear();
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tabScrol = new javax.swing.JScrollPane();
        tabelPembelian = new com.stripbandunk.jwidget.JDynamicTable();
        jLabel2 = new javax.swing.JLabel();
        txt_kode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_cust = new javax.swing.JTextField();
        bt_UpdateB = new javax.swing.JButton();
        bt_DeleteB = new javax.swing.JButton();
        bt_AddB = new javax.swing.JButton();
        dc_Time = new com.toedter.calendar.JDateChooser();
        btn_cariCust = new javax.swing.JButton();
        bt_New = new javax.swing.JButton();
        bt_SaveT = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        txt_kodecustomer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_petugas = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaksi Barang Keluar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Transaksi Sementara"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tabScrol.setViewportView(tabelPembelian);

        jPanel4.add(tabScrol, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Kode Transaksi");

        txt_kode.setEnabled(false);

        jLabel3.setText("Tanggal Masuk");

        jLabel9.setText("Customer");

        txt_cust.setEnabled(false);

        bt_UpdateB.setText("UBAH BARANG");
        bt_UpdateB.setEnabled(false);
        bt_UpdateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UpdateBActionPerformed(evt);
            }
        });

        bt_DeleteB.setText("HAPUS BARANG");
        bt_DeleteB.setEnabled(false);
        bt_DeleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DeleteBActionPerformed(evt);
            }
        });

        bt_AddB.setText("TAMBAH BARANG");
        bt_AddB.setEnabled(false);
        bt_AddB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AddBActionPerformed(evt);
            }
        });

        dc_Time.setEnabled(false);

        btn_cariCust.setText(". . .");
        btn_cariCust.setEnabled(false);
        btn_cariCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariCustActionPerformed(evt);
            }
        });

        bt_New.setText("NEW");
        bt_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_NewActionPerformed(evt);
            }
        });

        bt_SaveT.setText("SIMPAN STOK");
        bt_SaveT.setEnabled(false);
        bt_SaveT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SaveTActionPerformed(evt);
            }
        });

        bt_Reset.setText("RESET");
        bt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetActionPerformed(evt);
            }
        });

        txt_kodecustomer.setEnabled(false);

        jLabel4.setText("Petugas");

        txt_petugas.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bt_New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_SaveT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_kode, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dc_Time, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(bt_AddB)
                                .addGap(18, 18, 18)
                                .addComponent(bt_UpdateB)
                                .addGap(18, 18, 18)
                                .addComponent(bt_DeleteB)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_kodecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cust, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cariCust))
                            .addComponent(txt_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cariCust)
                    .addComponent(txt_kodecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_petugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(dc_Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_AddB)
                    .addComponent(bt_UpdateB)
                    .addComponent(bt_DeleteB))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(bt_New, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_SaveT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Reset)
                        .addGap(76, 76, 76))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_UpdateBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdateBActionPerformed
        int index = tabelPembelian.getSelectedRow();
        if(index!=-1){
            BarangKeluarDetail bkd = (BarangKeluarDetail) tableModel.get(tabelPembelian.convertRowIndexToModel(index));
            JD_BarangInputK bk = new JD_BarangInputK(masterbarangdao, l_dao,stokkd);
            bk.update(bkd);
            
                BarangKeluarDetail dk = new BarangKeluarDetail();
                dk.setKode_transaksi(txt_kode.getText());
                dk.setKode_barang(bk.getKodeBarang());
                dk.setNama_barang(bk.getNama());
                dk.setBatch(bk.getBatch());
                dk.setKategori_nf(bk.getNf());
                dk.setLok(bk.getLokasi());
                dk.setQty((int) bk.getJumlah());
                dk.setIsi(bk.getIsiBarang());
                dk.setSatuan(bk.getSatuanBarang());
                dk.setTotal_qty(bk.getTotalQty());
                dk.setKemasan(bk.getKemasan());
                tableModel.set(index, dk);
            
        } else{
            JOptionPane.showMessageDialog(rootPane, "Data Belum Dipilih");
        }
    }//GEN-LAST:event_bt_UpdateBActionPerformed

    private void bt_DeleteBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteBActionPerformed
        // TODO add your handling code here:
        int index=tabelPembelian.getSelectedRow();
        if(index!=-1){
                BarangKeluarDetail pd = (BarangKeluarDetail) tableModel.get(tabelPembelian.convertRowIndexToModel(index));
                tableModel.remove(index);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Pilih salah satu baris !");
        }
    }//GEN-LAST:event_bt_DeleteBActionPerformed

    private void bt_AddBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AddBActionPerformed
        JD_BarangInputK bk = new JD_BarangInputK(masterbarangdao, l_dao, stokkd);
        bk.load();
       
            BarangKeluarDetail bkt = new BarangKeluarDetail();
            bkt.setKode_transaksi(txt_kode.getText());
            bkt.setKode_barang(bk.getKodeBarang());
            bkt.setNama_barang(bk.getNama());
            bkt.setBatch(bk.getBatch());
            bkt.setKategori_nf(bk.getNf());
            bkt.setLok(bk.getLokasi());
            bkt.setQty((int) bk.getJumlah());
            bkt.setIsi((Double)bk.getIsiBarang());
            bkt.setSatuan(bk.getSatuanBarang());
            bkt.setTotal_qty((Double)bk.getTotalQty());
            bkt.setKemasan(bk.getKemasan());
            if(tabelPembelian.getRowCount() !=0){
                for(int i=0; i<tabelPembelian.getRowCount();i++){
                    BarangKeluarDetail bkd = (BarangKeluarDetail) tableModel.get(tabelPembelian.convertRowIndexToModel(i));
                }
            } tableModel.add(bkt);
        
    }//GEN-LAST:event_bt_AddBActionPerformed

    private void btn_cariCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariCustActionPerformed
        try {
            List<Customer> customer1 = customerDao.getcustomer();
            if(!customer1.isEmpty()){
                DynamicTableModel tableModel = new DynamicTableModel(customer1, Customer.class);
                JD_CariCutomer cariCustomer = new JD_CariCutomer();
                cariCustomer.setTitle("Pencarian Customer");
                cariCustomer.setTableModel(tableModel);
                cariCustomer.loadPencarian();
                String ambilData = cariCustomer.ambilData();
                if(ambilData!= null){
                    customer = customerDao.getcustomer(ambilData);
                    txt_cust.setText(customer.getnamacustomer());
                    txt_kodecustomer.setText(customer.getkode_customer());
                }
            } else{
                JOptionPane.showMessageDialog(rootPane, "Pelanggan Masih Kosong!!");
            }
        } catch (RemoteException e) {
            Logger.getLogger(JIF_TransaksiKeluar.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btn_cariCustActionPerformed

    private void bt_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_NewActionPerformed
        // TODO add your handling code here:
        try {
            NumberField field=new NumberField();
            field.setAwalan("OUT-");
            field.setNamaField("kode_transaksi");
            field.setNamaTabel("dbbarangkeluar");
            field.setPanjangField(10);
            txt_kode.setText(autoNumber_interface1.getAutoNumberInt(field));

            //            txt_petugas.setText(a.getUser_name());
        } catch (RemoteException ex) {
            Logger.getLogger(JIF_TransaksiKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }
        dc_Time.setDate(new Date());
        dc_Time.setEnabled(true);
        bt_AddB.setEnabled(true);
        bt_SaveT.setEnabled(true);
        bt_New.setEnabled(true);
        bt_Reset.setEnabled(true);
        bt_UpdateB.setEnabled(true);
        bt_DeleteB.setEnabled(true);
        btn_cariCust.setEnabled(true);
        txt_kode.setEnabled(false);
        bt_New.setEnabled(false);
        loadAwal();
    }//GEN-LAST:event_bt_NewActionPerformed

    private void bt_SaveTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SaveTActionPerformed
        if(validasiInput()){
            BarangKeluar bmk = getKeluar();
            if(bmk != null){
                try {
                    if(barangKeluarDAO.insert(bmk)){
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                        
                        bt_SaveT.setEnabled(false);
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Data Gagal Disimpan");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JIF_TransaksiKeluar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_SaveTActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
    }//GEN-LAST:event_bt_ResetActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_AddB;
    private javax.swing.JButton bt_DeleteB;
    private javax.swing.JButton bt_New;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_SaveT;
    private javax.swing.JButton bt_UpdateB;
    private javax.swing.JButton btn_cariCust;
    private com.toedter.calendar.JDateChooser dc_Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane tabScrol;
    private com.stripbandunk.jwidget.JDynamicTable tabelPembelian;
    private javax.swing.JTextField txt_cust;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_kodecustomer;
    private javax.swing.JTextField txt_petugas;
    // End of variables declaration//GEN-END:variables
}