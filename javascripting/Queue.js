function Queue() {
    this._first = null;
    this._last = null;
    this._length = 0;
}

Queue.prototype = {
    enqueue: function(data) {
        var node = {
            data: data,
            next: null
        };
        var oldLast = this._last;
        this._last = node;
        if (this._length === 0) this._first = this._last;
        else oldLast.next = this._last;
        this._length++;
    },

    dequeue: function() {
        if (this._length === 0) throw "Queue underflow";
        var data = this._first.data;
        this._first = this._first.next;
        this._length--;
        return data;
    },

    size: function() {
        return this._length;
    },

    isEmpty: function() {
        return this._length === 0;
    },

    //Should implement a forEach method or some kind of iterator
    print: function() {
        for (var x = this._first; x != null; x = x.next) {
            console.log(x.data);
        }
    }
};

var q = new Queue();
for (var i = 0; i<10; i++) {
    q.enqueue(i);
}

while (!q.isEmpty()) {
    var k = q.dequeue();
    console.log(k);
}        
