package sookim.blog.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sookim.blog.domain.Post;
import sookim.blog.dto.PostDto;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PageInfo {
    private int totalPages;
    private int pageIdx;
    private boolean prevEnabled;
    private boolean nextEnabled = true;
    private int startIdx;
    private int endIdx;
    private final int size = 5;
    private List<PostDto> postDtos;

    public PageInfo(int pageIdx, int totalPages, List<PostDto> postDtos) {
        this.pageIdx = pageIdx;
        this.totalPages = totalPages;
        this.postDtos = postDtos;

        this.startIdx = pageIdx - ((pageIdx - 1) % size);
        this.endIdx = startIdx + size - 1;
        if (endIdx >= totalPages) {
            endIdx = totalPages;
            nextEnabled = false;
        }

        this.prevEnabled = pageIdx > size;
    }
}
