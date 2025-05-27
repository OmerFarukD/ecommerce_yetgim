package com.yetgim.ecommerce.dto.users;

import jakarta.validation.constraints.*;

public record RegisterRequestDto(
        @NotBlank(message = "İsim alanı boş olamaz.")

        // Array da kullanılır.
       // @NotEmpty(message = "İsim alanı boş olamaz.")
        @NotNull
        String username,

        @Email(message = "Email alanı Email formatında olmalıdır.")
        String email,

        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\p{Punct}]).{6,}$",
                message = "Parola en az 6 karakterli olmalı, bir büyük harf, bir küçük harf, bir rakam ve bir noktalama işareti içermelidir."
        )
        String password){
}
