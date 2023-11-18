fetch('http://localhost:8082/declaration/show')
.then(response => {
  if(response.ok) {
    return response.json();
  }
})
.then((data) => {
    console.log(data);
    makeTable(data);
  });

  function makeTable(data) {
    let table = document.getElementById("table");
    for (let i = data.length - 1; i >= 0; i--) {
        let row = `<tr>
                  <td> <a href="detail.html">${data[i].title}</td>
                  <td>${data[i].content}</td>
                  <td>익명</td>
                 </tr>`;
        table.innerHTML += row;
      }
  }