package study.community.post.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import study.community.post.dto.PostResponseDto;
import study.community.post.dto.PostSaveRequestDto;
import study.community.post.dto.PostUpdateDto;
import study.community.post.model.Post;
import study.community.post.repository.PostRepository;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(PostSaveRequestDto postSaveRequestDto) {
        Post post = postSaveRequestDto.toEntity();
        postRepository.save(post);
    }

    public PostResponseDto findById(Long id) {
        Post findPost = postRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(id + "에 해당하는 글이 존재하지 않습니다."));

        return new PostResponseDto(findPost);
    }

    @Transactional
    public void update(Long id, PostUpdateDto postUpdateDto) {
        Post findPost = postRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException(id + "에 해당하는 글이 존재하지 않습니다."));

        findPost.update(postUpdateDto.getTitle(), postUpdateDto.getContent());
    }


}
