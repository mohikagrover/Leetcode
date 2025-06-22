class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        // Calculate the number of groups needed
        int groups = (n + k - 1) / k; // This is equivalent to Math.ceil(n / k)
        
        String[] result = new String[groups];
        
        for (int i = 0; i < groups; i++) {
            int start = i * k;
            int end = Math.min(start + k, n);
            
            // Extract substring for current group
            StringBuilder sb = new StringBuilder(s.substring(start, end));
            
            // Add fill characters if needed (only for the last group)
            while (sb.length() < k) {
                sb.append(fill);
            }
            
            result[i] = sb.toString();
        }
        
        return result;
    }
}