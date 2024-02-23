package educative.solution.grokkingdp.longestcommonsubstring.dp;

import java.util.*;

public class WordBreak {

    //O(n^2)
    public static List<String> wordBreak(String s, List<String> wordDict) {
        // Calling the helper function
        return wordBreakRec(s, wordDict, new HashMap<>());
    }

    // Helper Function that breaks down the string into words from subs
    public static List<String> wordBreakRec(String s, List<String> dictionary, Map<String, List<String>> result) {
        // If s is empty string
        if (s.isEmpty())
            return new ArrayList<String>();

        if (result.containsKey(s))
            return result.get(s);

        List<String> res = new ArrayList<String>();
        for (String word : dictionary) {
            // Verifying if s can be broken down further
            if (!s.startsWith(word))
                continue;
            if (word.length() == s.length()) {
                res.add(s);
            } else {
                List<String> resultOfTheRest = wordBreakRec(s.substring(word.length()), dictionary, result);
                for (String item : resultOfTheRest) {
                    item = word + " " + item;
                    res.add(item);
                }
            }
        }
        result.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<String>(
            Arrays.asList("vegancookbook", "catsanddog", "highwaycrash", "screamicecream", "educativecourse")
        );

        ArrayList<String> wordDict = new ArrayList<String>(
            Arrays.asList("v", "vegan", "cookbook", "vegancookbook", "veg", "gan", "eg", "eganc", "ookboo",
                "kc", "ats", "an", "ddog", "ddogh", "cookb", "cook", "b", "anco", "ancoo", "ook", "book", 
                "kbook", "kbookc", "books", "cats", "cat", "and", "andd", "sand", "sanddoghigh", "catsanddog", 
                "doghigh", "sandd", "og", "dog", "hi", "gh", "ghway", "ghw", "ayc", "rash", "ra", "sh", "highways", 
                "high", "doghigh", "way", "cra", "c", "waycrash", "crash", "crashp", "crashpineapple", 
                "vegancookbookcats", "anddoghighwaycrashpineapplepenapplescrea", "anddoghighwaycrashpineapplepenapple", 
                "vegancookbookcatsanddog", "vegancookbookcatsanddoghighway", "catsanddoghighway", "crashpineapplepenapplescrea", 
                "crashpineapplepenapple", "applepenapple", "pineapplepenapplescre", "pineapplepenapple", "a", "crashpine", "inea", 
                "app", "en", "ine", "plep", "pe", "napplesc", "ena", "ple", "le", "penap", "lepe", "ppl", "pples", "pple", 
                "pine", "pin", "nap", "napp", "eapple", "apple", "apples", "pen", "penapple", "penapples", "vegancookbookcatsanddoghighway", 
                "vegancookbookcatsanddoghighwaycrashpineapplepenapplescrea", "vegancookbookcatsanddoghighwaycrashpineapplepenapplescream"
            )
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization
        // s.add("vegancookbookcatsanddoghighwaycrashpineapplepenapplescream");

        System.out.println("The list of words we can use to break down the strings are:\n");
        System.out.println(wordDict);
        System.out.println(new String(new char[100]).replace('\0', '-'));

        for (int i = 0; i < s.size(); i++)
        {
            System.out.println("Test Case #" + (i + 1) + "\n\nThe possible strings from the string '" + s.get(i) + "' are the following combinations:\n");
            System.out.println(wordBreak(s.get(i), wordDict));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
