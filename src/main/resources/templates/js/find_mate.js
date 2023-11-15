var groupContainer8 = document.getElementById("groupContainer8");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./find-mate-ver1.html";
    });
}

//temp for sharing: find-mate-ver1
var groupContainer8 = document.getElementById("insta1");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver1-instagram-story.html";
    });
}

//temp for sharing: find-mate-ver2
var groupContainer8 = document.getElementById("insta2");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver2-instagram-story.html";
    });
}

//temp for sharing: find-mate-ver2
var groupContainer8 = document.getElementById("insta3");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver3-instagram-story.html";
    });
}

//temp for sharing: 수정하기
var groupContainer8 = document.getElementById("edit");
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        var editpass1 = prompt('비밀번호를 입력하시오',"게시글 수정 비밀번호를 입력하세요");
        if(!editpass1) { //취소 눌렀을때
        }
        if(editpass1.toLowerCase() == "1398") { //1398로 암호지정하면
            window.location.href = "./find-mate-.html";
        }
    });
}