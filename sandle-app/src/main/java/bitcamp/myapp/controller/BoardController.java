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
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.Board;
import bitcamp.util.RestResult;
import bitcamp.util.RestStatus;

@RestController
@RequestMapping("/boards")
public class BoardController {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("BoardController 생성됨!");
  }

  @Autowired private BoardService boardService;

  @PostMapping
  public Object insert(@RequestBody Board board) {
    boardService.add(board);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }



  @GetMapping
  public Object list(String keyword) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(boardService.list(keyword));
  }

  @GetMapping("{no}")
  public Object view(@PathVariable int no) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(boardService.get(no));
  }

  @PutMapping("{no}")
  public Object update(
      @PathVariable int no,
      @RequestBody Board board) {

    log.debug(board);

    // 보안을 위해 URL 번호를 게시글 번호로 설정한다.
    board.setNo(no);

    boardService.update(board);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @DeleteMapping("{no}")
  public Object delete(@PathVariable int no) {
    boardService.delete(no);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

}
