package lesson207.repositories;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import lesson207.models.Emploees;

public interface EmploeesRepositories extends CrudRepository<Emploees, String> {
    @Query("select count(*) from emploees where firstname=:firstname and lastname=:lastname")
    int countByFirstNameAndLastName(@Param("firstname") String firstname,
                                    @Param("lastname") String lastname);
    @Query("Select * from emploees limit 1")
    Emploees findFirstEmploee();

}

