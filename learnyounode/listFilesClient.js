var ls = require('./listFilesModule');

var dir = process.argv[2];
var ext = process.argv[3];

var fileList = ls(dir, ext, function(err, data) {
    if (err) {
        console.error("Error! " + err);
    }
    fileList = data;
    fileList.forEach(function(file) {
        console.log(file);
    })
})

