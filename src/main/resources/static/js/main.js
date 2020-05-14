console.log("hello world");

const status = document.querySelectorAll('.content__item--status-js');

console.log(status);

for (let elem of status) {
    elem.style.fontWeight = 'bold';
    if(elem.innerHTML === 'Watching') {
        elem.style.color = '#BF1A2F';
    }
    else if (elem.innerHTML === 'Completed') {
        elem.style.color = '#018E42';
    }
    else if (elem.innerHTML === 'Plan to Watch') {
        elem.style.color = '#084C61';
    }
    else {
        console.log("Another status");
    }
}
