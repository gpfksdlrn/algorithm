function solution(strArr) {
    return strArr.map((str, idx) => {
        return idx % 2 === 0 ? str.toLowerCase() : str.toUpperCase()
    })
}