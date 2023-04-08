getLocals();
const html = document.querySelector("#tr-template").innerHTML;
const templateEngine = Handlebars.compile(html);

// document.querySelector("input[name='keyword']").onkeyup = (e) => {
//   getLocals(e.target.value);
// };

const btnSearch = document.querySelector("#btn-search");

btnSearch.onclick = () => {
  const keyword = document.querySelector("input[name='keyword']").value;
  getLocals(keyword);
};

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
