package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch14BoardDao;
import com.mycompany.webapp.dao.Ch14MemberDao;
import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Ch14Pager;

@Service
public class Ch14Service {

	@Resource
	public Ch14MemberDao memberDao;
	
	
	//회원가입
	public void join(Ch14Member member) {
		memberDao.insert(member);
	}

	//로그인
	public String login(Ch14Member member) {
		//db에서 아이디 가져오기
		Ch14Member dbMember = memberDao.selectByMid(member.getMid());
		
		if(dbMember == null) {
			return "wrongMid";
		}
		if (member.getMpassword().equals(dbMember.getMpassword())) {
			return "success";
		} else {
			return "wrongMpassword";
		}
	}
	
	@Resource
	public Ch14BoardDao boardDao;

	public List<Ch14Board> getBoardList() {
		List<Ch14Board> list = boardDao.selectAll();
		return list;
	}
	
	public List<Ch14Board> getBoardList(Ch14Pager pager) {
		List<Ch14Board> list = boardDao.selectByPage(pager);
		return list;
	}

	public void boardWrite(Ch14Board board) {
		boardDao.insert(board);
		
	}

	public int getTotalRow() {
		int totalRows = boardDao.countAll();
		return totalRows;
	}

	public Ch14Board getBoard(int bno) {
		Ch14Board board = boardDao.selectByBno(bno);
		return board;
	}

	public void boardDelete(int bno) {
		int rows = boardDao.deleteByBno(bno); //삭제된 행수가 리턴됨을 보여줄려고 변수 선언	
	}

	public void boardUpdate(Ch14Board board) {
		int rows = boardDao.updateBoard(board);
		
	}
	
	
	
}
