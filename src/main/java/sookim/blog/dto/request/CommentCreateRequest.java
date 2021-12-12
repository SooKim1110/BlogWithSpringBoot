package sookim.blog.dto.request;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import sookim.blog.domain.Comment;
import sookim.blog.domain.Post;
import sookim.blog.dto.PostDto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
public class CommentCreateRequest {
    private String content;
    private String writer;
    private PostDto postDto;

    @Builder
    public CommentCreateRequest(String writer, String content, PostDto postDto){
        this.postDto = postDto;
        this.writer = writer;
        this.content = content;
    }

    public Comment toEntity(){
        return Comment.builder()
                .writer(writer)
                .content(content)
                .post(postDto.toEntity())
                .build();
    }
}