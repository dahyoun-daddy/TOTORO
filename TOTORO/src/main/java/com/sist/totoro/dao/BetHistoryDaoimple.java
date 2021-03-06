package com.sist.totoro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.totoro.domain.BetHistoryResultVO;
import com.sist.totoro.domain.BetHistoryVO;
import com.sist.totoro.domain.UserVO;

@Repository
public class BetHistoryDaoimple {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAME_SPACE = "com.sist.totoro.mappers.betHistory";
	
	
	
	
	
	
	
	public int do_updateUserPoint(UserVO inVO) {
		//크로스 구매시 베팅금액만큼 포인트 제거
		String statement = NAME_SPACE + ".do_updateUserPoint";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+inVO);

		return this.sqlSession.update(statement, inVO);
	}
	
	public int do_countSeq() {
		String statement = NAME_SPACE + ".do_countSeq";
		
		return this.sqlSession.selectOne(statement);
	}
	
	public int do_betUpdate(int gameSeq){
		//리스트의 사이즈만큼 반복시키면서 다시 수행해야함.
		String statement = NAME_SPACE + ".do_betUpdate";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+gameSeq);

		return this.sqlSession.update(statement, gameSeq);
	}

	
	public List<BetHistoryVO> do_selectBetAll(String userId) {
		
		String statement = NAME_SPACE + ".do_selectBetAll";
		
		log.debug("1.statement : \n"+statement);
		log.debug("1.param : \n"+userId);

		return this.sqlSession.selectList(statement,userId);
	}

	
	
	public List<BetHistoryVO> do_viewByUserId(String userId) {
		//아이디 값을 가지고  betSeq 값을 얻어와야함. 그 값을 가지고 계속 돌려야함.
		
		String statement = NAME_SPACE + ".do_viewByUserId";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement, userId);
	}
	
	public List<BetHistoryResultVO> do_viewByBetSeq(BetHistoryVO bet_HistoryVO){
		//리스트의 사이즈만큼 반복시키면서 다시 수행해야함.
		String statement = NAME_SPACE + ".do_viewByBetSeq";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+bet_HistoryVO);

		return this.sqlSession.selectList(statement, bet_HistoryVO);
	}

	public int do_betInsert(BetHistoryVO bet_HistoryVO){
		//리스트의 사이즈만큼 반복시키면서 다시 수행해야함.
		String statement = NAME_SPACE + ".do_betInsert";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+bet_HistoryVO);

		return this.sqlSession.insert(statement, bet_HistoryVO);
	}
	
	
	
	public String do_deleteFolder(BetHistoryVO bet_HistoryVO){
		//사용자가 각 폴더를 삭제하더라도 관리자의 테이블에선 데이터를 유지하고 있어야함.
		


		return null;
	}

}
