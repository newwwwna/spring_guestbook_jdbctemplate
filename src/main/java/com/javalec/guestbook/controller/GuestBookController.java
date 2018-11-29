package com.javalec.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.javalec.guestbook.dao.GuestBookSpringDAO;

import com.javalec.guestbook.vo.GuestBookVO;



@Component("guestbook")
public class GuestBookController {

	@Autowired
	@Qualifier("springdao")
	private GuestBookSpringDAO GuestBookSpringDAO ;


	
	public void setGuestBookSpringDAO(GuestBookSpringDAO GuestBookSpringDAO) {
		this.GuestBookSpringDAO = GuestBookSpringDAO;
	}

	public List<GuestBookVO> getList(){
		List<GuestBookVO> list = GuestBookSpringDAO.getList();
	
	
		return list ;
	}
	
	public void delete(GuestBookVO vo) {
		GuestBookSpringDAO.delete(vo);
	}
	
	public void add(GuestBookVO vo) {
		GuestBookSpringDAO.insert(vo);
	}
	
	public void update(GuestBookVO vo) {
		GuestBookSpringDAO.update(vo);
	}
}
