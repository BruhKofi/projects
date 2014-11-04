function ArrayQueue() {
    this.a = [];
}

ArrayQueue.prototype = {
    enqueue: function(data) {
        this.a.push(data);
    },

    dequeue: function() {
        return this.a.shift();
    },

    size: function() {
        return this.a.length;
    },

    isEmpty: function() {
        return this.a.length === 0;
    },
};

var q = new ArrayQueue();
for (var i = 0; i<10; i++) {
    q.enqueue(i);
}

while (!q.isEmpty()) {
    var k = q.dequeue();
    console.log(k);
}

    
    
