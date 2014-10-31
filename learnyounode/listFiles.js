var fs = require('fs');

var path = process.argv[2];
var ext = process.argv[3];

fs.readdir(path, function(err, data) {
    if (err) {
        throw err;
    }
    //We could print the list without modifying it with filer
    data = data.filter(function(name) {
        return (name.split('.')[1] === ext);
    });
    //passing console.log directly to forEach doesn't work
    data.forEach(function(e) {
        console.log(e);
    });
});
