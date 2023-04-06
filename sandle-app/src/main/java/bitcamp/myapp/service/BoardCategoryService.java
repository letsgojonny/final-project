package bitcamp.myapp.service;

import java.util.List;
import bitcamp.myapp.vo.BoardCategory;

public interface BoardCategoryService {
  void add(BoardCategory category);
  List<BoardCategory> list(String keyword);
  BoardCategory get(int no);
  void update(BoardCategory category);
  void delete(int no);
}





