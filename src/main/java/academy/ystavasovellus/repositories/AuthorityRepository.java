package academy.ystavasovellus.repositories;

import academy.ystavasovellus.entities.Authority;
import academy.ystavasovellus.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, String> {


   Authority findByUsername(String username);
}
