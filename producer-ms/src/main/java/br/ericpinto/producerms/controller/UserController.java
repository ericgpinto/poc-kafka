package br.ericpinto.producerms.controller;

import br.ericpinto.producerms.model.UserDTO;
import br.ericpinto.producerms.service.UserService;
import br.ericpinto.producerms.service.producer.UserProducerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserProducerService userProducerService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO user){
        return userService.create(user);
    }

    @PutMapping("/{id}/update/location")
    public UserDTO updateUserLocation(@PathVariable String id, @RequestBody UserDTO user){
        userProducerService.send(user);
        return userService.updateUserLocation(id, user);
    }
}
