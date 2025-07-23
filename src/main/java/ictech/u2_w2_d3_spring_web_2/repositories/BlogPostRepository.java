package ictech.u2_w2_d3_spring_web_2.repositories;

import ictech.u2_w2_d3_spring_web_2.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
}
