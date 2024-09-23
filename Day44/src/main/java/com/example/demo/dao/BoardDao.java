package com.example.demo.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.entity.*;


@Mapper
public interface BoardDao {
	@Insert ("insert into board(bno,title,content,nickname,write_time,read_cnt)"
			+ "values (board_seq.nextval,#{title},#{content},#{nickname},#{writeTime},#{readCnt})")
	public int save(Board board);
	
	@Select ("select*from board order by bno desc")
	public List<Board> findAll();
	
/*	@Update
	public 
*/	
	@Delete("delete from board where bno=#{bno}")
	public int delete(long tno);

}
