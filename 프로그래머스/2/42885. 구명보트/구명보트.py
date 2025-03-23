def solution(people, limit):
    # 구명보트는 최대 2명 무게제한은 limit
    # 사람들 몸무게 담은 배열 people 
    # 모든 사람을 구출하기 위해 필요한 구명보트 개수를 return
    # 투 포인터 사용
    people.sort()
    
    left = 0
    right = len(people)-1
    answer = 0
    
    while left <= right :
        if people[left] + people[right] <= limit :
            left +=1
            right -=1
        else:
            right -=1
        answer += 1
        
    return answer