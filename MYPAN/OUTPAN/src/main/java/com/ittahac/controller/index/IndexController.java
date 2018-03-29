package com.ittahac.controller.index;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ittahac.controller.BaseController;
import com.ittahac.mapper.MenuMapper;
import com.ittahac.mapper.UserMapper;
import com.ittahac.modal.Menu;
import com.ittahac.modal.User;

@Controller
public class IndexController extends BaseController {
	
	@Resource
	private UserMapper userMapper;
	@Resource
	private MenuMapper menuMapper;
	
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv = this.getBaseView("index");
		List<User> user = userMapper.getAll();
//		Map<String, Object> map = new HashMap<>();
//		map.put("user", user);
//		putJsonIntoResponse(map);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("insert")
	public ModelAndView insert() {
		ModelAndView mv = this.getBaseView("index");
		User user = new User();
		user.setNickname("管理员");
		user.setUsername("admin");
		user.setPassword("1234567");
		int res = userMapper.add(user);
		System.out.println(res);
		return mv;
	}
	
	@RequestMapping("/menu/add")
	@ResponseBody
	public void menuAdd() throws IOException {
		int count = menuMapper.countMenu();
		int num = 5;
		for (int i = 0; i < num; i++) {
			Menu menu = new Menu();
			menu.setCreateTime(new Date());
			menu.setName("菜单" + ++count);
			menu.setSort(count);
			menuMapper.add(menu);
		}
		this.getResponse().sendRedirect("../menu");
	}

	@RequestMapping("/menu")
	public ModelAndView menu() {
		ModelAndView mv = this.getBaseView("menu");
		List<Menu> menus = menuMapper.getAll();
		mv.addObject("menus", menus);
		return mv;
	}

	@RequestMapping("/menu/changeSort")
	@ResponseBody
	public void changeSort() throws IOException {
		String redc = this.getRequest().getParameter("redc");
		Menu menu = menuMapper.getById("1839");
		Menu mCon = new Menu();
		int sort = menu.getSort();
		int diffsort = sort;
		
		if (redc.equals("top")) {
			diffsort --;
		}else if (redc.equals("down")) {
			diffsort ++;
		}
		
		mCon.setSort(diffsort);
		List<Menu> list = menuMapper.findMenuByParam(mCon);
		if (list.size() == 0) {
			this.getResponse().sendRedirect("../error?message="+URLEncoder.encode("错误", "utf-8"));
			return;
		}
		Menu menuBefore = list.get(0);
		
		menu.setSort(diffsort);
		menuBefore.setSort(sort);
		
		int res = menuMapper.update(menuBefore);
		int res2 = menuMapper.update(menu);
		System.out.println(menuBefore.getName() + "：" + res);
		System.out.println(menu.getName() + "：" + res2);
		
		this.getResponse().sendRedirect("../menu");
		return;
	}
}
