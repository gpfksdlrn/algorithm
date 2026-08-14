function solution(x) {
    const sum = String(x)
        .split('')
        .map(Number)
        .reduce((sum, num) => sum + num, 0);

    return x % sum === 0;
}