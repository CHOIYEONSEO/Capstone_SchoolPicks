

var groupContainer8 = document.getElementById("groupContainer8");
/*if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./find-mate-ver1.html";
    });
}*/

//temp for sharing: find-mate-ver1
var groupContainer8 = document.getElementById("insta1");
/*
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver1-instagram-story.html";
    });
}
*/

//temp for sharing: find-mate-ver2
var groupContainer8 = document.getElementById("insta2");
/*
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver2-instagram-story.html";
    });
}
*/

//temp for sharing: find-mate-ver2
var groupContainer8 = document.getElementById("insta3");
/*
if (groupContainer8) {
    groupContainer8.addEventListener("click", function (e) {
        window.location.href = "./ver3-instagram-story.html";
    });
}
*/

//button for clipboard href -> need to make button for clip board
var groupContainer9 = document.getElementById("clipbutton");
if (groupContainer9) {
    groupContainer9.addEventListener("click", function (e) {
        var linkToCopy = window.location.href; // 현재 페이지의 링크를 가져옴
        navigator.clipboard.writeText(linkToCopy).then(function() {
            alert('링크가 클립보드에 저장되었습니다.');
        }).catch(function(err) {
            console.error('클립보드 저장 실패: ', err);
        });
    });
}

var containerVer2 = document.getElementById("editVer2");
var editVer2Form = document.getElementById("editVer2Form");
var passwordVer2 = document.getElementById("passwordVer2").innerText;
if (containerVer2) {
    containerVer2.addEventListener("click", function(e) {
        console.log("click")
        var editpass2 = prompt('비밀번호를 입력하시오',"게시글 수정 비밀번호를 입력하세요");
        if(!editpass2) { //취소 눌렀을때
        }
        if(editpass2.toLowerCase() == passwordVer2){
            editVer2Form.submit();
        }
    });
}

function clickCheck(target) {
    document.querySelectorAll(`input[type=checkbox]`)
        .forEach(el => el.checked = false);

    target.checked = true;
}

/*
var ver1Select = document.getElementById("ver1_select");
var ver2Select = document.getElementById("ver2_select");
var ver3Select = document.getElementById("ver3_select");
var ver4Select = document.getElementById("ver4_select");
if (ver1Select) {
    ver1Select.addEventListener("click", function (e) {
        this.style.background = 'rgba(220, 232, 228, 0.4)';
        ver2Select.style.background = 'none';
        ver3Select.style.background = 'none';
        ver4Select.style.background = 'none';
    });
}

if (ver2Select) {
    ver2Select.addEventListener("click", function (e) {
        this.style.background = 'rgba(220, 232, 228, 0.4)';
        ver1Select.style.background = 'none';
        ver3Select.style.background = 'none';
        ver4Select.style.background = 'none';
    });
}

if (ver3Select) {
    ver3Select.addEventListener("click", function (e) {
        this.style.background = 'rgba(220, 232, 228, 0.4)';
        ver1Select.style.background = 'none';
        ver2Select.style.background = 'none';
        ver4Select.style.background = 'none';
    });
}

if (ver4Select) {
    ver4Select.addEventListener("click", function (e) {
        this.style.background = 'rgba(220, 232, 228, 0.4)';
        ver1Select.style.background = 'none';
        ver2Select.style.background = 'none';
        ver3Select.style.background = 'none';
    });
}
*/