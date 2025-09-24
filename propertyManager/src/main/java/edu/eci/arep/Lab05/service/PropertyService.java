package edu.eci.arep.Lab05.service;

import edu.eci.arep.Lab05.model.Property;
import edu.eci.arep.Lab05.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private UserService userService;

    public Property addProperty(Property property){
        return propertyRepository.save(property);
    }
    public Property updateProperty(Property property){
        return propertyRepository.save(property);
    }
    public void deleteProperty(UUID id){
        propertyRepository.deleteById(id);
    }
    public Property getProperty(UUID id){
        return propertyRepository.findById(id).get();
    }
}
