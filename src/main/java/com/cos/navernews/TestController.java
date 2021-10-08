package com.cos.navernews;

import java.time.Duration;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class TestController {

	@GetMapping("/flux")
	public Flux<Integer> flux(){
		return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(1)).log();
	}
	
	@GetMapping(value = "/fluxstream",produces =MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Integer> fluxstream(){
		return Flux.just(1,2,3,4).delayElements(Duration.ofSeconds(1)).log();
	}
	

	
}
