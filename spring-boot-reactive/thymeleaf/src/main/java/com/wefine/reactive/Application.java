
package com.wefine.reactive;

import com.wefine.reactive.agents.MatchCommentAgent;
import com.wefine.reactive.agents.MatchEventAgent;
import com.wefine.reactive.entity.MatchComment;
import com.wefine.reactive.entity.MatchEvent;
import com.wefine.reactive.util.Data;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class Application {


	@Bean
	public ApplicationRunner initialize(final ReactiveMongoTemplate mongoTemplate) {
		return args -> {

			/*
			 * INSERT ALL THE NEEDED TEST DATA (will block)
			 */
			Data.initializeAllData(mongoTemplate);

			/*
			 * INITIALIZATION OF THE MATCH EVENT STREAM
			 */
			final MatchEventAgent matchEventAgent = new MatchEventAgent(mongoTemplate);
			final Flux<MatchEvent> matchEventStream = matchEventAgent.createAgentStream();
			// Subscribe and just let it run (forever)
			matchEventStream.subscribe();

			/*
			 * INITIALIZATION OF THE MATCH COMMENT STREAM
			 */
			final MatchCommentAgent matchCommentAgent = new MatchCommentAgent(mongoTemplate);
			final Flux<MatchComment> matchCommentStream = matchCommentAgent.createAgentStream();
			// Subscribe and just let it run (forever)
			matchCommentStream.subscribe();

		};
	}




	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
