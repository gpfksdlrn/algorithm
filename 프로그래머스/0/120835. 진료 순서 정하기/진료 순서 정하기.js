function solution(emergency) {
    const sorted = [...emergency].sort((a, b) => b - a);
    
    return emergency.map(a => sorted.indexOf(a) + 1);
}