var split = require('split');
var through = require('through');
var cnt = 0;

process.stdin
    .pipe(split())
    .pipe(through(function(buff) {
        this.queue((cnt++ % 2 ? buff.toString().toUpperCase() : buff.toString().toLowerCase()) + '\n');
    }))
    .pipe(process.stdout);
