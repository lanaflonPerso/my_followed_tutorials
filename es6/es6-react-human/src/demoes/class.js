console.log("Class Methods and Accessor Properties");
class AeroPlane1 {
    constructor(model, capacity) {
        this._model = model;
        this._capacity = capacity;
    }

    get model() {
        return this._model;
    }

    get capacity() {
        return this._capacity;
    }

    set model(model) {
        this._model = model;
    }

    set capacity(capacity) {
        this._capacity = capacity;
    }
}

{
    const jet = new AeroPlane1('Jet', 100);
    console.log(jet.model);
    console.log(jet.capacity);
    console.log(Object.getOwnPropertyDescriptor(AeroPlane1.prototype, 'model'));
}

console.log("Class Methods and Accessor Properties...end");
console.log('Using Constructor Environments...');

class AeroPlane2 {
    constructor(capacity) {
        this.checkCapacity = function (value) {
            return capacity >= value;
        }
    }
}

{
    const jet = new AeroPlane2(200);
    console.log(jet.checkCapacity(100)); // true
    console.log(jet.capacity);
}
console.log('Using Constructor Environments...end');
