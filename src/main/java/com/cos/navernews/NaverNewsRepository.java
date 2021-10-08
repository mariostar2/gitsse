package com.cos.navernews;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface NaverNewsRepository extends ReactiveMongoRepository<NaverNews, String> {

	
	//데이터가 들어올때마다 계속 흘러보네줌(데이터베이스에 들어올때마다) 
	@Tailable //커서를 계속 열어두는 어노테이션(몽고DB에만 있음)
	@Query("{}")	
	Flux<NaverNews>mFindAll();
	
}
