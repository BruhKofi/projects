function Stack() {
    this._first = null;
    this._length = 0;
}

Stack.prototype = {
    push: function(data) {
        var node = {
            data: data,
            next: null
        };

        if (this._length === 0) {
            this._first = node;
        } else {
            node.next = this._first;
            this._first = node;
        }
        this._length++;
    },

    pop: function() {
        if (this._length === 0) throw "List underflow";
        var node = this._first.data;
        this._first = this._first.next;
        this._length--;
        return node;
    },
        
    print: function() {
        for (var x = this._first; x !== null; x = x.next) {
            console.log(x.data);
        }
    },

    reverse: function() {
        var first = this._first;
        var rev = null;
        while (first !== null) {
            var sec = first.next;
            first.next = rev;
            rev = first;
            first = sec;
        }
        this._first = rev;
    },

    del: function(data) {
        if (this._length === 0) throw "List underflow";
        if (this._first.data === data) {
            this._length--;
            this._first = this._first.next;
            return;
        }
        for (var x = this._first; x !== null; x = x.next) {
            if (x.next && x.next.data === data) {
                x.next = x.next.next;
                this._length--;
                return;
            }
        }
        throw "No such element";
    },

    empty: function() {
        return this._length === 0;
    },
        
};

var stack = new Stack();
for (var i = 5; i>=0; i--) stack.push(i);
stack.print();
stack.reverse();
console.log();
stack.print();
stack.del(4);
console.log();
stack.print();
console.log();
while (!stack.empty()) {
    console.log(stack.pop());
}


//module.exports = LinkedList;
//module.exports = LinkedList.prototype;
