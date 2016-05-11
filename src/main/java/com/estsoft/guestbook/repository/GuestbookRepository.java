package com.estsoft.guestbook.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;

@Repository
public class GuestbookRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save( Guestbook guestbook ) {
		em.persist( guestbook );
		System.out.println( guestbook );
	}

	public Boolean remove( Guestbook guestbook ) {
    	TypedQuery<Guestbook> query = em.createQuery( "select b from Guestbook b where b.no = :no and b.password = :password", Guestbook.class );
		query.setParameter( "no", guestbook.getNo() );
		query.setParameter( "password", guestbook.getPassword() );
		
		List<Guestbook> list = query.getResultList();
		if( list.size() != 1 ) {
			return false;
		}
		
		em.remove( list.get( 0 ) );
		return true;
	}
	
	public List<Guestbook> findAll() {
    	TypedQuery<Guestbook> query = em.createQuery( "select b from Guestbook b order by b.regDate desc", Guestbook.class );
    	return query.getResultList();
	}
}
