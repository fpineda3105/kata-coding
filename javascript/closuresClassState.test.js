let Cat = (function () {
    const cats = []
  
    const constructor = function (name, weight) {
      if (!name || !weight) throw Error('invalid parameters')
      Object.defineProperty(this, 'name', { get: () => name })
      Object.defineProperty(this, 'weight', { get: () => weight, set: value => weight = value })
      cats.push(this)
    }
  
    constructor.averageWeight = () => cats.reduce((acc, cat) => (acc + cat.weight), 0) / cats.length
  
    return constructor
  }())

  //----- Test Cases ---//
test('various tests', () => {
    let fluffy = new Cat('fluffy', 15);
    let garfield = new Cat('garfield', 25);
    expect(fluffy.weight).toStrictEqual(15);
    expect(garfield.weight).toStrictEqual(25);
    expect(garfield.averageWeight).toStrictEqual(undefined);
    expect(typeof Cat.averageWeight).toStrictEqual("function")
    expect(Cat.averageWeight()).toStrictEqual(20)
});