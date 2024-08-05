package study.community.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import study.community.post.model.Post;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private String title;
    private String content;
    private String author;

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
