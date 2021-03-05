package com.springboot.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // JPA Entity들이 BaseTimeEntity를 상속할 경우 createdDate, modifiedDate들도 컬럼이 됨.
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능을 포함시킴.
public class BaseTimeEntity {

	@CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장.
	private LocalDateTime createdDate;
	
	@LastModifiedDate // Entity의 값이 변경될 때 시간이 자동 저장.
	private LocalDateTime modifiedDate;
	
}
