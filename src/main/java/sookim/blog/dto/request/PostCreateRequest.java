package sookim.blog.dto.request;

import lombok.Builder;
import lombok.Getter;
import sookim.blog.domain.Post;

@Getter
public class PostCreateRequest {
    private String title;
    private String content;

    @Builder
    public PostCreateRequest(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
