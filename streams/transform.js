var through = require('through');

//Pipe StdIn to StdOut
process.stdin
    .pipe(through(function(buff) {
        //uppercase the buffer as we go
        this.queue(buff.toString().toUpperCase());
    }), function(){})
    .pipe(process.stdout);

