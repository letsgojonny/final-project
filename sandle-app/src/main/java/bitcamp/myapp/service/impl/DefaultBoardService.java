package bitcamp.myapp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.Board;

@Service
public class DefaultBoardService implements BoardService {

  @Autowired private BoardDao boardDao;

  @Transactional
  @Override
  public void add(Board board) {
    boardDao.insert(board);
  }

  @Override
  public List<Board> list(String keyword) {
    return boardDao.findAll(keyword);
  }

  @Override
  public Board get(int no) {
    return boardDao.findByNo(no);
  }

  @Transactional
  @Override
  public void update(Board board) {
    if (boardDao.update(board) == 1) {
    } else {
      throw new RuntimeException("게시물이 존재하지 않습니다.");
    }
  }

  @Transactional
  @Override
  public void delete(int no) {
    if (boardDao.delete(no) == 1) {
    } else {
      throw new RuntimeException("게시물이 존재하지 않습니다.");
    }
  }

}





