package com.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.domain.posts.Post;
import com.springboot.domain.posts.PostRepository;

@SpringBootTest
public class PostRepositoryTest {

	@Autowired
	PostRepository postRepository;
	
	@AfterEach
	public void clean() {
		postRepository.deleteAll();
	}
	
	@Test
	public void save() {
		// given
		String title="title";
		String content="content";
		String author="author";
		
		postRepository.save(Post.builder().title(title).content(content).author(author).build());
		// when
		List<Post> postList = postRepository.findAll();
		
		// then
		Post post = postList.get(0);
		
		assertThat(post.getTitle()).isEqualTo(title);
		
	}
	
}
