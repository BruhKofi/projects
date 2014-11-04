var numbers = [];
for (var i = 1; i<=10; i++) {
    numbers.push(i);
}

var filtered = numbers.filter(function(num) {
    return num % 2 === 0;
});

console.log(filtered);
