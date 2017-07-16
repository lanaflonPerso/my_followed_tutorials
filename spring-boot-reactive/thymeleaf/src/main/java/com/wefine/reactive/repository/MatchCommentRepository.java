package com.wefine.reactive.repository;


import com.wefine.reactive.entity.MatchComment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface MatchCommentRepository extends ReactiveMongoRepository<MatchComment,String> {

    /*
     * Note that we are extending from ReactiveMongoRepository, which will
     * already add a large amount of methods to our repository for free!
     */


    // This is a normal, non-tailable stream that will give us the initial values to be rendered for
    // the comments section of a match
    public Flux<MatchComment> findByMatchIdAndTimestampLessThanEqualOrderByTimestampDesc(final String matchId, final String timestamp);


    // OrderBy cannot be used in @Tailable, but that's fine because they will be returned in insertion order
    // and for our SSE stream that's exactly what we want
    @Tailable
    public Flux<MatchComment> findByMatchIdAndTimestampGreaterThan(final String matchId, final String timestamp);

}
