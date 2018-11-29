package com.javalec.guestbook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.javalec.guestbook.vo.GuestBookVO;

@Repository("springdao")
public class GuestBookSpringDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(GuestBookVO vo) {
		String sql_insert = "INSERT INTO GUESTBOOK VALUES(guestbook_seq.nextval,?,?,?,SYSDATE)";
		System.out.println("insert 스엉공!!");
		Object args[] = {vo.getName(),vo.getContent(), vo.getPassword()};
		
		return jdbcTemplate.update(sql_insert,args);
	}

	public int delete(GuestBookVO vo) {
	return 0;

	}

	public GuestBookVO getGuestBook(GuestBookVO vo) {

		String sql = "SELECT NO, NAME, CONTENT, PASSWORD, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regdate from guestbook WHERE NO=?";
		return vo;
	}

	public List<GuestBookVO> getList() {

		System.out.println("list 호출!");

		String sql_list = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regdate from guestbook order by reg_date desc";
		return jdbcTemplate.query(sql_list, new GuestBookMapper());
	}

	public int update(GuestBookVO vo) {
		System.out.println("update 스엉공!!");
		String sql_update = "UPDATE GUESTBOOK SET NAME=?, CONTENT=?, PASSWORD=?, REG_DATE=SYSDATE WHERE NO=?";

		return jdbcTemplate.update(sql_update, vo.getName(), vo.getContent(), vo.getPassword(), vo.getNo());
	}
	
	public List<GuestBookVO> search(String keyword) {
	
		String sql = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') from guestbook where content like ?";
		return null;
	}
	
	public List<GuestBookVO> nameSearch(String keyword) {
		String sql = "select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') from guestbook where name like ?";
		return null;

	}
}