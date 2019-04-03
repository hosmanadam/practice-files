const greetings = {
    hello: 'Hello!',
    hi: 'Hi!',
    hiThere: 'Hi there!',
}

function sayHi() {console.log(this.hi)};  // Function declaration: binds
// const sayHi = function() {console.log(this.hi)};  // Function expression: binds
// const sayHi = () => console.log(this.hi);  // Arrow function: won't bind

sayHi()  // Logs `undefined`
sayHi.bind(greetings)() // Logs 'Hi!' (Behaves like a method on `greetings`)
