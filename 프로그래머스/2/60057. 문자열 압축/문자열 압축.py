def solution(s):
    # 반복되는 문자열 압축시키기
    if len(s) == 1 : return 1
    
    min_lenght = len(s)
    
    for step in range(1, len(s)//2 +1):
        slic = ""
        prev = s[:step]
        count =1
        
        for i in range(step, len(s), step):
            if prev == s[i:i+step]:
                count+=1
            else :
                if count > 1 :
                    slic += str(count)+prev
                else :
                    slic += prev
                count = 1
                prev = s[i:i+step]
                    
        if count > 1:
            slic += str(count)+prev
        else :
            slic += prev    
            
        min_lenght  = min(min_lenght , len(slic))
    
    return min_lenght 