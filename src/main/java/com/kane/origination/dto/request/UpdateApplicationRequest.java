package com.kane.origination.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateApplicationRequest {
    private UUID applicationUuid;
    private UUID productId;
}
