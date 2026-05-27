function solution(binomial) {
    const [a, op, b] = binomial.split(' ');

    const numA = Number(a);
    const numB = Number(b);
    
    switch(op) {
        case '+': return numA + numB;
        case '-': return numA - numB;
        case '*': return numA * numB;
    }
}