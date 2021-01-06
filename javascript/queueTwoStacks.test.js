/*
 * * A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest elements to be removed from the front and new elements to be added to the rear. This is called a First-In-First-Out (FIFO) data structure because the first element added to the queue (i.e., the one that has been waiting the longest) is always the first one to be removed.

* * A basic queue has the following operations:

* * Enqueue: add a new element to the end of the queue.
* * Dequeue: remove the element from the front of the queue and return it.
* * In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:

* * 1 x: Enqueue element  into the end of the queue.
* * 2: Dequeue the element at the front of the queue.
* * 3: Print the element at the front of the queue.
*/
class Queue {

    constructor() {
        this.firstStack = []
        this.secondStack = []
    }

    enqueue(value) {
        this.firstStack.push(value)
    }

    dequeue() {
        this.combineStacks()
        this.secondStack.pop()
    }

    combineStacks() {
        if (this.secondStack.length === 0) {
            while (this.firstStack.length > 0) {
                this.secondStack.push(this.firstStack.pop())
            }
        }
    }

    head() {
        this.combineStacks()
        let head = this.secondStack.pop()
        this.secondStack.push(head)
        return head
    }
}

function processData(input) {
    const queue = new Queue()
    const result = []
    const array = input.split('\n')
    array.shift()
    for (const query of array) {
        const [type, value] = query.split(' ')
        switch (type) {
            case '1':
                queue.enqueue(value)
                break
            case '2':
                queue.dequeue()
                break
            case '3':
                result.push(queue.head())
        }
    }
    return result
}

//----- Test Cases ---//
test(`a queu with 10\m1 42\n2\n1 14\n3\n1 28\n3\n1 60\n1 78\n2\n2
    should return [14,14]`, () => {
    let result = processData('10\m1 42\n2\n1 14\n3\n1 28\n3\n1 60\n1 78\n2\n2')
    expect(result).toStrictEqual(['14', '14'])
});