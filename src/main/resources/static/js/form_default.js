//한국시간으로 맞추기
const offset = 1000 * 60 * 60 * 9;

let dateDf= new Date((new Date()).getTime() + offset);
dateDf.setHours(dateDf.getHours() + 1);
document.getElementById('tempt3').value= dateDf.toISOString().slice(0, 16);

let closeTimeDf = new Date((new Date()).getTime() + offset);
closeTimeDf.setMinutes(closeTimeDf.getMinutes() + 50);
document.getElementById('tempt8').value= closeTimeDf.toISOString().slice(0, 16);