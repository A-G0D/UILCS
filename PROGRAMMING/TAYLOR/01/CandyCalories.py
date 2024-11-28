import sys
sys.stdin = open("CandyCalories.in", "r")

n: int = int(input())
l: list[tuple[str, int, int]] = []

for i in range(n):
    s: str
    cnt: int
    val: int
    s, cnt, val = input().split()
    cnt, val = map(int, [cnt, val])
    l.append((s, cnt, val))

l.sort(key = lambda x: x[2])

cnt: int = 0
sm: int = 0
for i in l:
    if sm < 1500 and sm + i[2] < 1500:
        tmp: int = min(i[1], (1499 - sm) // i[2])
        sm += tmp * i[2]
        cnt += tmp
        
print(cnt)