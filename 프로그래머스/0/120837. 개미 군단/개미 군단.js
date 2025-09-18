/**
    장군개미 공격력: 5
    병정개미 공격력: 3
    일개미 공격력: 1
*/
function solution(hp) {
    const antAttack = [5, 3, 1];
    
    return antAttack.reduce((totalAnts, attack) => {
        totalAnts += Math.floor(hp/attack);
        hp %= attack;
        return totalAnts;
    }, 0)
}