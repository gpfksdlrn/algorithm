// 아메리카노 한잔에 5500원
// 최대로 마실 수 있는 아메리카노의 잔 수와 남는 돈을 담은 배열을 return
function solution(money) {
    const coffeeCost = 5500;
    const count = Math.floor(money / coffeeCost);
    const remainingAmount = money % coffeeCost;
    
    return [count, remainingAmount]
}