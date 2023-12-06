//한국시간으로 맞추기
const offset = 1000 * 60 * 60 * 9;

let date = new Date((new Date()).getTime() + offset);
date.setHours(date.getHours() + 1);
document.getElementById('tempt3').value= date.toISOString().slice(0, 16);

let closeTime = new Date((new Date()).getTime() + offset);
closeTime.setMinutes(closeTime.getMinutes() + 50);
document.getElementById('tempt8').value= closeTime.toISOString().slice(0, 16);