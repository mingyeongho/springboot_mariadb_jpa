package com.springboot.domain.posts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 10)
	private String title;
	
	@Column(length = 100)
	private String content;
	
	@Column(columnDefinition = "TEXT")
	private String author;
	
	@CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장.
	@Column(updatable = false)
	private LocalDateTime createdDate;
	
	@LastModifiedDate // Entity의 값이 변경될 때 시간이 자동 저장.
	private LocalDateTime modifiedDate;
	
	@Builder
	public Post(Long id, String title, String content, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
