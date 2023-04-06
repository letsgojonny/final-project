package bitcamp.myapp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bitcamp.myapp.dao.LocalDao;
import bitcamp.myapp.service.LocalService;
import bitcamp.myapp.vo.Local;

@Service
public class DefaultLocalService implements LocalService {

  @Autowired private LocalDao localDao;

  @Transactional
  @Override
  public void add(Local local) {
    localDao.insert(local);
  }

  @Override
  public List<Local> list(String keyword) {
    return localDao.findAll(keyword);
  }

  @Override
  public Local get(int no) {
    return localDao.findByNo(no);
  }

  @Transactional
  @Override
  public void update(Local local) {
    if (localDao.update(local) == 1) {
    } else {
      throw new RuntimeException("게시물이 존재하지 않습니다.");
    }
  }

  @Transactional
  @Override
  public void delete(int no) {
    if (localDao.delete(no) == 1) {
    } else {
      throw new RuntimeException("게시물이 존재하지 않습니다.");
    }
  }

}





