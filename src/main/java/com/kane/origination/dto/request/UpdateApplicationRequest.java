package com.kane.origination.dto.request;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateApplicationRequest {
  private UUID applicationUuid;
  private UUID productId;
}
