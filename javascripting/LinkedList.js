function LinkedList() {
    this._first = null;
    this._length = 0;
}

LinkedList.prototype = {
    add: function(data) {
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
        

    head: function() {
        return this._first;
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

var list = new LinkedList();
for (var i = 5; i>=0; i--) list.add(i);
list.print();
list.reverse();
console.log();
list.print();
list.del(4);
console.log();
list.print();
console.log();
while (!list.empty()) {
    console.log(list.pop());
}


//module.exports = LinkedList;
//module.exports = LinkedList.prototype;
