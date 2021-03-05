package com.springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
}
