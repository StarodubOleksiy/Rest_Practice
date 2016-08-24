package springMVC.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springMVC.model.Employee;
import springMVC.model.Menu;
import springMVC.service.MenuService;

import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 20.08.16.
 */
@Controller
@RestController
public class MenuController {

   private MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    // @ResponseBody
    public List<Menu> menu(Map<String, Object> model) {
        return menuService.showMenu();
    }


    @RequestMapping(value = "/menuById/{menuId}", method = RequestMethod.GET)
    // @ResponseBody
    public Menu menuById(@PathVariable long menuId) {
        return menuService.getMenuById(menuId);
    }

    @RequestMapping(value = "/menuByName/{menuName}", method = RequestMethod.GET)
    // @ResponseBody
    public Menu menuByName(@PathVariable String menuName) {
        return menuService.getMenuByName(menuName);
    }


}
