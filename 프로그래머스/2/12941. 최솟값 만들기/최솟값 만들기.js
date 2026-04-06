function solution(A, B) {
    A.sort((a, b) => a - b);
    B.sort((a, b) => b - a);
    
    return A.reduce((sum, val, i) => sum + val * B[i], 0)
}