package com.kane.origination.mapper;

import com.kane.origination.dto.request.AddressRequest;
import com.kane.origination.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  Address toAddress(final AddressRequest addressRequest);
}
