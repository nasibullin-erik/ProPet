package ru.itis.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.backend.models.UserRole;
import ru.itis.backend.models.UserState;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessToken {

    protected Long id;
    protected String login;
    protected Date expiration;
    protected UserRole role;
    protected UserState state;

    public boolean isActive() {
        return this.state == UserState.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == UserState.BANNED;
    }

    public boolean isAdmin() {
        return this.role == UserRole.ADMIN;
    }
}
