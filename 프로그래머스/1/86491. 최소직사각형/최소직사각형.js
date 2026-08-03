function solution(sizes) {
    const [w, h] = sizes
        .map(([w, h]) => [
            Math.max(w, h),
            Math.min(w, h)
        ])
        .reduce(([maxW, maxH], [w, h]) => [
            Math.max(maxW, w), Math.max(maxH, h)
        ]);
    
    return w * h;
}