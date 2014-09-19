package user.management.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.ResetPasswordsDao;
import user.management.model.ResetPasswords;
import user.management.model.Users;
import user.management.service.api.ResetPasswordsService;
import user.management.service.utils.HqlStringCreator;

@Transactional
@Service("resetPasswordsService")
public class ResetPasswordsBusinessService extends AbstractBusinessService<ResetPasswords, Integer, ResetPasswordsDao> implements ResetPasswordsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setResetPasswordsDao(ResetPasswordsDao resetPasswordsDao) {
		setDao(resetPasswordsDao);
	}


	/**
	 * {@inheritDoc}
	 */
	public ResetPasswords findResetPassword(final Users user) {
		return ListUtils.getFirst(find(user, null, null, null));
	}

	/**
	 * {@inheritDoc}
	 */
	public ResetPasswords findResetPassword(final Users user,
			final String generatedPassword) {
		return ListUtils.getFirst(find(user, generatedPassword, null, null));
	}
	

	@SuppressWarnings("unchecked")
	public List<ResetPasswords> find(Users user, String generatedPassword, Date expiryDate, Date starttime) {
		String hqlString = HqlStringCreator.forResetPasswords(user, generatedPassword, expiryDate, starttime);
		final Query query = getQuery(hqlString);
		if(user != null){
			query.setParameter("user", user);
		}
		if(generatedPassword != null) {
			query.setParameter("generatedPassword", generatedPassword);
		}
		if(expiryDate != null){
			query.setParameter("expiryDate", expiryDate);			
		}
		if(starttime != null){
			query.setParameter("starttime", starttime);			
		}
		final List<ResetPasswords> resetPasswords = query.getResultList();
		return resetPasswords;		
	}

}