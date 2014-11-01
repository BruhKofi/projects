var fs = require('fs');
var http = require('http');

var server = http.createServer(function(req, resp) {
    resp.writeHead(200, {'content-type': 'text/plain'});
    fs.createReadStream(process.argv[3]).pipe(resp);
}).listen(parseInt(process.argv[2]));
