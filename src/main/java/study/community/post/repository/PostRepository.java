package study.community.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.community.post.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
