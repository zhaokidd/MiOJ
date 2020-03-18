package src.hash;

import java.util.Arrays;

public class LeetCode1160Hash {
    public static void main(String[] args){

    }

    public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] characterHash = new int[26];
        Arrays.fill(characterHash, 0);

        for (int i = 0; i < chars.length(); i++) {
            characterHash[chars.charAt(i) - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {

            boolean result = true;
            String word = words[i];
            int[] hash = new int[26];
            Arrays.fill(hash, 0);

            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                hash[index]++;
                if (hash[index] > characterHash[index]) {
                    result = false;
                }
            }

            if (result) {
                count += word.length();
            }
        }

        return count;
    }
}
