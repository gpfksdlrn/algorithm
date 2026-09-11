function solution(N, stages) {
    const result = [];
    const count = Array(N + 2).fill(0);
    
    stages.forEach(stage => {
        count[stage]++;
    });
    
    let total = stages.length;
    
    for (let stage = 1; stage <= N; stage++) {
        const failedPlayers = count[stage];
        const failRate = total === 0 ? 0 : failedPlayers / total;
        
        result.push({
            stage,
            failRate
        });
        
        total -= failedPlayers;
    }
    
    result.sort((a, b) => {
        if (a.failRate === b.failRate) {
            return a.stage - b.stage;
        }
        
        return b.failRate - a.failRate;
    });
    
    return result.map(v => v.stage);
}