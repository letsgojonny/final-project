package bitcamp.myapp.service;

import java.util.List;
import bitcamp.myapp.vo.Local;

public interface LocalService {
  void add(Local local);
  List<Local> list(String keyword);
  Local get(int no);
  void update(Local local);
  void delete(int no);
}





