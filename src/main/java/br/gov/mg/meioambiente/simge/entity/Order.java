package br.gov.mg.meioambiente.simge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Long customerId;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	public Long getId() {
		return id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}