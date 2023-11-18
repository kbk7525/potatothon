fetch(`http://localhost:8082/declaration/show/4`)
.then(response => response.json())
.then(data => {
    document.getElementById('title').value = data.title;
    document.getElementById('content').value = data.content;
    let mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(data.latitude, data.longitude), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    let map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 마커가 표시될 위치입니다
    let markerPosition = new kakao.maps.LatLng(data.latitude, data.longitude);

    // 마커를 생성합니다
    let marker = new kakao.maps.Marker({
        position: markerPosition
    });

    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
})
.catch(error => {
    console.log(error);
})

document.getElementById('button').addEventListener('click', function () {
openModal();
})

document.getElementById('confirmDeleteButton').addEventListener('click', function () {
let password = document.getElementById('password').value;

fetch(`http://localhost:8082/declaration/4?password=` + password, {
    method: 'POST',
})
    .then(response => {
        if (response.ok) {
            console.log('Report deleted successfully!');
            window.location.href='declaration.html';
            closeModal();
        } else {
            alert('비밀번호가 틀렸습니다');
        }
    })
    .catch(error => {
        console.error('Error deleting report:', error);
    });
});
// 모달 관련 함수
function openModal() {
document.getElementById('myModal').style.display = 'block';
}

function closeModal() {
document.getElementById('myModal').style.display = 'none';
}

window.onclick = function (event) {
if (event.target === document.getElementById('myModal')) {
    closeModal();
}
}