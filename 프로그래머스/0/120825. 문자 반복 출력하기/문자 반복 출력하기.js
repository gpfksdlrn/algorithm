function solution(my_string, n) {
    const arr = Array.from(my_string);
    let answer = '';
    for (let i = 0; i < arr.length; i++){
        for (let j = 0; j < n; j++) {
            answer += arr[i];
        }
    }
    return answer;
}