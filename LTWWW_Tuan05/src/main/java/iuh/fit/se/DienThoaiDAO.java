package iuh.fit.se;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAO {

    public List<DienThoai> getAll() {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DienThoai dt = new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("MANCC"),
                        rs.getString("HINHANH")
                );
                list.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<DienThoai> getAllByNCC(String maNCC) {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI WHERE MANCC=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNCC);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DienThoai dt = new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("MANCC"),
                        rs.getString("HINHANH")
                );
                list.add(dt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(DienThoai dt) {
        String sql = "INSERT INTO DIENTHOAI VALUES (?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dt.getMaDT());
            ps.setString(2, dt.getTenDT());
            ps.setInt(3, dt.getNamSX());
            ps.setString(4, dt.getCauHinh());
            ps.setString(5, dt.getMaNCC());
            ps.setString(6, dt.getHinhAnh());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String maDT) {
        String sql = "DELETE FROM DIENTHOAI WHERE MADT=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maDT);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
