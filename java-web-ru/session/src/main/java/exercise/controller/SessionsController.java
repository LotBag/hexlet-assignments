package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", model("page", page));
    }
    public static void build(Context ctx) {
        var page = new LoginPage("","");
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");
        String encryptPassword = Security.encrypt(password);
        var user = UsersRepository.findByName(name);
        if (!user.getPassword().equals(encryptPassword) || user == null) {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        } else {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
