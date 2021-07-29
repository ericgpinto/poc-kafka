package br.ericpinto.producerms.repository;

import br.ericpinto.producerms.model.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {
}
