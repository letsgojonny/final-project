package bitcamp.myapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import bitcamp.myapp.vo.Board;

@Mapper
public interface BoardDao {
  void insert(Board board);
  List<Board> findAll(String keyword);
  Board findByNo(int no);
  int update(Board board);
  int delete(int no);
}







