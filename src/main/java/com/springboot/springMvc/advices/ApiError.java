package com.springboot.springMvc.advices;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.util.*;

@Data
@Builder
@Getter
@Setter
public class ApiError
{
    private HttpStatus httpStatus;
    private String message;
    private List<String> subErrors;
}
