window.onload = function () {
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(37.886997286287475, 127.73802112925794), // 지도의 중심좌표
            level: 4 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 지도를 클릭한 위치에 표출할 마커입니다
    var marker = new kakao.maps.Marker({
        // 지도 중심좌표에 마커를 생성합니다 
        position: map.getCenter()
    });
    // 지도에 마커를 표시합니다
    marker.setMap(map);

    // 지도에 클릭 이벤트를 등록합니다
    // 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {

        // 클릭한 위도, 경도 정보를 가져옵니다 
        var latlng = mouseEvent.latLng;

        // 마커 위치를 클릭한 위치로 옮깁니다
        marker.setPosition(latlng);

        document.getElementById('button').addEventListener('click', function() {
            let content = document.getElementById('content').value;
            let password = document.getElementById('password').value;
            let title = document.getElementById('title').value;
            let filesInput = document.getElementById('files');
            let files = filesInput.files;
            let latitude = latlng.getLat();
            let longitude = latlng.getLng();

            let formData = new FormData();

            formData.append('content', content);
            formData.append('password', password);
            formData.append('title', title);
            formData.append('latitude', latitude);
            formData.append('longitude', longitude);

            for(let i = 0; i < files.length; i++) {
                formData.append('images', files[i]);
            }
            console.log(formData);
            fetch('http://localhost:8082/upload', {
                method: 'POST',
                body: formData,
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success : ', data);
                window.location.href='declaration.html';
            })
            .catch(error => {
                console.log('error : ' ,error);
            })
        })
    });
}