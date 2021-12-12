package sookim.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sookim.blog.domain.Post;
import sookim.blog.dto.request.PostCreateRequest;
import sookim.blog.dto.request.PostUpdateRequest;
import sookim.blog.dto.response.PostReadResponse;
import sookim.blog.repository.PostRepository;
import sookim.blog.utils.PageInfo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void savePost(PostCreateRequest request) {
        postRepository.save(request.toEntity());
    }

    @Transactional
    public void updatePost(PostUpdateRequest request) {
        postRepository.save(request.toEntity());
    }
    @Transactional
    public PostReadResponse findPost(Long postId) {
        return PostReadResponse.of(postRepository.findById(postId).get());
    }

    @Transactional
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
