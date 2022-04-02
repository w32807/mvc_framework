package next.controller;

import core.mvc.Controller;
import next.dao.UserDao;
import next.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UpdateFormUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateFormUserController.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = null;
        UserDao userDao = new UserDao();
        try {
            user = userDao.findByUserId(userId);
        }catch (SQLException e){
            log.error(e.getMessage());
        }
        if (!UserSessionUtils.isSameUser(req.getSession(), user)) {
            throw new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다.");
        }
        req.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}
