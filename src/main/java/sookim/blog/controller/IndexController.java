package sookim.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sookim.blog.domain.Post;
import sookim.blog.repository.PostRepository;
import sookim.blog.service.IndexService;
import sookim.blog.service.PostService;
import sookim.blog.utils.PageInfo;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final IndexService indexService;

    @GetMapping("/")
    public String home(@RequestParam(value= "pageIdx", required = false, defaultValue = "1") int pageIdx, Model model) {
        PageInfo pageInfo = indexService.getPageInfo(pageIdx);
        model.addAttribute("posts", pageInfo.getPostDtos());
        model.addAttribute("page", pageInfo);
        return "index";
    }
}