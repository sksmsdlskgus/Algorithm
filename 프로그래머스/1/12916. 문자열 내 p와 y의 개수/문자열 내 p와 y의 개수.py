def solution(s):
    s_upper = s.upper()
    x_count = 0
    y_count = 0
    
    for s_upper in s_upper: 
        if s_upper == 'P' :
            x_count+=1
        elif s_upper == "Y":
            y_count+=1
            
    if x_count == y_count :
        return True
    elif x_count != y_count: 
        return False

    