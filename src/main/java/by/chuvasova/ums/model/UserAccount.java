package by.chuvasova.ums.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(min = 3, max = 16, message = "Name must be between 3 - 16 latin letters")
    private String username;

    @NotEmpty
    @Pattern(regexp = "([A-Za-z]*)(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{3,60}$", message = "password should contain only latin letters, at least one number, one character, size = 3-16 symbols")
    private String password;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(min = 1, max = 16, message = "Please, enter your name (latin letter)")
    private String name;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(min = 1, max = 16, message = "Please, enter your surname (latin letter)")
    private String surname;

    private String role;

    @Builder.Default
    private boolean active = true;

    @Builder.Default
    private Boolean isLocked = false;

    private String status;

    @Column(name = "created_at")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
