/**
 * 
 */
package com.slt.infobus.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Venu
 *
 */
@Entity
@Table(name="ib_roles_dtl")
public class IBRolesDtl {
	private int roleId;
	private String roleName; 
	private String access;
	
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Column(name="role_name")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Column(name="access")	
	public String getAccess() {
		return access;
	}
	public void setAccess(String access) {
		this.access = access;
	} 
}
