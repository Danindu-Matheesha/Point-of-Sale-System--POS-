package com.coureswork.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {
    private List<Long> itemIds;
}
