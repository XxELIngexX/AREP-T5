package edu.eci.arep.Lab05.controller;

import edu.eci.arep.Lab05.model.Property;
import edu.eci.arep.Lab05.model.User;
import edu.eci.arep.Lab05.service.PropertyService;
import edu.eci.arep.Lab05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Property> addProperty(@RequestBody Property property){
        return ResponseEntity.ok(userService.addProperty(property));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable UUID id, @RequestBody Property property){
        return ResponseEntity.ok(propertyService.updateProperty(property));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProperty(@PathVariable UUID id){
        propertyService.deleteProperty(id);
    }

}
