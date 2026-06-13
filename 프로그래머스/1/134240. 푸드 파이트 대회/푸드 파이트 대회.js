function solution(food) {
    let left = '';
    
    for (let i = 1; i < food.length; i++) {
        left += String(i).repeat(Math.floor(food[i] / 2));
    }
    
    const right = left.split('').reverse().join('');
    
    return left + '0' + right;
}