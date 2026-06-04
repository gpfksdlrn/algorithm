function solution(arr) {
    return arr.reduce((acc, v) => {
        acc.push(...Array(v).fill(v));
        return acc;
    },[])
}