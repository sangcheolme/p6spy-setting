package study.community.post.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.community.common.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseEntity {

    @Id // pk 칼럼 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 전략
    @Column(name = "post_id")
    private Long id; // mysql 기준 BigInteger로 치환

    @Column(name = "post_title", length = 500, nullable = false) // 칼럼 속성 지정
    private String title;

    @Column(name = "post_content", columnDefinition = "TEXT", nullable = false) // 칼럼 속성 지정
    private String content;

    @Column(name = "post_author")
    private String author;

    @Builder // 빌더 패턴 사용
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 글 update에서 사용할 생성자, 글을 수정해도 작성자는 변하지 않기때문에 author은 뺐다.
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
