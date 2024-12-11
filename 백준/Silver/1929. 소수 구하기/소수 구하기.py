def find_primes(M, N):
    sieve = [True] * (N + 1)
    sieve[0] = sieve[1] = False  # 0과 1은 소수가 아님

    for i in range(2, int(N ** 0.5) + 1):  # 제곱근까지만 탐색
        if sieve[i]:
            for j in range(i * i, N + 1, i):
                sieve[j] = False

    # M 이상 N 이하의 소수 반환
    return [num for num in range(M, N + 1) if sieve[num]]

# 입력 처리
M, N = map(int, input().split())
result = find_primes(M, N)

# 결과 출력
for prime in result:
    print(prime)