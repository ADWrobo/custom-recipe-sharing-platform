package io.aiven.spring.mysql.customrecipesharingplatform;

import org.springframework.data.repository.CrudRepository;

import io.aiven.spring.mysql.customrecipesharingplatform.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}