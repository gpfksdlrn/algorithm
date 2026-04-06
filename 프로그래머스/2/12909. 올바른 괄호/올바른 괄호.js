function solution(s){
    let sum = 0;
    for (let char of s) {
        sum += char === '(' ? 1 : -1;
        
        if(sum < 0) return false;
    }
    return sum === 0;
}