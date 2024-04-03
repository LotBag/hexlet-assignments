package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
@AllArgsConstructor
public class UserPage {
    private User user;
}
// END
