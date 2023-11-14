var nav1Container = document.getElementById("nav1Container");
if (nav1Container) {
    nav1Container.addEventListener("click", function (e) {
        window.location.href = "./menu_recommendation_HSSC.html";
    });
}

var nav2Container = document.getElementById("nav2Container");
if (nav2Container) {
    nav2Container.addEventListener("click", function (e) {
        window.location.href = "./find-mate-.html";
    });
}

var nav3Container = document.getElementById("nav3Container");
if (nav3Container) {
    nav3Container.addEventListener("click", function (e) {
        window.location.href = "./reviewver2.html";
    });
}

// go to detal
var menuNavContainer = document.getElementById("movedetail");
if (menuNavContainer) {
    menuNavContainer.addEventListener("click", function (e) {
        window.location.href = "./menu.html";
});
}

// go back to menu
var menuNavContainer = document.getElementById("menuNavContainer");
if (menuNavContainer) {
    menuNavContainer.addEventListener("click", function (e) {
        window.location.href = "./menu.html";
});
}