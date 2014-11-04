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

    head: function() {
        return this._first;
    },

    print: function() {
        for (var x = this._first; x != null; x = x.next) {
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

};

var list = new LinkedList();
for (var i = 5; i>=0; i--) list.add(i);
list.print();
list.reverse();
console.log();
list.print();
