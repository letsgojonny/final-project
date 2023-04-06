package bitcamp.myapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.myapp.service.BoardCategoryService;
import bitcamp.myapp.vo.BoardCategory;
import bitcamp.util.RestResult;
import bitcamp.util.RestStatus;

@RestController
@RequestMapping("/categorys")
public class BoardCategoryController {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("BoardCategoryController 생성됨!");
  }

  @Autowired private BoardCategoryService boardCategoryService;

  @PostMapping
  public Object insert(@RequestBody BoardCategory boardCategory) {
    boardCategoryService.add(boardCategory);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }



  @GetMapping
  public Object list(String keyword) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(boardCategoryService.list(keyword));
  }

  @GetMapping("{no}")
  public Object view(@PathVariable int no) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(boardCategoryService.get(no));
  }

  @PutMapping("{no}")
  public Object update(
      @PathVariable int no,
      @RequestBody BoardCategory boardCategory) {

    log.debug(boardCategory);

    // 보안을 위해 URL 번호를 게시글 번호로 설정한다.
    boardCategory.setNo(no);

    boardCategoryService.update(boardCategory);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @DeleteMapping("{no}")
  public Object delete(@PathVariable int no) {
    boardCategoryService.delete(no);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

}
