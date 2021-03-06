package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.CusReplyDao;
import com.sist.totoro.domain.CusReplyVO;



@Service
public class CusReplySvcImple implements CusReplySvc {
    private Logger log = LoggerFactory.getLogger(CusReplySvcImple.class);

	
	
	@Autowired
	private CusReplyDao cusreplyDao;
	
	
	//업그레이드 가능 확인 

	
	//레벨 업그래이드 실행
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#upgradeLevel(com.sist.hr.user.domain.UserVO)
	 */

	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#delete(com.sist.hr.user.domain.UserVO)
	 */
	@Override
	public int delete(CusReplyVO cusreplyVO) throws SQLException{
		return cusreplyDao.delete(cusreplyVO);
	}

	@Override
	public int add(CusReplyVO cusreplyVO) throws DuplicateUserIdException{
		//TODO: return 

		return cusreplyDao.add(cusreplyVO);
	}

	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#do_retrieve(com.sist.hr.common.SearchVO)
	 */
	@Override
	public List<CusReplyVO> do_retrieve(CusReplyVO cusreplyVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException{
		return cusreplyDao.do_retrieve(cusreplyVO);
	}
	

	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#get(com.sist.hr.user.domain.UserVO)
	 */


	@Override
	public int do_deleteMulti(List<CusReplyVO> list) throws RuntimeException, SQLException {
		int flag = 0;
		try {
			for(CusReplyVO vo :list) {
				flag+=cusreplyDao.delete(vo);
			}
			
		}catch(RuntimeException e) {
			log.debug("========================");
			log.debug("RuntimeException: "+e.getMessage());
			log.debug("========================");			
			throw e;
		}
		log.debug("========================");
		log.debug("=flag="+flag);
		log.debug("========================");
		return flag;
	}

	@Override
	public CusReplyVO get(CusReplyVO cusreplyVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}



