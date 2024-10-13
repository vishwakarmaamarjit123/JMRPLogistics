package com.ty.jmrp_logistics.DAO;

import com.ty.jmrp_logistics.entity.User;
import com.ty.jmrp_logistics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findById(int id){
        Optional<User> optional =userRepository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User deleteById(int id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return optional.get();
        }
        return null;
    }
}
