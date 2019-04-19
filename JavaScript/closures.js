// This demonstrates that a closure keeps references from its outer context
// after that's gone
function greet(greeting) {
    return function(name) {
        console.log(greeting + ' ' + name);
    }
}

// greet('Hi')('Adam');
let sayHi = greet('Hi');
sayHi('Adam');


// This demonstrates that a closure remembers its outer references as they were
// when the closure was returned, not when it was defined
// "If you ask 3 children how old their father is, they're going to say the
// same thing, not how old he was when each of them were born"
// - https://youtu.be/S_mQVH8TIoI
function buildFunctions() {
    var arr = [];
    for (var i = 0; i< 3; i++) {
        arr.push(
            () => console.log(i)
        )
    }
    return arr;
}

var fs = buildFunctions();

fs[0](); // 3
fs[1](); // 3
fs[2](); // 3


// To fix the value at the time of defining the closure, declare it as a
// block-scope variable
function buildFunctions2() {
    var arr = [];
    for (var i = 0; i< 3; i++) {
        let j = i;
        arr.push(
            () => console.log(j)
        )
    }
    return arr;
}

var fs2 = buildFunctions2();

fs2[0](); // 0
fs2[1](); // 1
fs2[2](); // 2


// Or use `let` in the loop so it gets redeclared in each block
function buildFunctions3() {
    var arr = [];
    for (let i = 0; i< 3; i++) {
        arr.push(
            () => console.log(i)
        )
    }
    return arr;
}

var fs3 = buildFunctions3();

fs3[0](); // 0
fs3[1](); // 1
fs3[2](); // 2


// Or create and execute a "butler-function" that creates its own context
// that closes the closure before it's even returned from the outer function
function buildFunctions4() {
    var arr = [];
    for (var i = 0; i< 3; i++) {
        arr.push(
            ( (j) => () => console.log(j) )(i)
        )
    }
    return arr;
}

var fs4 = buildFunctions4();

fs4[0](); // 0
fs4[1](); // 1
fs4[2](); // 2
