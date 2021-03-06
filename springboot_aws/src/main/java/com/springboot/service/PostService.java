package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.domain.posts.Post;
import com.springboot.domain.posts.PostRepository;
import com.springboot.web.dto.PostSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository; // RequiredArgsConstructor로 DI해줌.
	
	@Transactional
	public Long save(PostSaveRequestDto requestDto) {
		return postRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public List<PostSaveRequestDto> getPostList() {
		List<Post> postList = postRepository.findAll();
		List<PostSaveRequestDto> postDtoList = new ArrayList<>();
		
		for (Post post : postList) {
			PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
					.id(post.getId())
					.title(post.getTitle())
					.content(post.getContent())
					.author(post.getContent())
					.build();
			postDtoList.add(requestDto);
		}
		return postDtoList;
	}
	
}
