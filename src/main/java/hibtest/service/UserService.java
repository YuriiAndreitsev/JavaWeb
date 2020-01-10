package hibtest.service;

import hibtest.model.Users;
import hibtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users addUser(Users user){
        return userRepository.save(user);
    }

    public Users getUser(int id){
        return userRepository.getOne(id);
    }

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }
}
