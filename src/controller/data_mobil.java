package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class data_mobil {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nomor_polisi;
    public String merk;
    public String tipe;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO tbl_mobil(nomor_polisi,merk,tipe)VALUE(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nomor_polisi);
        pst.setString(2,merk);
        pst.setString(3,tipe);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE tbl_mobil set merk=?, tipe=? where nomor_polisi=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,merk);
        pst.setString(2,tipe);
        pst.setString(3,nomor_polisi);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from tbl_mobil where nomor_polisi=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nomor_polisi);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatemobilTbl()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select nomor_polisi,merk,tipe from tbl_mobil";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
