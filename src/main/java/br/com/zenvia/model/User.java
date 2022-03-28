package br.com.zenvia.model;

import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Getter
public class User {
    private String email, password;
}