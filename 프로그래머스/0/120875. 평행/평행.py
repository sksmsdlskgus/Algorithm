def solution(dots):
    def is_parallel(a, b, c, d):
        # 두 선분의 기울기가 같은지 
        return (b[1] - a[1]) * (d[0] - c[0]) == (d[1] - c[1]) * (b[0] - a[0])
    
    # 세 가지 경우의 평행 여부
    if is_parallel(dots[0], dots[1], dots[2], dots[3]):
        return 1
    if is_parallel(dots[0], dots[2], dots[1], dots[3]):
        return 1
    if is_parallel(dots[0], dots[3], dots[1], dots[2]):
        return 1
    
    return 0
