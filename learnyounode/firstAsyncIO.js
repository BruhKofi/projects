var fs = require('fs');

var path = process.argv[2];

var lineCount = fs.readFile(path, 'utf8', function(err, buff) {
    if (err) throw err;
    console.log(buff.split('\n').length-1);//Log the line count to the console
});
