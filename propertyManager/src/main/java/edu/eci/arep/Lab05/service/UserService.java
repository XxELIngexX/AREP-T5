package edu.eci.arep.Lab05.service;

import edu.eci.arep.Lab05.model.*;
import edu.eci.arep.Lab05.repository.PropertyRepository;
import edu.eci.arep.Lab05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public PropertyRepository propertyRepository;




    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findUserById(UUID id){
        return userRepository.findById(id).get();
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public void deleteUserById(UUID id){
        userRepository.deleteById(id);
    }
    public List<Property> getPropertyById(UUID id){
        return userRepository.findById(id).get().getProperties();
    }

    public Property addProperty(Property property) {
        User usr = findUserById(property.getUser());
        usr.addProperty(property);
        userRepository.save(usr);
        return property;
    }
}
