package bitcamp.myapp.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Local extends Board {
  private String period;
  private String postno;
  private String basicAddress;
  private String detailAddress;

}