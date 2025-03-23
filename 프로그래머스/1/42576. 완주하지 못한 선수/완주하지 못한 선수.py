def solution(participant, completion):
    # 참여 선수들 이름이 담긴 배열 participant
    # 완주한 선수들 이름이 담긴 배열 completion
    # 완주하지 못한 선수의 이름을 return 해라
    
    my_dict = {}
    
    
    for player in participant :
        if player in my_dict:
            my_dict[player] +=1
        else : my_dict[player] =1
        
    for player in completion :
        my_dict[player] -=1
        
    for player in my_dict :
        if my_dict[player] ==1:
            return player
        
