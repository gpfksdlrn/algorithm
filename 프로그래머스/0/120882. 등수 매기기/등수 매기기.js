function solution(score) {
    const totals = score.map(([eng, math]) => eng + math);
    
    return totals.map(
        (current) => totals.filter((other) => other > current).length + 1
    );
}