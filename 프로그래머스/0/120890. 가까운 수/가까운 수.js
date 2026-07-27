function solution(array, n) {
    return array.reduce((answer, num) => {
        const diff = Math.abs(num - n);
        const answerDiff = Math.abs(answer - n);

        if (diff < answerDiff) return num;
        if (diff === answerDiff && num < answer) return num;
        return answer;
    });
}