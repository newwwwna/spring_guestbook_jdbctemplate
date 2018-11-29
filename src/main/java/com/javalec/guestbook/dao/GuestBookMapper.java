package com.javalec.guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.javalec.guestbook.vo.GuestBookVO;

public class GuestBookMapper implements RowMapper<GuestBookVO> {

	public GuestBookVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GuestBookVO guestBookVo = new GuestBookVO();
		guestBookVo.setNo(rs.getLong("NO"));
		guestBookVo.setName(rs.getString("NAME"));
		guestBookVo.setPassword(rs.getString("PASSWORD"));
		guestBookVo.setRegDate(rs.getString("REGDATE"));
		guestBookVo.setContent(rs.getString("CONTENT"));

		return guestBookVo;
	}
	
	
	
}
