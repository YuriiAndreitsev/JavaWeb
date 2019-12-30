package controllers;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import dao.UserControllerDAO;
import model.User;

public class UserController implements UserControllerDAO {
    Connection conn;
    private final static String SELECT_USER_BY_EMAIL = "select * from users where email=?";
	private static final String SALT = "1234";
    public static ResultSet rs = null;

    public UserController(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User getUserByEmail(String email ){
        User user = null;
        PreparedStatement ps = null;

        try  {
            ps = conn.prepareStatement(SELECT_USER_BY_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        user = new User();
                        user.setId(rs.getInt("id"));
                        user.setEmail(rs.getString("email"));
                        user.setLocation(rs.getString("location"));
                        user.setPassword(rs.getString("password"));
                        user.setGender(rs.getString("gender"));
                        user.setComment(rs.getString("comment"));
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlEx) { } // ignore
                ps = null;
            }
        }
        return user;
    }

    @Override
    public boolean ifUserExists(String email, String password) {
        ResultSet setFromUsersTable = null;
        String query = "SELECT * from users where email=?";
        PreparedStatement ps = null;
        boolean result = false;
        try  {
            ps = conn.prepareStatement(query);
            setFromUsersTable = ps.executeQuery();
            while (setFromUsersTable.next()) {
                result = (setFromUsersTable.getString("password").equals(getHash(password)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlEx) { } // ignore

                ps = null;
            }
        }
        return result;
    }

    @Override
    public boolean checkEmail(String email) {
        boolean ifExist = false;
        try {
            final String FIND_EMAIL = "SELECT * from users where email=?";

            PreparedStatement ps = conn.prepareStatement(FIND_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            ifExist = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ifExist;
    }



    @Override
    public String getHash(String pass) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(StandardCharsets.UTF_8.encode(pass + SALT));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return (String.format("%032x", new BigInteger(md.digest())));
    }



    @Override
    public void addUser(User user) {
    	PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO users (email, password, location, gender, comment) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, user.getEmail());
            ps.setString(2, getHash(user.getPassword()));
            ps.setString(3, user.getLocation());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getComment());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException sqlEx) { } // ignore

                ps = null;
            }
        }
    }
}
