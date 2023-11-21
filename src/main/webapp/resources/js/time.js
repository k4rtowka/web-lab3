let date = document.getElementById("date");
let time = document.getElementById("time");
let dateState = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    weekday: 'long',
    timezone: 'UTC',
};
let timeState = {
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric'
}

date.innerHTML = new Date().toLocaleDateString("ru", dateState);
time.innerHTML = new Date().toLocaleTimeString("ru", timeState);


// Обновление часов каждые 9 секунд
setInterval(() => {
    date.innerHTML = new Date().toLocaleDateString("ru", dateState);
    time.innerHTML = new Date().toLocaleTimeString("ru", timeState);
}, 9000)