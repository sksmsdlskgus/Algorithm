import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] arrayString = Arrays.stream(numbers)
                                      .mapToObj(String::valueOf)
                                      .toArray(String[]::new);
        
        Arrays.sort(arrayString, (a, b) -> (b + a).compareTo(a + b));
        
        //String result = String.join("", arrayString);
        
        StringBuilder resultArray = new StringBuilder();
        for (String result : arrayString ){
            resultArray.append(result);
        }
         String result = resultArray.toString();
        return result.charAt(0) == '0' ? "0" : result;
    }
}
