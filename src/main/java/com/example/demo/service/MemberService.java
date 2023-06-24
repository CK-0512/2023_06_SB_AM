package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.util.Util;
import com.example.demo.vo.Member;
import com.example.demo.vo.ResultData;

@Service
public class MemberService {

	private MemberDao memberDao;

	@Autowired
	MemberService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public ResultData<Member> doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum, String email) {
		
		Member existsMember = getMemberByLoginId(loginId);
		
		if (existsMember != null) {
			return ResultData.from("F-7", Util.f("이미 사용중인 아이디(%s)입니다", loginId));
		}
		
		existsMember = getMemberByNickname(nickname);
		
		if (existsMember != null) {
			return ResultData.from("F-8", Util.f("이미 사용중인 닉네임(%s)입니다", nickname));
		}
		
		existsMember = getMemberByNameAndEmail(name, email);
		
		if (existsMember != null) {
			return ResultData.from("F-9", Util.f("이미 사용중인 이름(%s)과 이메일(%s)입니다", name, email));
		}
		
		memberDao.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);
		
		return ResultData.from("S-1", Util.f("%s회원님이 가입되었습니다", nickname), getMemberById(getLastInsertId()));
	}

	private Member getMemberByNameAndEmail(String name, String email) {
		return memberDao.getMemberByNameAndEmail(name, email);
	}

	private Member getMemberByNickname(String nickname) {
		return memberDao.getMemberByNickname(nickname);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberDao.getMemberById(id);
	}

	public int getLastInsertId() {
		return memberDao.getLastInsertId();
	}

	public ResultData<Member> doLogin(HttpSession session, String loginId, String loginPw) {
		
		Member loginedMember = getMemberByLoginId(loginId);
		
		if (loginedMember == null) {
			return ResultData.from("F-3", Util.f("존재하지 않는 아이디(%s)입니다.", loginId));
		}
		
		if (loginedMember.getLoginPw() != loginPw) {
			return ResultData.from("F-4", "비밀번호가 일치하지 않습니다.");
		}
		
		session.setAttribute("loginedMember", loginedMember);
		
		return ResultData.from("S-1", "로그인 성공", loginedMember);
		
	}

}