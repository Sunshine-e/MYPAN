package com.ittahac.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ittahac.modal.Menu;

public interface MenuMapper {
	public List<Menu> getAll();
	public int add(Menu menu);
	public int countMenu();
	public Menu getById(@Param("id")Serializable id);
	public List<Menu> findMenuByParam(Menu menu);
	public int update(Menu menu);
}
