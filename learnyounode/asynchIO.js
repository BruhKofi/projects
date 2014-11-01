var http = require('http');

var urls = process.argv.slice(2);

function getData(urls) {
    if (!urls || !urls.length) return;
    var url = urls[0];
    var txt = '';
    http.get(url, function(resp) {
        resp.setEncoding('utf8');
        resp.on('data', function(chunk) {
            txt += chunk;
        });
        resp.on('error', console.error);
        resp.on('end', function() {
            console.log(txt);
            urls.shift();
            getData(urls);
        });
    });
};
getData(urls);
