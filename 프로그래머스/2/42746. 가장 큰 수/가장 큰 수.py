def solution(numbers):
    # 양의 정수가 담긴 배열 numbers
    # 정수를 이어붙여 만들 수 있는 가장 큰수
    
    answer = ''
    numbers = list(map(str, numbers))
    numbers.sort(reverse=True, key=lambda x: x * 10)
    answer = ''.join(numbers)  
    
    return '0' if answer[0] == '0' else answer
