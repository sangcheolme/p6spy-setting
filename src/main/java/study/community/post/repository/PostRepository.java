package study.community.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import study.community.post.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.title like :search")
    List<Post> search(String search);
}
