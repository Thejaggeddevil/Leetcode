class Solution {
    public String countAndSay(int n) {
        
        if (n == 1) return "1";

        String prev = countAndSay(n - 1); // Recursively get the (n-1)th string
        StringBuilder result = new StringBuilder();

        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++; // same digit, keep counting
            } else {
                result.append(count).append(prev.charAt(i - 1)); // say what you saw
                count = 1; // reset for the new digit
            }
        }

        // Append the last group
        result.append(count).append(prev.charAt(prev.length() - 1));

        return result.toString();
    }
}

        
