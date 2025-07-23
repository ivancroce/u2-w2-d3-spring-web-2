package ictech.u2_w2_d3_spring_web_2.repositories;

import ictech.u2_w2_d3_spring_web_2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findByEmail(String email);
}
