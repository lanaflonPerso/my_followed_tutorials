package com.wefine.reactive.util;


import com.wefine.reactive.entity.MatchEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MatchEventUtils {

    private static final List<MatchEvent.Type> WEIGHED_TYPES;
    private static final Random RANDOM;

    static {

        // We will create a weighed list containing 100 Type instances, repeated as many times
        // as the probability we want to give each Type, so that randomly selected event types
        // make the best possible sense.
        final List<MatchEvent.Type> weighedTypes = new ArrayList<>();
        for (int i = 0; i < 60; i++) { // 70% Opportunity
            weighedTypes.add(MatchEvent.Type.OPPORTUNITY);
        }
        for (int i = 0; i < 20; i++) { // 10% Goal
            weighedTypes.add(MatchEvent.Type.GOAL);
        }
        for (int i = 0; i < 18; i++) { // 18% Yellow Card
            weighedTypes.add(MatchEvent.Type.YELLOW_CARD);
        }
        for (int i = 0; i < 2; i++) { // 2% Red Card
            weighedTypes.add(MatchEvent.Type.RED_CARD);
        }
        WEIGHED_TYPES = Collections.unmodifiableList(weighedTypes);
        RANDOM = new Random(System.currentTimeMillis());

    }


    public static MatchEvent.Type randomEventType() {
        return WEIGHED_TYPES.get(RANDOM.nextInt(WEIGHED_TYPES.size()));
    }



    private MatchEventUtils() {
        super();
    }

}
