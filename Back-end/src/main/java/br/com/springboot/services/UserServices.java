package br.com.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
