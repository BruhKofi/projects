var http = require('http');

var url = process.argv[2];

http.get(url, function(resp) {
    var text = '';
    resp.setEncoding('utf8');
    resp.on('data', function(data) {
        text += data;
    });
    resp.on('error', console.error);
    resp.on('end', function() {
        console.log(text.length);
        console.log(text);
    });
});
        

    
