package com.apiauth.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private Long timestamp;
    private String erro;
    private List<String> messages;
    private String path;
}
