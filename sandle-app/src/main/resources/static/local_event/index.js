getLocals();
const html = document.querySelector("#tr-template").innerHTML;
const templateEngine = Handlebars.compile(html);
const btnSearch = document.querySelector("#btn-search");
const searchInput = document.querySelector('input[name="keyword"]');

// 검색버튼 클릭시 검색
btnSearch.onclick = () => {
  const keyword = document.querySelector("input[name='keyword']").value;
  getLocals(keyword);
};

// 엔터 버튼 입력 시 검색
searchInput.addEventListener("keypress", function (event) {
  if (event.key === "Enter") {
    const keyword = searchInput.value;
    getLocals(keyword);
  }
});

function getLocals(keyword) {
  let qs = "";
  if (keyword) {
    qs = `?keyword=${keyword}`;
  }

  fetch("../locals" + qs)
    .then((response) => {
      return response.json();
    })
    .then((result) => {
      console.log(result.data);
      document.querySelector("#local-table > tbody").innerHTML = templateEngine(
        result.data
      );
    });
}

function saveLocalNo(event, no) {
  event.preventDefault();
  localStorage.setItem("no", no);
  window.location.href = event.currentTarget.href;
}
