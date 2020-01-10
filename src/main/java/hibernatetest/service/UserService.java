package hibernatetest.service;

import hibernatetest.model.Users;
import hibernatetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users addUser(Users user){
        return userRepository.save(user);
    }

    public Optional<Users> getUser(int id){
        return userRepository.findById(id);
    }

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }
}
