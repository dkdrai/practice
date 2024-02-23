package educative.solution.grokkingcodinginterviewpatterns.topkelements;

import java.util.*;

class Reorganize {
    public static String reorganizeString(String str) {
        // initializing the hash map
        Map <Character, Integer> charCounter = new HashMap <> ();
        
        // Calculate the frequency of characters in string and store counts
        // of each character along with the character itself in hash map.
        for (char c: str.toCharArray()) {
            int freq = charCounter.getOrDefault(c, 0) + 1;
            charCounter.put(c, freq);
        }

        // initializing the max heap
        PriorityQueue <Map.Entry <Character, Integer>> maxFreqChar = new PriorityQueue <Map.Entry <Character, Integer>> (
            (item1, item2) -> item2.getValue() - item1.getValue());

        // store all characters with their frequencies to the max heap
        maxFreqChar.addAll(charCounter.entrySet());

        // initializing variables
        Map.Entry <Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(str.length());
        while (!maxFreqChar.isEmpty() || previous!=null) {

            if (previous != null && maxFreqChar.isEmpty())
                return "";
            
            Map.Entry <Character, Integer> currentEntry = maxFreqChar.poll();

            // decrement the character count, as we've now used one occurrence of it
            int count=currentEntry.getValue()-1;
            result.append(currentEntry.getKey());

            // pushing the char back to heap
            if(previous!=null){
                maxFreqChar.add(previous);
                previous=null;
            }
            
            // setting previous to the most recent used char
            if(count != 0){
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);
            }
        }

        return result.toString();
    }

    public static void main(String args[]) {
        String[] inputs = {
            "programming",
            "hello",
            "fofjjb",
            "abbacdde",
            "aba",
            "awesome",
            "aaab",
            "aab"
        };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string: \"" + inputs[i] + "\"");

            String output = reorganizeString(inputs[i]);
            output = (output.length() == 0) ? "''" : output;

            System.out.println("\tReorganized string: \"" + output + "\"");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }
}