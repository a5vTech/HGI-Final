package dk.hgigym.repository;

import dk.hgigym.model.Request;
import dk.hgigym.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findAll();
    List<Request> findAllByAssigneeEmail(String email);
    List<Request> findAllByAssigneeEmailIsNull();
    List<Request> findAllByRequesterEmail(String email);
    @Query(value = "SELECT * FROM request WHERE id = ?1", nativeQuery = true)
    Request findRequest(Long id);
    @Modifying
    @Query(value = "DELETE FROM request WHERE id = ?1", nativeQuery = true)
    @Transactional
    void deleteRequest(Long id);




}