package com.wefine.reactive.util;


import java.util.Random;


public class MatchCommentUtils {

    private static final Random RANDOM = new Random(System.currentTimeMillis());



    public static String randomAuthor() {
        return Data.COMMENT_AUTHORS.get(RANDOM.nextInt(Data.COMMENT_AUTHORS.size()));
    }

    public static String randomText() {
        return Data.COMMENT_TEXTS.get(RANDOM.nextInt(Data.COMMENT_TEXTS.size()));
    }



    private MatchCommentUtils() {
        super();
    }

}
