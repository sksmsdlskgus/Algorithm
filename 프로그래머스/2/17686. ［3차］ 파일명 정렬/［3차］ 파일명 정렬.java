import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // sort로 정렬 , 대소문자 구분x = 같은 순서 취급, 숫자만 구분앞에 0이 있을 수 있음 인지 x
        // 같은 순서 취급시, 입력할때 순서 지켜야함.
        // HEAD, NUMBER, TAIL의 세 부분
        // 아오너무 어렵다ㅜㅜ..
        
        List<String[]> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            String head = "", number = "", tail = "";
            int idx = 0;
            
            // HEAD 파싱 (문자 부분)
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                head += file.charAt(idx);
                idx++;
            }
            
            // NUMBER 파싱 (숫자 부분)
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                number += file.charAt(idx);
                idx++;
            }
            
            // TAIL 파싱 (나머지 부분)
            tail = file.substring(idx);
            
            // 숫자 앞의 0을 제거
            int num = Integer.parseInt(number);
            
            // 파일 정보를 리스트에 추가
            fileList.add(new String[]{head, String.valueOf(num), tail, String.valueOf(i), file});
        }

        // 파일 리스트 정렬 (HEAD, NUMBER, 순서대로)
        fileList.sort((a, b) -> {
            // HEAD 비교
            int headCompare = a[0].toLowerCase().compareTo(b[0].toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }

            // NUMBER 비교
            int numberCompare = Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
            if (numberCompare != 0) {
                return numberCompare;
            }

            // 입력 순서 비교
            return Integer.compare(Integer.parseInt(a[3]), Integer.parseInt(b[3]));
        });

        // 정렬된 파일명 배열을 반환
        return fileList.stream().map(file -> file[4]).toArray(String[]::new);
    }
}