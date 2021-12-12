package sookim.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sookim.blog.domain.Comment;
import sookim.blog.domain.Post;
import sookim.blog.dto.CommentDto;
import sookim.blog.dto.PostDto;
import sookim.blog.dto.request.PostCreateRequest;
import sookim.blog.dto.request.PostUpdateRequest;
import sookim.blog.dto.response.PostReadResponse;
import sookim.blog.service.CommentService;
import sookim.blog.service.PostService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/write")
    public String getWrite(){
        return "write";
    }

    @PostMapping("/write")
    public String postWrite(PostCreateRequest request, Model model)
    {
        postService.savePost(request);
        return "redirect:/";
    }

    @GetMapping("/edit/{postId}")
    public String getEditPostId(@PathVariable Long postId, Model model){
        PostReadResponse response = postService.findPost(postId);
        model.addAttribute("post", response.getPostDto());
        return "edit";
    }

    @PostMapping("/edit/{postId}")
    public String postEditPostId(@PathVariable Long postId, PostUpdateRequest request){
        request.setId(postId);
        postService.updatePost(request);
        return "redirect:/";
    }

    @GetMapping("/posts/{postId}")
    public String viewPost(@PathVariable Long postId, Model model){
        PostReadResponse response = postService.findPost(postId);
        model.addAttribute("post", response.getPostDto());
        model.addAttribute("comments", response.getCommentDtos());
        return "post";
    }

    @DeleteMapping("/posts/{postId}")
    public String viewEditPost(@PathVariable Long postId){
        postService.deletePost(postId);
        return "redirect:/";
    }
}
