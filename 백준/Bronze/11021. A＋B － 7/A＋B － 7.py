n = int(input())

result = []

for i in range(1, n+1):
    A, B = map(int, input().split())
    result.append(f"Case #{i}: {A + B}")

print("\n".join(result))