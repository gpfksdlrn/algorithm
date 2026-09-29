// 인정 시각 계산 함수
function getLimitTime(time) {
    let hour = Math.floor(time / 100);
    let minute = time % 100;

    minute += 10;

    if (minute >= 60) {
        hour += 1;
        minute -= 60;
    }

    return hour * 100 + minute;
}

function solution(schedules, timelogs, startday) {
    const limits = schedules.map(getLimitTime);
    let count = 0;
    
    for (let i = 0; i < timelogs.length; i++) {
        let isOnTime = true;
        
        for (let j = 0; j < 7; j++) {
            const day = (startday + j - 1) % 7 + 1;
            
            // 주말은 검사하지 않음
            if (day === 6 || day === 7) {
                continue;
            }
            
            // 평일에 지각하면 탈락
            if (timelogs[i][j] > limits[i]) {
                isOnTime = false;
                break;
            }
        }
        
        if(isOnTime) {
            count++;
        }
    }
    
    return count;
}

