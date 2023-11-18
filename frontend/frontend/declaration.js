fetch('http://localhost:8082/declaration')
.then((data) => {
    makeTable(data.data);
  });

  function makeTable(data) {
    let table = document.getElementById("table");
    for (let i = data.length - 1; i >= 0; i--) {
        let row = `<tr>
                  <td>${data[i].title}</td>
                  <td>${data[i].content}</td>
                  <td>익명</td>
                 </tr>`;
        table.innerHTML += row;
      }
  }