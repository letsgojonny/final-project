package bitcamp.myapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import bitcamp.myapp.vo.Local;

@Mapper
public interface LocalDao {
  void insert(Local local);
  List<Local> findAll(String keyword);
  Local findByNo(int no);
  int update(Local local);
  int delete(int no);
}







