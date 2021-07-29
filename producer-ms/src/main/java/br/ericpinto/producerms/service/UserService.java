package br.ericpinto.producerms.service;

import br.ericpinto.producerms.model.UserDTO;
import br.ericpinto.producerms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO create(UserDTO user){
        return userRepository.insert(user);
    }

    public UserDTO updateUserLocation(String id, UserDTO user){
        var obj = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("USer not found"));
        obj.setId(user.getId());
        obj.setCoordinates(user.getCoordinates());

        return userRepository.save(obj);
    }
}
