package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class data_pelanggan {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_pelanggan;
    public String nama;
    public String alamat;
    public String no_telp;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO tbl_pelanggan(id_pelanggan,nama,alamat,no_telp)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_pelanggan);
        pst.setString(2,nama);
        pst.setString(3,alamat);
        pst.setString(4,no_telp);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE tbl_pelanggan set nama=?, alamat=?, no_telp=? where id_pelanggan=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,alamat);
        pst.setString(3,no_telp);
        pst.setString(4,id_pelanggan);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from tbl_pelanggan where id_pelanggan=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_pelanggan);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatepelangganTbl()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_pelanggan,nama,alamat,no_telp from tbl_pelanggan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}
