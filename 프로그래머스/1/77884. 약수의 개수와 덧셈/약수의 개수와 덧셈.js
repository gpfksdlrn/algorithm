// 약수의 개수가 짝수인 수는 더하고
// 홀수인 수는 뺀 수를 리턴
function solution(left, right) {
    let sum = 0;
    for (let i = left; i <= right; i++) {
        Number.isInteger(Math.sqrt(i)) ? sum -= i : sum += i
    }
    return sum;
}