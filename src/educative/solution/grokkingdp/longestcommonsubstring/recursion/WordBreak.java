package educative.solution.grokkingdp.longestcommonsubstring.recursion;

import java.util.*;

public class WordBreak {

    //The time complexity of the above algorithm is
    //�
    //(
    //�
    //×
    //2
    //�
    //)
    //O(w×2
    //n
    // )
    //, where
    //�
    //n
    // is the length of the query string s, and
    //�
    //w
    // is the number of words in the dictionary.
    public static List<String> wordBreak(String s, List<String> wordDict) {
        // Calling the wordBreakRec function
        return wordBreakRec(s, wordDict);
    }

    // helper function that breaks down the string into words from substrings
    private static List<String> wordBreakRec(String s, List<String> dictionary) {
        // if s is an empty string
        if (s.isEmpty())
            return new ArrayList<String>();

        List<String> res = new ArrayList<String>();

        // Verifying if s can be broken down further
        for (String word : dictionary) {
            // if s does not start with the current word, skip it
            if (!s.startsWith(word))
                continue;
            if (word.length() == s.length())
                res.add(s);
            else {
                // otherwise, break down the remaining part of s and append the current word to each result
                List<String> resultOfTheRest = wordBreakRec(s.substring(word.length()), dictionary);
                for (String item : resultOfTheRest) {
                    item = word + " " + item;
                    res.add(item);
                }
            }
        }
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

        // You can uncomment the line below and check how this recursive solution causes a time-out.
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
