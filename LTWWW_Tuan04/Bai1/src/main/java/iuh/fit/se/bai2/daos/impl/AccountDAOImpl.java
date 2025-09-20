package iuh.fit.se.bai2.daos.impl;

import iuh.fit.se.bai2.entities.Account;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl {
    private final DataSource dataSource;

    public AccountDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Lấy tất cả account
    public List<Account> findAll() {
        String sql = "SELECT id, first_name, last_name, email, password, birth_date, gender FROM account";
        List<Account> list = new ArrayList<>();

        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date birthDate = rs.getDate("birth_date");
                Account.Gender gender = Account.Gender.valueOf(rs.getString("gender"));

                Account acc = new Account(id, firstName, lastName, email, password,
                        (birthDate != null ? LocalDate.parse(birthDate.toString()) : null), gender);
                list.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Thêm account mới
    public void addAccount(Account acc) {
        String sql = "INSERT INTO account (first_name, last_name, email, password, birth_date, gender) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, acc.getFirstName());
            ps.setString(2, acc.getLastName());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPassword());

            if (acc.getBirthDate() != null) {
                ps.setDate(5, Date.valueOf(acc.getBirthDate())); // yyyy-MM-dd
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.setString(6, String.valueOf(acc.getGender()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
