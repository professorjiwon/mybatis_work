package com.mybatis.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.member.vo.Member;

public class MemberDao {

	public Member loginMember(SqlSession sqlSession, Member m) {
		/*
		 * Member loginUser = sqlSession.selectOne("memberMapper.LoginMember", m);
		 * return loginUser;
		 */
		return sqlSession.selectOne("memberMapper.LoginMember", m);
	}

	public int checkId(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.checkId", userId); //userId 값을 xml에 파일에 넘겨준다, 그래야 sql구문때 입력값을 넘겨줘서 비교가능
	}

	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	

}
