function solution(myStr) {
    const answer = myStr
        .replaceAll("a", " ")
        .replaceAll("b", " ")
        .replaceAll("c", " ")
        .split(" ")
        .filter(Boolean);
    return answer.length ? answer : ["EMPTY"];
}