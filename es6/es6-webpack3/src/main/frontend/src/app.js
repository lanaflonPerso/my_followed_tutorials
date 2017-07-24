function *createIterator() {
    yield 1;
    yield 2;
    yield 3;
    yield 4;
}
// generators are called like regular functions but return an iterator
let iterator = createIterator();
console.log(iterator.next().value); // 1
console.log(iterator.next().value); // 2
console.log(iterator.next().value);
console.log(iterator.next().value);
