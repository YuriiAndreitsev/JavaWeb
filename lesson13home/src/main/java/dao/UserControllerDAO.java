package dao;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Connection;
import model.User;
@Component
public interface UserControllerDAO {



    public User getUserByEmail(String email);
    public boolean ifUserExists(String email, String password);
    public boolean checkEmail(String email);
    public String getHash(String pass);
    public void addUser(User user);
}
