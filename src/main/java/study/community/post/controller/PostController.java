package study.community.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.community.common.ResponseApi;
import study.community.post.dto.PostResponseDto;
import study.community.post.dto.PostSaveRequestDto;
import study.community.post.dto.PostUpdateDto;
import study.community.post.service.PostService;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseApi<Void> save(@RequestBody PostSaveRequestDto postSaveRequestDto) {
        log.info("글 저장");
        postService.save(postSaveRequestDto);

        return new ResponseApi<>(true, "저장 성공", null);
    }

    @GetMapping("/{id}")
    public ResponseApi<PostResponseDto> findPost(@PathVariable Long id) {
        log.info("글 조회 id={}", id);
        PostResponseDto postResponseDto = postService.findById(id);

        return new ResponseApi<>(true, "조회 성공", postResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseApi<PostResponseDto> update(@PathVariable Long id, @RequestBody PostUpdateDto postUpdateDto) {
        log.info("글 수정 id={}", id);
        postService.update(id, postUpdateDto);

        return new ResponseApi<>(true, "수정 성공", null);
    }
}
