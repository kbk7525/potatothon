window.addEventListener('scroll', function() {
    var scrollPosition = window.scrollY;
    var topNav = document.querySelector('.main_top_back > .top_nav');

    if (scrollPosition > 200) { // 스크롤 멈추기를 원하는 위치의 값
        topNav.style.position = 'static'; // 스크롤 위치가 특정 값 이상이면 sticky 해제
    } else {
        topNav.style.position = 'sticky'; // 특정 값 미만이면 다시 sticky로 설정
    }
});
window.addEventListener('scroll', function() {
    var scrollPosition = window.scrollY;
    var topNav = document.querySelector('.edu_top_back > .top_nav');

    if (scrollPosition > 100) { // 스크롤 멈추기를 원하는 위치의 값
        topNav.style.position = 'static'; // 스크롤 위치가 특정 값 이상이면 sticky 해제
    } else {
        topNav.style.position = 'sticky'; // 특정 값 미만이면 다시 sticky로 설정
    }
});
window.addEventListener('scroll', function() {
    var scrollPosition = window.scrollY;
    var topNav = document.querySelector('.video_top_back > .top_nav');

    if (scrollPosition > 100) { // 스크롤 멈추기를 원하는 위치의 값
        topNav.style.position = 'static'; // 스크롤 위치가 특정 값 이상이면 sticky 해제
    } else {
        topNav.style.position = 'sticky'; // 특정 값 미만이면 다시 sticky로 설정
    }
});

// 데이터요청
function comment() {
    let commentinp = document.querySelector(".commentinput");
    let inputValue = commentinp.value.trim();

    if (inputValue === "") {
        alert("입력칸이 비었습니다");
    } else {
        sendDataToServer(inputValue);
    }
}

function sendDataToServer(commentValue) {
    // 서버로 데이터를 보내는 fetch 요청
    const data = {
        comment: commentValue,
        youtubeEntityId : 1
    };
    console.log(data);
    fetch('http://localhost:8082/saveComment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ data }),
        
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok.');
        }
        return response.json();
    })
    .then(data => {
        // 서버에서 받은 데이터로 댓글 추가
        handleReceivedData(data);
    })
    .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
        // 에러 발생 시 처리
    });
}

function handleReceivedData(data) {
    let commentul1 = document.querySelector(".commentul");
    let commentli = document.createElement("li");
    commentli.innerText = data.comment; // 서버에서 받은 데이터의 필드명에 따라 수정
    let x = document.createElement("i");
    x.className = "fa-solid fa-xmark";
    commentli.appendChild(x);

    commentul1.insertBefore(commentli, commentul1.firstChild);
}

function commentcancle() {
    let commentinp = document.querySelector(".commentinput");
    commentinp.value = "";
    commentinp.focus();
}
