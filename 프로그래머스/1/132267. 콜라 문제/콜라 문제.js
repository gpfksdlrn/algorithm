function solution(a, b, n) {
    let answer = 0;
    while (n >= a) {
        const cola = Math.floor(n / a);
        const receivedCola = cola * b;
        answer += receivedCola;
        n = (n % a) + receivedCola;
    }
    return answer;
}