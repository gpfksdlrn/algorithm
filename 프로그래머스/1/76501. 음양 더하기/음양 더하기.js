function solution(absolutes, signs) {
    let index = 0;
    let sum = 0;

    for(index = 0; index < absolutes.length; index++) {
       sum += absolutes[index] * (signs[index]? 1 : -1);
    }
    
    return sum;
}