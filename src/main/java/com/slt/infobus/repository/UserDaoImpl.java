/**
 * 
 */
package com.slt.infobus.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.slt.infobus.entity.IBLocationDtl;
import com.slt.infobus.entity.User;



/**
 * @author saikrishna
 *
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User save(User user) {
		return entityManager.merge(user);		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll(){
		return entityManager.createQuery("from User").getResultList();
	}

	@Override
	public User checkAdminCredentials(String userName, String password) {
		User user = null;
		try{
		 user= (User) entityManager
				.createQuery("from User where loginId=:userName AND password=:password")
				.setParameter("userName", userName)
				.setParameter("password", password)
				.getSingleResult();
		//System.out.println("admin"+user.get(0).getId());
		}catch(NoResultException ex){
			System.out.println("No User found with the given credentials::user->"+userName+",pwd=>"+password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void updateAdmin(User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try{
			user = (User) entityManager
					.createQuery("from User where email=:email ")
					.setParameter("email", email)
					.getSingleResult();
			//System.out.println("admin"+user.get(0).getId());
			
			}catch(Exception e){
				e.printStackTrace();				
			}
		return user;
	}

	@Override
	public User getUserById(int userId) {
		User user = null;
		try{
			user = (User) entityManager
					.createQuery("from User where id=:id ")
					.setParameter("id", userId)
					.getSingleResult();
			//System.out.println("admin"+user.get(0).getId());
			return user!=null? user: null;
			}catch(Exception e){
				e.printStackTrace();
			}
		return user;
	}

	@Override
	public User getUserByMobile(String mobile) {
		User user = null;
		try{
			user = (User) entityManager
					.createQuery("from User where phone=:mobileNumber")
					.setParameter("mobileNumber", mobile)
					.getSingleResult();
			//System.out.println("admin"+user.get(0).getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	public void delete(User usr){
		entityManager.remove(usr);
	}
		
}
