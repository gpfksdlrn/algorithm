
function solution(arr, delete_list) {
    const setDelete_list = new Set(delete_list);
    return arr.filter(num => !setDelete_list.has(num));
}