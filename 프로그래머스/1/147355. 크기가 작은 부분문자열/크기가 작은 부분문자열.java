class Solution {
    public int solution(String t, String p) {
        int limit = t.length() - p.length();
        int count = 0;

        for (int i = 0; i <= limit; i++) {
            String sub = t.substring(i, i + p.length()); 
            if (sub.compareTo(p) <= 0) count++;
        }
        return count;
    }
}
