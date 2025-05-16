class Solution {
    public String solution(int a, int b) {
        String[] day = {"THU","FRI","SAT","SUN", "MON", "TUE", "WED"};
        
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        
        int totalDay = 0;
        for(int i=0; i<a-1; i++){
            totalDay += daysInMonth[i];
        }
        totalDay += b;
        
        int dayIndex = totalDay%7;
        
        return day[dayIndex];
    }
}
