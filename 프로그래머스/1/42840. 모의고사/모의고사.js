// 수포자1 = [1,2,3,4,5]
// 수포자2 = [2,1,2,3,2,4,2,5]
// 수포자3 = [3,3,1,1,2,2,4,4,5,5]
// 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
// 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요
// 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

function solution(answers) {
    const patterns = [
        [1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]
    ];
    
    const scores = patterns.map(pattern => {
        return answers.filter((answer, index) => {
            return answer === pattern[index % pattern.length];
        }).length;
    });
    
    const maxScore = Math.max(...scores);
    
    const result = scores
        .map((score, index) => score === maxScore? index + 1: null)
        .filter(value => value !== null);
    
    return result
}