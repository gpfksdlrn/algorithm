function solution(n) {
    let i = n;
    let answer = 0;
    while(i-- > 0) {
        if(n % i === 1 ){
            answer = i;
        }
    }
    return answer;
}