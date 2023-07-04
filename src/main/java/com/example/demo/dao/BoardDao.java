package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Board;

@Mapper
public interface BoardDao {

	@Select("""
			SELECT b.*, a.COUNT(*) as totArticles
				FROM board b
				INNER JOIN article a
				ON b.id = a.boardId
				WHERE id = #{boardId}
				AND delStatus = 0
			""")
	public Board getBoardById(int boardId);
	
}