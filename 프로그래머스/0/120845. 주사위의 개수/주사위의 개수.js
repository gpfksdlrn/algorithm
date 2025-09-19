// 직육면체 모양의 상자, 정육면체의 주사위
// 상자의 길이는 3, box[0] - 가로, box[1] - 세로, box[2] - 높이
// n = 주사위 모서리의 길이
function solution(box, n) {
    const lengths = [...box];
    
    return lengths.reduce((count, length)=> {
        count *= Math.floor(length/n);
        return count;
    }, 1);
}