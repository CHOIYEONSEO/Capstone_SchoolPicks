let date = new Date();
date.setHours(date.getHours() + 1);
document.getElementById('tempt3').value= date.toISOString().slice(0, 16);

let closeTime = new Date();
closeTime.setMinutes(closeTime.getMinutes() + 50);
document.getElementById('tempt8').value= closeTime.toISOString().slice(0, 16);