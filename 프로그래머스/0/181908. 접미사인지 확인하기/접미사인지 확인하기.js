function solution(my_string, is_suffix) {
    const len = is_suffix.length;
    return Number(my_string.slice(-len) === is_suffix);
}