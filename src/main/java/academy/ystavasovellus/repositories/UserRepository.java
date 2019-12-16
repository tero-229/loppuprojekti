package academy.ystavasovellus.repositories;
import academy.ystavasovellus.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByEmail(String email);
    Users findByConfirmationToken(String confirmationToken);
}
