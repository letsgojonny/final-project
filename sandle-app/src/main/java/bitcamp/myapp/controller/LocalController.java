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
import bitcamp.myapp.service.LocalService;
import bitcamp.myapp.vo.Local;
import bitcamp.util.RestResult;
import bitcamp.util.RestStatus;

@RestController
@RequestMapping("/locals")
public class LocalController {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("LocalController 생성됨!");
  }

  @Autowired private LocalService localService;

  @PostMapping
  public Object insert(@RequestBody Local local) {
    localService.add(local);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }



  @GetMapping
  public Object list(String keyword) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(localService.list(keyword));
  }

  @GetMapping("{no}")
  public Object view(@PathVariable int no) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(localService.get(no));
  }

  @PutMapping("{no}")
  public Object update(
      @PathVariable int no,
      @RequestBody Local local) {

    log.debug(local);

    // 보안을 위해 URL 번호를 게시글 번호로 설정한다.
    local.setNo(no);

    localService.update(local);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @DeleteMapping("{no}")
  public Object delete(@PathVariable int no) {
    localService.delete(no);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

}
