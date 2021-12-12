package sookim.blog.dto;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import sookim.blog.domain.Comment;
import sookim.blog.domain.Post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
public class CommentDto {
    private Long id;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Post post;

    public static CommentDto of(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .writer(comment.getWriter())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }

    public Comment toEntity(){
        return Comment.builder()
                .id(id)
                .content(content)
                .writer(writer)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .post(post)
                .build();
    }

}