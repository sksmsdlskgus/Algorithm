import java.util.*;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 블랙리스트 이용자 신고 -> 처리 결과 메일 발송 로직 
        // id_list = 유저 ID 정보 / 소문자로만, 같은 유저 중복 x
        
        // report  = 유저가 신고한 유저 ID 정보 
        // -> [이용자id(공백)신고한id] 형태 , 소문자로만 ,동일한 유저 신고는 1회로 처리
        // 자신을 신고는 못함.
        
        // k = 정지 기준 신고 횟수 , 자연수 <=200
        // -> k번 이상 신고된 유저는 게시판 이용 정지.  -> 이 유저를 신고한 모든 유저에게 정지사실을 메일로 발송
        
        // 최종 답 -> id_list 에 담긴 id 순서대로 각 유저가 받은 결과 메일 수 
        

        
        int[] emailCount = new int[id_list.length]; // 출력 될 이메일 전송 카운트 배열 생성 
        Map<String,Set<String>> resultMap  = new HashMap<>(); // 중복값 제거할 map 생성
        
        Map<String,Integer> index = new HashMap<>();  // 이용자 id와 index 값 저장 
        for(int i=0; i<id_list.length; i++){
            index.put(id_list[i],i);                       
      }

        for(String reportlist : report){ // report의 배열을 공백 기준으로 분리하고 배열에 담은 후, 각 변수에 저장 
            String[] split= reportlist.split(" ");
            String have = split[0];
            String behave = split[1];
            
            // 신고당한 사람이 resultMap에 없으면 빈 Set을 생성해서 넣음
            if (!resultMap.containsKey(behave)) {
                resultMap.put(behave, new HashSet<>());
            }
            resultMap.get(behave).add(have);  // 신고자를 Set에 추가
        }
        // 신고된 유저가 k번 이상 신고된 경우, 해당 유저를 신고한 사람들에게 메일을 발송
        for (String behave : resultMap.keySet()) {
            Set<String> reporters = resultMap.get(behave);
            
            if (reporters.size() >= k) {  // 신고 횟수가 k 이상이면
                // 신고한 사람들에게 메일 발송 처리
                for (String have : reporters) {
                    int idx = index.get(have);  // 신고한 사람의 인덱스를 가져옴
                    emailCount[idx]++;  // 해당 인덱스에 메일 발송 횟수 증가
                }
            }
        }
      
        return emailCount;
    }
}
