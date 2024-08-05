package study.community.post.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateDto {

    private String title;
    private String content;
    private String author;
}
