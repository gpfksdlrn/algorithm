/*
    선택 가능한 마리 수 (nums.length / 2)
    중복되지 않은 종류의 수 (new Set(nums).size)
    선택할 수 있는 최대 종류의 수는 둘 중 작은 값
*/

function solution(nums) {
    return Math.min(nums.length / 2, new Set(nums).size);
}