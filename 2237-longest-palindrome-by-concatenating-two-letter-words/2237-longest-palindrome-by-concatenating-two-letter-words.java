class Solution {
    public int longestPalindrome(String[] words) {
        // Use a hashmap to count occurrences of each word
        Map<String, Integer> countMap = new HashMap<>();
        int palindromeLength = 0;
        boolean centralPalindromeUsed = false;

        for (String word : words) {
            // Reverse the word to check for pairs
            String reversed = new StringBuilder(word).reverse().toString();

            // If a reverse word exists in map, form a pair
            if (countMap.getOrDefault(reversed, 0) > 0) {
                palindromeLength += 4; // two 2-letter words = 4 characters
                countMap.put(reversed, countMap.get(reversed) - 1);
            } else {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);
            }
        }

        // After forming pairs, check if there's any word like "gg", "aa", etc. left to use in center
        for (String word : countMap.keySet()) {
            if (word.charAt(0) == word.charAt(1) && countMap.get(word) > 0) {
                palindromeLength += 2; // add only one 2-letter word in the center
                break; // only one such word can be placed in the center
            }
        }

        return palindromeLength;
    }
}
