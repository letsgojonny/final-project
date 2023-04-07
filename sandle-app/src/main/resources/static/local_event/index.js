getLocals();
// 템플릿으로 사용할 HTML을 준비한다.
const html = document.querySelector("#tr-template").innerHTML;

// HTML을 가지고 템플릿 엔진을 생성한다.
const templateEngine = Handlebars.compile(html);

fetch("../locals")
  .then((response) => {
    return response.json();
    // json()은 Promise 객체를 리턴한다.
    // Promise 객체가 하는 일:
    //   - 서버에서 응답 콘텐트를 받는 일을 한다.
    //   - 서버에서 받은 JSON 포맷의 문자열을 JavaScript 객체로 변환한다.
    //   - resolve()를 호출하여 다음 Promise 객체에 작업이 완료됐음을 통지한다.
    //     이때 변환된 JavaScript를 객체를 파라미터로 전달한다.
  })
  .then((result) => {
    console.log(result.data);
    document.querySelector("#local-table > tbody").innerHTML = templateEngine(
      result.data
    );
  });
