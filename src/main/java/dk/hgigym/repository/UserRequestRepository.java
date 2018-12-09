package dk.hgigym.repository;

import dk.hgigym.model.UserRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRequestRepository extends CrudRepository<UserRequest, Long> {
    List<UserRequest> findAllByIsRequester(Boolean requester);
    @Query(nativeQuery = true, value = "SELECT * FROM user_request WHERE id = ?1")
    UserRequest findUserRequest(Long id);
}
