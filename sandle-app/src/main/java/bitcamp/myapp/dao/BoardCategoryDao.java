package bitcamp.myapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import bitcamp.myapp.vo.BoardCategory;

@Mapper
public interface BoardCategoryDao {
  void insert(BoardCategory category);
  List<BoardCategory> findAll(String keyword);
  BoardCategory findByNo(int no);
  int update(BoardCategory category);
  int delete(int no);
}







