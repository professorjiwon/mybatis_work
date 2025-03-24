package com.mybatis.member.service;

import com.mybatis.member.vo.Member;

public interface MemberService {
	Member loginMember(Member m);
	
	int checkId(String userId);
	
	int insertMember(Member m);
}
