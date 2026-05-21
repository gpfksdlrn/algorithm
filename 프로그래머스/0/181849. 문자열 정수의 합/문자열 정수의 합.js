function solution(num_str) {
    return [...num_str].reduce((sum, num) => 
        sum += Number(num), 0
    )
}