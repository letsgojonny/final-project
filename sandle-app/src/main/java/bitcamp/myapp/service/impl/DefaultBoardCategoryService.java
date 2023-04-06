package bitcamp.myapp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bitcamp.myapp.dao.BoardCategoryDao;
import bitcamp.myapp.service.BoardCategoryService;
import bitcamp.myapp.vo.BoardCategory;


@Service
public class DefaultBoardCategoryService implements BoardCategoryService {

  @Autowired private BoardCategoryDao boardCategoryDao;

  @Transactional
  @Override
  public void add(BoardCategory category) {
    boardCategoryDao.insert(category);
  }

  @Override
  public List<BoardCategory> list(String keyword) {
    return boardCategoryDao.findAll(keyword);
  }

  @Override
  public BoardCategory get(int no) {
    return boardCategoryDao.findByNo(no);
  }

  @Transactional
  @Override
  public void update(BoardCategory category) {
    if (boardCategoryDao.update(category) == 1) {
    } else {
      throw new RuntimeException("게시물이 존재하지 않습니다.");
    }
  }

  @Transactional
  @Override
  public void delete(int no) {
    if (boardCategoryDao.delete(no) == 1) {
    } else {
      throw new RuntimeException("게시물이 존재하지 않습니다.");
    }
  }

}





