package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.Users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, Integer> { 
	Users findByName(String name);
    Users findDistinctByEmail(String email);
    Users findByNameAndEmail(String name, String email);
}