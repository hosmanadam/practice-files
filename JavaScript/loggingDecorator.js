const DEBUG = true;
const SCRIPT_NAME = 'test-script';


// LOGGING ////////////////////////////////////////////////////////////////////

const log = (msg) => {
    console.log(`[${SCRIPT_NAME}] INFO - ${msg}`);
}

const err = (ex) => {
    console.log(`[${SCRIPT_NAME}] ERROR - ${ex}`);
}

const callWithLogging = (fun, args) => {
    log(`calling: ${fun.name}(${args.join(', ')})`);
    let result = fun(...args);
    log(`${fun.name} returned: ${result}`);
    return result;
}

const tryCallWithLogging = (fun, args) => {
    try {
        return callWithLogging(fun, args);
    } catch (ex) {
        err(ex);
    }
}

/** Decorates the passed function with before-after logging behavior. */
const logged = (fun) => {
    return (...args) => {
        if (DEBUG) {
            return tryCallWithLogging(fun, args);
        } else {
            return fun(...args);
        }
    }
}


// BUSINESS LOGIC /////////////////////////////////////////////////////////////

const adder = (a, b) => logged(function adder(a, b) {
    result = a + b;
    console.log('a + b = ' + result);
    return result;
})(a, b)

adder(2, 2);
