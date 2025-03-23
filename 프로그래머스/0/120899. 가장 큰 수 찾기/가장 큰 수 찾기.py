def solution(array):
    # 가장 큰수와 그수의 인덱스를 담은 배열을 return해라
    answer = []
    
    largest = max(array)
    index = array.index(largest)
    answer = [largest, index]
        
        
    return answer