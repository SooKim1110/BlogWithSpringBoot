package sookim.blog.dto.response;

import lombok.Builder;
import lombok.Getter;
import sookim.blog.domain.Post;
import sookim.blog.dto.CommentDto;
import sookim.blog.dto.PostDto;
import sookim.blog.utils.PageInfo;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class IndexResponse {
    private List<PostDto> postDtos;
    private PageInfo pageInfo;

    public static IndexResponse of(List<PostDto> postDtos, PageInfo pageInfo){
        return IndexResponse.builder()
                .postDtos(postDtos)
                .pageInfo(pageInfo)
                .build();
    }
}