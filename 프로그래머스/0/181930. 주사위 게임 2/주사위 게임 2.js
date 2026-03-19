// 주사위 3개
// case1. 세 숫자가 모두 다르다면 a + b + c점
// case2. 두 숫자가 같고 나머지 다른 숫자는 다르다면 (a + b + c) x (a^2 + b^2 + c^2)점
// case3. 세 숫자가 모두 같다면 (a + b + c) x (a^2 + b^2 + c^2) x (a^3 + b^3 + c^3)점

function solution(a, b, c) {
    const sum1 = a + b + c;
    const sum2 = a**2 + b**2 + c**2;
    const sum3 = a**3 + b**3 + c**3;
    
    // case3
    if (a === b && b === c) {
        return sum1 * sum2 * sum3;
    }
    
    // case1
    if (a !== b && b !== c && a !== c) {
        return sum1;
    } 
    
    // case2
    return sum1 * sum2;
}