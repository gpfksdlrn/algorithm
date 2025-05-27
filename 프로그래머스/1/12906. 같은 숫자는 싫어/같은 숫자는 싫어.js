function solution(arr)
{
  return arr.filter((value, index) => 
  index === 0 || value !== arr[index - 1]);
}