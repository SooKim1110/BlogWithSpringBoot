package sookim.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sookim.blog.domain.Comment;
import sookim.blog.domain.Post;
import sookim.blog.dto.CommentDto;
import sookim.blog.dto.request.PostUpdateRequest;
import sookim.blog.dto.response.PostReadResponse;
import sookim.blog.service.CommentService;
import sookim.blog.service.PostService;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    @PostMapping("/{postId}/comment")
    public String home(@PathVariable Long postId, CommentDto commentDto, Model model) {
        PostReadResponse response = postService.findPost(postId);
        commentDto.setPost(response.getPostDto().toEntity());
        commentService.saveComment(commentDto);
        return "redirect:/posts/{postId}";
    }
}
