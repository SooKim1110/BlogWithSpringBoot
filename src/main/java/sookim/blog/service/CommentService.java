package sookim.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sookim.blog.domain.Comment;
import sookim.blog.domain.Post;
import sookim.blog.dto.CommentDto;
import sookim.blog.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public void saveComment(CommentDto commentDto){
        commentRepository.save(commentDto.toEntity());
    }

//    @Transactional
//    public List<CommentDto> getCommentList(Long postId) {
//        List<Comment> commentList = commentRepository.findByPost_Id(postId);
//        List<CommentDto> commentDtoList = new ArrayList<>();
//
//        for (Comment comment : commentList) {
//            CommentDto commentDto = CommentDto.builder()
//                    .id(comment.getId())
//                    .writer(comment.getWriter())
//                    .content(comment.getContent())
//                    .createdAt(comment.getCreatedAt())
//                    .build();
//            commentDtoList.add(commentDto);
//        }
//
//        return commentDtoList;
//    }
}