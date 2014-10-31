//Grab command line arguments as array
var nums = Array.prototype.slice.call(process.argv, 2);

//Sum array (treat entries as Numbers)
function sum(a) {
    return a.reduce(function(b, c) {
        return Number(b) + Number(c);
    });
}

console.log(sum(nums));
