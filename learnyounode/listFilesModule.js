var fs = require('fs');

module.exports = function(dir, ext, callback) {
    fs.readdir(dir, function(err, data) {
        if (err) return callback(err);
        data = data.filter(function(name) {
            return name.split('.')[1] === ext;
        })
        callback(null, data);
    })
}
