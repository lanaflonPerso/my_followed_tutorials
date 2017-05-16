package com.howtoprogram.junit5;

public final class StringUtils {


    static Double convertToDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    static boolean isNullOrBlank(String st) {
        return st == null || st.trim().length() == 0;
    }

    static String getDefaultIfNull(final String st, final String defaultSt) {
        return st == null ? defaultSt : st;
    }

    static String concat(String... sts) {
        String retVal = null;
        if (sts != null && sts.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String st : sts) {
                if (st != null) {
                    sb.append(st);
                }
            }
            retVal = sb.toString();
        }
        return retVal;
    }

}

