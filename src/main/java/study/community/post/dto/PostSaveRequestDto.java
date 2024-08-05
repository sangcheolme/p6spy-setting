package study.community.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import study.community.post.model.Post;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Post toEntity() {
        return Post.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    }
}
