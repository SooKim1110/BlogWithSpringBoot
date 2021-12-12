package sookim.blog.dto.response;

import lombok.Builder;
import lombok.Getter;
import sookim.blog.domain.Post;
import sookim.blog.dto.CommentDto;
import sookim.blog.dto.PostDto;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class PostReadResponse {
    PostDto postDto;
    List<CommentDto> commentDtos;

    public static PostReadResponse of(Post post) {
        return PostReadResponse.builder()
                .postDto(PostDto.of(post))
                .commentDtos(post.getComments().stream()
                        .map(CommentDto::of)
                        .collect(Collectors.toList())
                )
                .build();
    }
}
