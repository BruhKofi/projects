var fs = require('fs');

var path = process.argv[2];

var lineCount = fs
    .readFileSync(path, 'utf8')//read file with utf8 encoding
    .split('\n')//Split on newlines
    .length-1;//subtract 1 for last line

console.log(lineCount);
