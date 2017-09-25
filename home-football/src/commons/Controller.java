package commons;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	String process(HttpServletRequest request, HttpServletResponse response) throws SQLException;
}
