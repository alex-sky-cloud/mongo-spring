package com.spring.mongo.service.dto.stackexchange;

import java.util.List;
import java.util.Objects;

public class ItemsDto {

    private List<SiteDto> items;

    public ItemsDto() {
    }

    public List<SiteDto> getItems() {
        return items;
    }

    public void setItems(List<SiteDto> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsDto itemsDto = (ItemsDto) o;
        return Objects.equals(items, itemsDto.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "ItemsDto{" +
                "items=" + items +
                '}';
    }
}
