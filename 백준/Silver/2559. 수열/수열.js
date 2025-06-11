const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, K] = input[0].split(" ").map(Number);
const temps = input[1].split(" ").map(Number);

let currentSum = 0;

// 초기 K일 합 구하기
for (let i = 0; i < K; i++) {
  currentSum += temps[i];
}

let maxSum = currentSum;

// 슬라이딩 윈도우 이동하며 최대합 찾기
for (let i = K; i < N; i++) {
  currentSum = currentSum - temps[i - K] + temps[i];
  if (currentSum > maxSum) {
    maxSum = currentSum;
  }
}

console.log(maxSum);