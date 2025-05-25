// 참여한 선수들의 이름이 담긴 배열 = participant
// 단 한 명의 선수를 제외한 완주한 선수들의 이름이 담긴 배열 = completion
// return -> 완주하지 못한 선수의 이름
function solution(participant, completion) {
  participant.sort();
  completion.sort();

  for (let i = 0; i < completion.length; i++) {
      if(participant[i] !== completion[i]) {
         return participant[i];
     }
  }

  // 마지막 참가자가 완주하지 못한 경우
  return participant[participant.length - 1];
}