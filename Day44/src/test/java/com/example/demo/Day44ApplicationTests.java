package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.*;
import com.example.demo.entity.*;

@SpringBootTest
class Day44ApplicationTests {
	@Autowired
	BoardDao boardDao;
	
//	@Transactional
//	@Test
	public void Dao값() {
		for(int i=0;i<5;i++) {
			boardDao.save(Board.builder().title(i+"번째 글").content(i+"번째 글").nickname("NYS").build());
		}
		for(int i=0; i<5; i++) {
			boardDao.save(Board.builder().title(i+"번째 끝").content(i+"번째 끝").nickname("NYS2").build());
		}
	}
	
//	@Test
	public void initTest() {
		assertNotNull(boardDao);
	}
//	@Test
	public void insertTest() {
		Board board =Board.builder().title("제목").content("내용").nickname("닉네임").build();
		assertEquals(1,boardDao.save(board));
	}
	
//	@Test
	public void findAllTest() {
		List<Board> list=boardDao.findAll();
		System.out.println(list);
		assertNotEquals(0,list.size());
	}
	
//	@Test
	public void deleteTest() {
		assertEquals(1,boardDao.delete(1L));
	}
}
