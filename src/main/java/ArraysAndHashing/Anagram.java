package ArraysAndHashing;

import java.util.HashMap;

public class Anagram {
    public static boolean isAnagram(String word1, String word2){
        if (word1.length() != word2.length()){
            return false;
        }
        char[] word1C = word1.toCharArray();
        char[] word2C = word2.toCharArray();
        HashMap<Character, Integer> word1H = new HashMap<>();
        HashMap<Character, Integer> word2H = new HashMap<>();

        for(int i = 0; i < word1.length(); i++){
            if(word1H.containsKey(word1C[i])){
                word1H.put(word1C[i], word1H.get(word1C[i]) + 1);
            }else{
                word1H.put(word1C[i], 1);
            }
            if(word2H.containsKey(word2C[i])){
                word2H.put(word2C[i], word2H.get(word2C[i]) + 1);
            }else{
                word2H.put(word2C[i], 1);
            }
        }

        return word1H.equals(word2H);
    }

    public static boolean isAnagramSV(String word1, String word2){
        if (word1.length() != word2.length()){return false;}

        HashMap<Character, Integer> appereances = new HashMap<>();

        for(char c : word1.toCharArray()){
            appereances.put(c,appereances.getOrDefault(c,0) + 1);
        }

        for (char c : word2.toCharArray()){
            if (!appereances.containsKey(c)) return false;

            appereances.put(c, appereances.get(c) -1 );
            if (appereances.get(c) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String word1 = "listen";
        String word2 = "silent";
        boolean result = isAnagramSV(word1, word2);
        System.out.println("Are the words \"" + word1 + "\" and \"" + word2 + "\" anagrams? " + result);
    }
}
