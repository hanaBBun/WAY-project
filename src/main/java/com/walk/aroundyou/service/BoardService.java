package com.walk.aroundyou.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.walk.aroundyou.domain.Board;
import com.walk.aroundyou.dto.BoardDetailResponse;
import com.walk.aroundyou.repository.BoardRepository;


@Service
public class BoardService {
	
	@Autowired
	private BoardRepository BoardRepo;
	
	private final static int SIZE_OF_PAGE = 20;

	public Object findboardAllList(int page) {
		// TODO Auto-generated method stub
		//return BoardRepo.findBoardAndCnt();
		return BoardRepo.findBoardAndCnt(PageRequest.of(page, SIZE_OF_PAGE));
	}
	

	public Object findboardAllListByType(String type,int page) {
		// TODO Auto-generated method stub
		//return BoardRepo.findBoardAndCnt();
		return BoardRepo.findBoardAndCntByType(type, PageRequest.of(page, SIZE_OF_PAGE));
	}

	public Optional<BoardDetailResponse> findBoardDetail(Long id) {
		BoardRepo.updateViewCount(id);
		return BoardRepo.findBoardDetailById(id);
	}
	
	
}