package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public static final String LARGEST = "which of the following numbers is the largest:";

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if (query.contains(LARGEST)) { // TODO extend the programm here
            var numsString = query.substring(LARGEST.length());
            var nums = numsString.split(",");
            int[] numsInt = new int[nums.length];

            for (int i = 0; i < nums.length; ++i) {
                numsInt[i] = Integer.parseInt(nums[i]);
            }

            int max = Arrays.stream(numsInt).max().getAsInt();

            return String.format("%d", max);
        } else {
            return "";
        }
    }
}
