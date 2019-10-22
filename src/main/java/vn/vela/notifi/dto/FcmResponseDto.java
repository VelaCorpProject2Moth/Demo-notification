package vn.vela.notifi.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FcmResponseDto {

  Long multicastId;
  Long success;
  Long failure;
  List<Long> canonicalIds;
  List<Object> results;

  @Override
  public String toString() {
    return String.format("%s%s%s%s%s%s%s%s%s%s%s%s",
        "FcmResponseDto{",
        "multicastId= ", multicastId,
        ", success= ", success,
        ", failure= ", failure,
        ", canonicalIds= ", canonicalIds,
        ", results= ", results,
        '}');
  }
}
