package com.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.domain.posts.Post;
import com.springboot.service.PostService;
import com.springboot.web.dto.PostSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostService postService; // RequiredArgsConstructor로 DI해줌.
	
	@GetMapping("/")
	public String index() {
		return "board/list";
	}
	
	@GetMapping("/post")
	public String post() {
		return "board/post";
	}
	
	@PostMapping("/post")
	public String write(HttpServletRequest request, PostSaveRequestDto postSaveRequestDto) {
		
		postService.save(postSaveRequestDto.builder().title(request.getParameter("title")).content(request.getParameter("content"))
				.author(request.getParameter("author")).build());
		return "redirect:/";
	}
}
