// 참여한 선수들의 이름이 담긴 배열 = participant
// 단 한 명의 선수를 제외한 완주한 선수들의 이름이 담긴 배열 = completion
// return -> 완주하지 못한 선수의 이름
function solution(participant, completion) {
    const map = new Map();
    
    // 참가자들 카운팅
    participant.forEach(name => {
        map.set(name, (map.get(name) || 0) + 1);
    });
    
    // 완주자들 차감
    completion.forEach(name => {
        map.set(name, map.get(name) - 1);
    });
    
    for (let [name, count] of map) {
        if(count === 1) return name;
    }
}