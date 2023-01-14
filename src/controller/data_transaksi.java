package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class data_transaksi {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_peminjaman;
    public String id_pelanggan;
    public String nomor_polisi;
    public String jumlah_hari;
    public String harga;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO tbl_transaksi(id_peminjaman,id_pelanggan,nomor_polisi,jumlah_hari,harga)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_peminjaman);
        pst.setString(2,id_pelanggan);
        pst.setString(3,nomor_polisi);
        pst.setString(4,jumlah_hari);
        pst.setString(5,harga);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE tbl_transaksi set id_pelanggan=?, nomor_polisi=?, jumlah_hari=?, harga=? where id_peminjaman=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_pelanggan);
        pst.setString(2,nomor_polisi);
        pst.setString(3,jumlah_hari);
        pst.setString(4,harga);
        pst.setString(5,id_peminjaman);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from tbl_transaksi where id_peminjaman=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_peminjaman);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatetransaksiT()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_peminjaman,id_pelanggan,nomor_polisi,jumlah_hari,harga from tbl_transaksi";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
