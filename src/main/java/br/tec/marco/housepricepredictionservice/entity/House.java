/**
 * 
 */
package br.tec.marco.housepricepredictionservice.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author marcoyf
 *
 */
@Entity
public class House {
	
	@Id
	@GeneratedValue
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long  id;
	
	private BigDecimal houseSize;
	private BigDecimal lotSize;
	private Integer bedrooms;
	private Short kitchenGranite;
	private Short upgradedBathroom;
	private BigDecimal sellingPrice;
	
	@Transient
	private int port;

	/**
	 * 
	 */
	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param houseSize
	 * @param lotSize
	 * @param bedrooms
	 * @param kitchenGranite
	 * @param upgradedBathroom
	 * @param sellingPrice
	 */
	public House(BigDecimal houseSize, BigDecimal lotSize, Integer bedrooms, Short kitchenGranite,
			Short upgradedBathroom) {
		super();
		this.houseSize = houseSize;
		this.lotSize = lotSize;
		this.bedrooms = bedrooms;
		this.kitchenGranite = kitchenGranite;
		this.upgradedBathroom = upgradedBathroom;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the houseSize
	 */
	public BigDecimal getHouseSize() {
		return houseSize;
	}

	/**
	 * @param houseSize the houseSize to set
	 */
	public void setHouseSize(BigDecimal houseSize) {
		this.houseSize = houseSize;
	}

	/**
	 * @return the lotSize
	 */
	public BigDecimal getLotSize() {
		return lotSize;
	}

	/**
	 * @param lotSize the lotSize to set
	 */
	public void setLotSize(BigDecimal lotSize) {
		this.lotSize = lotSize;
	}

	/**
	 * @return the bedrooms
	 */
	public Integer getBedrooms() {
		return bedrooms;
	}

	/**
	 * @param bedrooms the bedrooms to set
	 */
	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	/**
	 * @return the kitchenGranite
	 */
	public Short getKitchenGranite() {
		return kitchenGranite;
	}

	/**
	 * @param kitchenGranite the kitchenGranite to set
	 */
	public void setKitchenGranite(Short kitchenGranite) {
		this.kitchenGranite = kitchenGranite;
	}

	/**
	 * @return the upgradedBathroom
	 */
	public Short getUpgradedBathroom() {
		return upgradedBathroom;
	}

	/**
	 * @param upgradedBathroom the upgradedBathroom to set
	 */
	public void setUpgradedBathroom(Short upgradedBathroom) {
		this.upgradedBathroom = upgradedBathroom;
	}

	/**
	 * @return the sellingPrice
	 */
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * @param sellingPrice the sellingPrice to set
	 */
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", houseSize=" + houseSize + ", lotSize=" + lotSize + ", bedrooms=" + bedrooms
				+ ", kitchenGranite=" + kitchenGranite + ", upgradedBathroom=" + upgradedBathroom + ", sellingPrice="
				+ sellingPrice + "]";
	}
}