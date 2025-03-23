def solution(s):
    # 최소값과 최대값을 찾아 문자열 형태로 return
    answer = ''
    
    s = list(map(int,s.split()))
    print(s)
    MAX = max(s)
    MIN = min(s)
    
    answer = MAX + MIN
    
    return f"{MIN} {MAX}"