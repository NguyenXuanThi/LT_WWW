package iuh.fit.se.bai2.daos.impl;

import iuh.fit.se.bai2.daos.ProductDAO;
import iuh.fit.se.bai2.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDAOImpl implements ProductDAO {
    private final DataSource datasource;

    public ProductDAOImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public Product getById(String id) {
        String sql = "SELECT id, model, description, price, imgURL FROM product WHERE id=?";
        Product p = null;
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ){
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    String model = rs.getString("model");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    String imgURL = rs.getString("imgURL");
                    p = new Product(id, model, description, price, imgURL);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT id, model, description, price, imgURL FROM product";
        List<Product> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                String id = rs.getString("id");
                String model = rs.getString("model");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String imgURL = rs.getString("imgURL");
                list.add(new Product(id, model, description, price, imgURL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(Product p) {
        String sql = "INSERT INTO product (id, model, description, price, imgURL) VALUES (?,?,?,?,?)";
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ) {
            ps.setString(1, p.getId());
            ps.setString(2, p.getModel());
            ps.setString(3, p.getDescription());
            ps.setDouble(4, p.getPrice());
            ps.setString(5, p.getImgURL());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM product WHERE id=?";
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
