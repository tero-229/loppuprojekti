package academy.ystavasovellus.repositories;
import academy.ystavasovellus.entities.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;


@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

    Users findByEmail(String email);
    Users findByConfirmationToken(String confirmationToken);
    Users findByUsername(String username);

   /*@Query("UPDATE Users u SET u.lastLogin=:lastLogin WHERE u.username = ?#{ principal?.username }")
    @Modifying
    @Transactional
    public void updateLastLogin(@Param("lastLogin") Date lastLogin);*/
}
