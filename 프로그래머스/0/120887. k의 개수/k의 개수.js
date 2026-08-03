function solution(i, j, k) {
    const numbers = Array.from({length: j - i + 1}, (_, idx) => i + idx).join("");
    return numbers.split(k).length - 1;
}