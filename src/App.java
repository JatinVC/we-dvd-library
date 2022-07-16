import com.mthree.controller.DvdController;
import com.mthree.dao.DvdDaoImpl;
import com.mthree.view.DvdView;
import com.mthree.view.UserIO;
import com.mthree.view.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws Exception {
        UserIO io = new UserIOConsoleImpl();
        DvdView view = new DvdView();
        DvdDaoImpl dao = new DvdDaoImpl();

        DvdController controller = new DvdController(io, view, dao);

        controller.run();
    }
}
