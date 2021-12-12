package sookim.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sookim.blog.domain.Comment;
import sookim.blog.domain.Post;
import sookim.blog.dto.CommentDto;
import sookim.blog.dto.PostDto;
import sookim.blog.repository.PostRepository;
import sookim.blog.utils.PageInfo;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexService {
    private final PostRepository postRepository;

    @Transactional
    public PageInfo getPageInfo(int pageIdx) {
        Page<Post> postPage = postRepository.findAll(PageRequest.of(pageIdx-1, 5, Sort.by("CreatedAt").descending()));
        List<Post> posts = postPage.getContent();
        List<PostDto> postDtos = new ArrayList<>();

        for (Post post: posts){
            PostDto postDto = PostDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .createdAt(post.getCreatedAt())
                    .updatedAt(post.getUpdatedAt())
                    .build();
            postDtos.add(postDto);
        }

        PageInfo pageInfo = new PageInfo(pageIdx, postPage.getTotalPages(), postDtos);
        return pageInfo;
    }

}