let [a, b] = [5, 10];

let promiseALargerThanB = new Promise((resolve, reject) => {
    if (a > b) {resolve(true)}
    else {resolve(false)}
}).then((result) => console.log(`Promise result in: A is${result ? ' ' : ' not '}larger than B!`));

console.log('Promise made, with no inherently async processes inside.');
console.log('Meanwhile, let\'s print stuff...');
console.log('At one point, promise should run its callback. Call stack empty now.');
