var net = require('net');
var port = parseInt(process.argv[2]);

function zeroPad(i) {
    if (i < 10) return '0' + i;
    else return i;
}

function currTime () {
    var d = new Date()
    return d.getFullYear() + '-'
        + zeroPad(d.getMonth() + 1) + '-'
        + zeroPad(d.getDate()) + ' '
        + zeroPad(d.getHours()) + ':'
        + zeroPad(d.getMinutes())
}

var server = net.createServer(function(socket) {
    socket.end(currTime() + '\n');
}).listen(port);

