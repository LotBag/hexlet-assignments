package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        String encryptPassword = Security.encrypt(password);
        String token = Security.generateToken();
        ctx.cookie("token", token);

        User user = new User(firstName, lastName, email, encryptPassword, token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Users not found"));
        var token = ctx.cookie("token");

        if (!token.equals(user.getToken())) {
            ctx.redirect(NamedRoutes.buildUserPath());
        } else {
            UserPage page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        }
    }
    // END
}
