package base.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "GROCER_MASTER")
public class GrocerEntity {

	@Id
	@GeneratedValue
	private Integer grocerID;
	@Column(name = "GNAME")
	private String grocerName;

	@ElementCollection()
//	@CollectionTable(name = "ITEMS_FOR_SALE",joinColumns = @JoinColumn(name="grocerID"))
	@Column(name = "ITEMS_LIST")
	private List<String> itemsForSale;
	private String location;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private Date updatedDate;

}
