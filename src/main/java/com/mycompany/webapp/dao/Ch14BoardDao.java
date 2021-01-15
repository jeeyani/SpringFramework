package com.mycompany.webapp.dao;

import java.util.List;

import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Ch14Pager;

import oracle.net.aso.s;

@Repository
public class Ch14BoardDao {

	@Resource
	private SqlSessionTemplate sst;

	public List<Ch14Board> selectAll() {
		List<Ch14Board> list = sst.selectList("mybatis.mapper.board.selectAll");
		
		return list;
	}

	public List<Ch14Board> selectByPage(Ch14Pager pager) {
		List<Ch14Board> list = sst.selectList("mybatis.mapper.board.selectByPage" , pager);
		
		return list;
	}
	
	public int insert(Ch14Board board) {
		int rows = sst.insert("mybatis.mapper.board.insert", board);
		return rows;
	}

	public int countAll() {
		int totalRows = sst.selectOne("mybatis.mapper.board.countAll");
		return totalRows;
	}

	public Ch14Board selectByBno(int bno) {
		Ch14Board board = sst.selectOne("mybatis.mapper.board.selectByBno", bno);
		return board;
	}

	public int deleteByBno(int bno) {
		int rows = sst.delete("mybatis.mapper.board.deleteByBno", bno);
		return rows;
	}

	public int updateBoard(Ch14Board board) {
		int rows = sst.update("mybatis.mapper.board.updateBoard", board);
		return rows;
	}

	
	
	
}
