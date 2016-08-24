package springMVC.service;

import org.springframework.transaction.annotation.Transactional;
import springMVC.dao.MenuDao;
import springMVC.model.Employee;
import springMVC.model.Menu;

import java.util.List;

/**
 * Created by Администратор on 20.08.16.
 */
public class MenuService {


    private MenuDao menuDao;

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public Menu getMenuByName(String menuName){
        return menuDao.findByName(menuName);
    }


    @Transactional
    public Menu getMenuById(Long id){
        return menuDao.findById(id);
    }



    @Transactional
    public List<Menu> showMenu() {
        return menuDao.showAll();
    }
}
