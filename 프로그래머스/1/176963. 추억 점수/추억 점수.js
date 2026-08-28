function solution(name, yearning, photo) {
    const score = new Map();
    
    name.forEach((person, i) => {
        score.set(person, yearning[i]);
    });
    
    return photo.map((people) => {
        let sum = 0;
        
        for (const person of people) {
            sum += score.get(person) ?? 0;
        }
        
        return sum;
    })
}