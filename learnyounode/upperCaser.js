var http = require('http');
var map = require('through2-map');

var server = http.createServer(function(req, resp) {
    if (req.method != 'POST') return resp.end('I need a POST');
    //Convert incoming data to uppercase and return it to the client
    req.pipe(map(function(data) {
        return data.toString().toUpperCase();
    })).pipe(resp);
}).listen(parseInt(process.argv[2]));
