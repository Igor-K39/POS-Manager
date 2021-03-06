package ru.posmanager.dto.user;

import lombok.*;
import org.springframework.util.Assert;
import ru.posmanager.HasIdAndEmail;
import ru.posmanager.domain.user.Role;
import ru.posmanager.dto.BaseDTO;
import ru.posmanager.dto.bank.DepartmentDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class UserDTO extends BaseDTO implements HasIdAndEmail {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    protected String firstName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    protected String lastName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    protected String middleName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    protected String city;

    @NotNull
    protected DepartmentDTO department;

    @Email
    @NotNull
    @Size(min = 5, max = 50)
    protected String email;

    @NotBlank
    @Size(min = 8, max = 255)
    protected String password;

    protected boolean enabled = true;

    protected Date registered;

    protected Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return Set.copyOf(roles);
    }

    public void setRoles(Collection<Role> roles) {
        Assert.notNull(roles, "Roles must not be null");
        this.roles.clear();
        this.roles.addAll(roles);
    }

    public UserDTO(UserDTO u) {
        this(u.id, u.firstName, u.lastName, u.middleName, u.city, u.department, u.email, u.password,
                u.enabled, u.registered, u.roles);
    }

    public UserDTO(Integer id, String firstName, String lastName, String middleName, String city,
                   DepartmentDTO department, String email, String password, boolean enabled,
                   Date registered, Set<Role> roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.city = city;
        this.department = department;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }
}
