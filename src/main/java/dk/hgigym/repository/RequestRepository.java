package dk.hgigym.repository;

import dk.hgigym.model.Request;
import dk.hgigym.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findAll();
    @Query(value = "SELECT * FROM request WHERE id = ?1", nativeQuery = true)
    Request findRequest(Long id);
    @Query(value = "DELETE * FROM request WHERE id = ?1", nativeQuery = true)
    Request deleteRequest(Long id);
}