package com.wefine.reactive.web.controller;


import com.wefine.reactive.business.dataviews.MatchStatus;
import com.wefine.reactive.repository.MatchStatusRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;

@Controller
public class MatchesController {


    private final MatchStatusRepository matchStatusRepository;



    public MatchesController(final MatchStatusRepository matchStatusRepository) {
        super();
        this.matchStatusRepository = matchStatusRepository;
    }



    @RequestMapping({"/","/matches"})
    public String matches(final Model model) {

        // Get the stream of MatchStatus objects. In this case this works as the reactive
        // equivalent to getting a List<MatchStatus>. Being reactive, it won't be resolved
        // until really needed (just before rendering the HTML)
        final Flux<MatchStatus> matchStatusStream = this.matchStatusRepository.findAllMatchStatus();

        // By adding this Flux directly to the model (without wrapping) we are indicating that
        // we want this variable to be completely resolved by Spring WebFlux (without blocking)
        // before Thymeleaf starts the rendering of the HTML template. That way, this variable
        // will have for the Thymeleaf engine the exact same appearance as a List<MatchStatus>.
        model.addAttribute("matchStatuses", matchStatusStream);

        // Return the template name (templates/matches.html)
        return "matches";

    }

}
