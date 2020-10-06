/**
 * https://www.codewars.com/kata/525c65e51bf619685c000059
 * Pete, the baker
 * Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is not good in maths. Can you help him to find out, how many cakes he could bake considering his recipes?
 * 
 * Write a function cakes(), which takes the recipe (object) and the available ingredients (also an object) and returns the maximum number of cakes Pete can bake (integer). For simplicity there are no units for the amounts (e.g. 1 lb of flour or 200 g of sugar are simply 1 or 200). Ingredients that are not present in the objects, can be considered as 0.
 * 
 * Examples:
 *  --- must return 2
 * cakes({flour: 500, sugar: 200, eggs: 1}, {flour: 1200, sugar: 1200, eggs: 5, milk: 200}); 
 *  --- must return 0
 * cakes({apples: 3, flour: 300, sugar: 150, milk: 100, oil: 100}, {sugar: 500, flour: 2000, milk: 2000}); 
 * 
 */

function cakes(recipe, ingredients) {
    let cakes = 0;
    for (const [k, v] of Object.entries(recipe)) {
        if (ingredients[k] > 0) {
            cakes = cakes === 0 ? Math.floor(ingredients[k] / v) :
                Math.min(Math.floor(ingredients[k] / v), cakes);
        }
        else {
            return 0;
        }
    }
    return cakes;
}

//----- Test Cases ---//
test(" numbers of cakes of {flour: 500, sugar: 200, eggs: 1} with {flour: 1200, sugar: 1200, eggs: 5, milk: 200} ", () => {
    expect(cakes({
        flour: 500,
        sugar: 200,
        eggs: 1
    }, {
        flour: 1200,
        sugar: 1200,
        eggs: 5,
        milk: 200
    })).toStrictEqual(2);
});

test(" numbers of cakes of {apples: 3, flour: 300, sugar: 150, milk: 100, oil: 100} with {sugar: 500, flour: 2000, milk: 2000} ", () => {
    expect(cakes({
        apples: 3,
        flour: 300,
        sugar: 150,
        milk: 100,
        oil: 100
    }, {
        sugar: 500,
        flour: 2000,
        milk: 2000
    })).toStrictEqual(0);
});