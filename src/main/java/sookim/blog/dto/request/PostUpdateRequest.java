package sookim.blog.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sookim.blog.domain.Post;

@Getter
@Setter
public class PostUpdateRequest {
    private Long id;
    private String title;
    private String content;

    @Builder
    public PostUpdateRequest(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
