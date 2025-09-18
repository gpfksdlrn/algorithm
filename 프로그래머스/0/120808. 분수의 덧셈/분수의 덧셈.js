// 최대공약수 구하는 공식(유클리드 호제법)
function gcd(a, b) {
    if (b===0) {
        return a;
    }
    return gcd(b, a % b);
}

function solution(num1, denom1, num2, denom2) {
    // 1. 두 분수를 더한다.
    const numer = (num1 * denom2) + (num2 * denom1);
    const denom = denom1 * denom2;
    
    // 2. 더한 분수의 최대공약수를 구한다.
    const divisor = gcd(numer, denom);
    
    // 3. 분자와 분모를 최대공약수로 나누어 약분
    const numerResult = numer / divisor;
    const denomResult = denom / divisor;

    // 4. 결과를 배열에 담아 반환
    return [numerResult, denomResult];
}