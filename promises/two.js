var q = require('q');
var defer = q.defer();

function printError(error) {
    console.log(error.message);
};

defer.promise.then(null, printError);

setTimeout(function() {
    defer.reject(new Error('REJECTED!'))
    }, 300);
