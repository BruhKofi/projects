var concat = require('concat-stream');
var http = require('http');

process.stdin
    .pipe(concat(function(text) {
        text = text.toString().split('').reverse().join('');
        console.log(text);
    }));
