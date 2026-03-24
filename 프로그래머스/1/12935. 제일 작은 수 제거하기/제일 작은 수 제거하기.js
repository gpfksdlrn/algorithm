// arr에서 가장 작은 수를 제거한 배열을 리턴
// 단, 리턴하는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴
function solution(arr) {
    if (arr.length <= 1) return [-1];
    const min = Math.min(...arr);
    return arr.filter(num => num !== min);
}