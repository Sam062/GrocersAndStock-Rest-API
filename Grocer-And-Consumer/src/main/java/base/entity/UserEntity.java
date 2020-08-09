package base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserEntity {
	@Id
	@GenericGenerator(name = "ID_GEN",strategy = "base.idGen.UserIDGenereater")
	@GeneratedValue(generator = "ID_GEN")
	@Column(name = "USR_ID")
	private String userID;
	@Column(name = "USR_NAME")
	private String userName;
	@Column(name = "USR_LOC")
	private String location;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;
}
