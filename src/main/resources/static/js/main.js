console.log("hello world");

var status = document.querySelectorAll('.content__item--status-js');

for(var i = 0; i < status.length; i++){
    console.log(status[i].innerHTML);
    if( status[i].innerHTML === 'Watching') {
        status[i].style.color = '#BF1A2F';
        console.log('ten sam color');
    }
}
