package ru.gleb.SpringDatabase.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListResponse {

    /***
     * Сообщение об ошибке
     */
    private Boolean success;

    /***
     * Данные списка сущностей
     */
    @JsonInclude(Include.NON_NULL)
    private List<?> entities;

    public String toString() {
        return  "{" +
                "success='" + success + '\'' +
                ", list='" + entities + '\'' +
                "}";
    }
}
