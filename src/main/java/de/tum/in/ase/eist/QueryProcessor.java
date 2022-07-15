package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if (query.contains("largest")) { // TODO extend the programm here
            var numsString = query.substring(query.lastIndexOf(":") + 1)
                                  .replace("%", "");
            int max = Arrays.stream(numsString.split(","))
                            .mapToInt(Integer::parseInt)
                            .max()
                            .getAsInt();

            return String.format("%d", max);
        } else if(query.contains("plus")) {
            String is = "is";
            int isEnd = query.lastIndexOf(is) + is.length();
            String plus = "plus";
            int plusBegin = query.lastIndexOf(plus);
            int plusEnd = plusBegin + plus.length();
            String sub = query.substring(isEnd).replaceFirst("%", "");
            String aStr = sub.substring(0, sub.indexOf("%"))
                               .replace("%", "");
            String bStr = query.substring(plusEnd)
                               .replace("%", "");

            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);
            int sum = a + b;

            return "%d".formatted(sum);
        } else {
            return "";
        }
    }
}
