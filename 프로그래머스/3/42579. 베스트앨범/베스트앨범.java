import java.util.*;


class Solution {
    static class Song {
    int index;
    int playCount;
    
    Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
        
    public String toString() {
        return "Song{" +
                "index=" + index +
                ", playCount=" + playCount +
                '}';
    }
}

    public int[] solution(String[] genres, int[] plays) {
        // genres[i]는 고유번호가 i인 노래의 장르
        // plays[i]는 고유번호가 i인 노래가 재생된 횟수
        // 장르 내에서 많이 재생된 노래먼저 수록, 재생횟수가 같다면 고유번호가 낮은노래먼저 수록
        // 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
        
        HashMap<String,Integer> genresMap = new HashMap<>();
        HashMap<String, List<Song>> songMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int count = plays[i];
            genresMap.put(genre,genresMap.getOrDefault(genre,0)+count);
            
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new Song(i,count));
 
        }
      //  System.out.println(genresMap); // 장르 갯수
       // System.out.println(songMap.toString()); // 장르별 고유번호와 재생횟수
        
        //playCount가 많은것 부터 정렬후 앞에서 2번째까지의 고유번호 픽
        List <String> genreList = new ArrayList<>(genresMap.keySet());
        genreList.sort((a,b) -> genresMap.get(b) - genresMap.get(a)); // 내림차순
     //   System.out.println("genreList : " + genreList);
        
        List<Integer> result = new ArrayList<>();
        
        //와 생각보다 어렵네 ....................
        // 각 장르에서 상위 2곡 선택
        for (String genre : genreList){
            List<Song> songs = songMap.get(genre); // 리스트 Song에 키값을 대입 (장르)
            
            // 재생 횟수 내림차순 정렬, 재생 횟수 같으면 index 오름차순
            songs.sort((s1,s2)->s1.playCount == s2.playCount ? s1.index - s2.index : s2.playCount - s1.playCount);
             
            // 송스에 앞에서 2개 인덱스 즉, 고유번호 가져오기
            result.add(songs.get(0).index);
             if (songs.size() > 1) {
                result.add(songs.get(1).index);
            }
        }
        
        // System.out.println("최종 결과: " + result);
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}