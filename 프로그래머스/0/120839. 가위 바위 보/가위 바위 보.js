// 가위: 2 / 바위: 0 / 보: 5
function solution(rsp) {
    return rsp.split('').map(char => {
        if (char === '2') return '0';
        else if (char === '0') return '5';
        else if (char === '5') return '2';
    }).join('');
}