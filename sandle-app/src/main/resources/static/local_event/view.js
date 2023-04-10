
// const values = location.href.split("?");
// if (values.length == 1) {
//   alert("URL이 옳지 않습니다.");
//   location.href = "index.html";
// }

// // no=100
// const param = values[1].split("=");
// if (param.length == 1 || param[0] != "no") {
//   alert("URL이 옳지 않습니다.");
//   location.href = "index.html";
// }

// let no = parseInt(param[1]);
// if (isNaN(no)) {
//   alert("URL이 옳지 않습니다.");
//   location.href = "index.html";
// }

let no = localStorage.getItem("no");
if (no === null || no === undefined) {
  console.log("localStorage에 값이 없습니다.");
} else {
  console.log("localStorage에서 가져온 값:", no);
}

//let localNo = JSON.parse(no);


  // let no = e.currentTarget.getAttribute("");
  // let localNo = 1;
  

fetch("../locals/" + no)
  .then((response) => {
    console.log(response);
    return response.json();
  })
  .then((result) => {
    if (result.status == "failure") {
      console.log(result);
      alert("행사정보를 조회할 수 없습니다.");
      // location.href = "index.html";
      return;
    }

    let local = result.data;
    console.log(local);
    document.querySelector("input[name='no']").value = local.no;
    document.querySelector("input[name='title']").value = local.title;
    document.querySelector("textarea[name='content']").value = local.content;
    document.querySelector("textarea[name='tag']").value = local.tag;
    document.querySelector("textarea[name='period']").value = local.period;
    document.querySelector("textarea[name='postno']").value = local.postno;
    document.querySelector("textarea[name='basicAddress']").value =
      local.basicAddress;
    document.querySelector("textarea[name='detailAddress']").value =
      local.detailAddress;

    // 기존엔 board.writer.name 이라 함 체크
    document.querySelector("#l-nickname").value = local.nickname;
    document.querySelector("#l-createdDate").value = local.createdDate;
    // document.querySelector("#f-view-count").innerHTML = local.viewCount;

    // let ul = "";
    // local.attachedFiles.forEach((file) => {
    //   console.log(file);
    //   if (file.no == 0) return;
    //   let html = `
    // <li id="li-${file.no}">
    //   <a href="https://kr.object.ncloudstorage.com/bitcamp-bucket08/local/${file.filepath}">${file.originalFilename}</a>
    //   [<a href="#" onclick="deleteFile(${local.no}, ${file.no}); return false;">삭제</a>]
    // </li>`;
    //   ul += html;
    // });
    // document.querySelector("#f-files").innerHTML = ul;

    // writer.no 어떤 근거로 쓴건지 체크
    // checkOwner(local.writer.no);
  });


// // writerNo 어떤 근거로 쓴건지 체크
// function checkOwner(writerNo) {
//   fetch("../auth/user")
//     .then((response) => {
//       return response.json();
//     })
//     .then((result) => {
//       console.log(result);
//       if (result.status == "success") {
//         if (result.data.no == writerNo) {
//           document.querySelector("#btn-update").classList.remove("guest");
//           document.querySelector("#btn-delete").classList.remove("guest");
//         }
//       }
//     })
//     .catch((exception) => {
//       alert("로그인 사용자 정보 조회 중 오류 발생!");
//       console.log(exception);
//     });
// }

function deleteFile(localNo, fileNo) {
  fetch("../locals/" + localNo + "/files/" + fileNo, {
    method: "DELETE",
  })
    .then((response) => {
      return response.json();
    })
    .then((result) => {
      if (result.status == "success") {
        let li = document.querySelector("#li-" + fileNo);
        document.querySelector("#f-files").removeChild(li);
      } else {
        alert("파일 삭제 실패!");
      }
    })
    .catch((exception) => {
      alert("파일 삭제 중 오류 발생!");
      console.log(exception);
    });
}

document.querySelector("#btn-index").onclick = function () {
  location.href = "index.html";
};

document.querySelector("#btn-update").onclick = function () {
  const form = document.querySelector("#local-form");
  const formData = new FormData(form);

  // FormData 대신 객체를 전달하기 위해 폼을 직접 직렬화
  const formDataObj = {};
  for (let pair of formData.entries()) {
    formDataObj[pair[0]] = pair[1];
  }

  fetch("../locals/" + document.querySelector("input[name='no']").value, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formDataObj)
  })
    .then((response) => {
      return response.json();
    })
    .then((result) => {
      if (result.status == "success") {
        console.log(result.status);
        location.reload();
      } else {
        alert("변경 실패!");
      }
    })
    .catch((exception) => {
      alert("변경 중 오류 발생!");
      console.log(exception);
    });
};

document.querySelector("#btn-delete").onclick = function () {
  fetch("../locals/" + document.querySelector('input[name="no"]').value, {
    method: "DELETE",
  })
    .then((response) => {
      return response.json();
    })
    .then((result) => {
      if (result.status == "success") {
        location.href = "index.html";
      } else {
        alert("삭제 실패!");
      }
    })
    .catch((exception) => {
      alert("삭제 중 오류 발생!");
      console.log(exception);
    });
};
