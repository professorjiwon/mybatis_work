package com.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.common.template.Template;
import com.mybatis.member.dao.MemberDao;
import com.mybatis.member.vo.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao mDao = new MemberDao();
	
	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}

}
