package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.entity.*;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	public List<BoardDto> findAll(){
		List<Board>boards= boardDao.findAll();
		List<BoardDto> dtos= new ArrayList<>();
		for(Board b:boards)
			dtos.add(b.toDto());
		return dtos;
	}
	
	public boolean save(String title,String content, String nickname){
		Board board = Board.builder().title(title).content(content).nickname(nickname).build();
		return boardDao.save(board)==1;
	}
}

