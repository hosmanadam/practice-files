function enumerate(elements) {
    let result = [];
    elements.forEach(function(item, i) {
        result.push([i, item]);
    });
    return result;
}


function binarySearch(collection, target) {

    function inner(collection, target) {
        if (collection.length === 0) {
            return false;
        }
        let middleIndex = parseInt(collection.length/2);
        let candidate = collection[middleIndex];
        if (candidate[1] === target) {
            return candidate[0];
        }
        if (candidate[1] > target) {
            return inner(collection.slice(0, middleIndex), target);
        }
        if (candidate[1] < target) {
            return inner(collection.slice(middleIndex+1), target);
        }
    }

    return inner(enumerate(collection), target);
}


// TEST
let myList = [...Array(10000).keys()];
console.log(binarySearch(myList, 5555));
