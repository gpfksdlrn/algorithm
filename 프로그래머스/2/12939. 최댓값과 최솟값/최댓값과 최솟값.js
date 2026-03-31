// 최소값 최대값 
function solution(s) {
    const arr = s.split(' ');
    
    let min = Number(arr[0]);
    let max = Number(arr[0]);

    for (let i = 0; i < arr.length; i++) {
        const num = Number(arr[i]);
        if (max < num) max = num;
        if (min > num) min = num;
        
    }
    return `${min} ${max}`;
}