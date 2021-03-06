package com.springboot.web.dto;

import java.time.LocalDateTime;

import com.springboot.domain.posts.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

	private Long id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	@Builder
	public PostSaveRequestDto(Long id, String title, String content, String author, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	public Post toEntity() {
		return Post.builder()
				.id(id)
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
	
}
