package info.solidsoft.blog.boot.events.repository;

import info.solidsoft.blog.boot.events.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
