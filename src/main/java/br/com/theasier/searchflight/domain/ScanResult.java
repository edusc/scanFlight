package br.com.theasier.searchflight.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import br.com.theasier.searchflight.infra.GenericEntitySearch;

@Entity
@Table(name = "scan_result")
public class ScanResult implements GenericEntitySearch {
	
	private static final long serialVersionUID = -2117097128844429440L;
	
	@Id
	@GeneratedValue(generator="seqGenerator")
	@GenericGenerator(name = "seqGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
				parameters = { @Parameter(name = "sequence_name", value = "scan_result_id_seq") })
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_scan")
	private Scan scan;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "airport_origin")
	private String airportOrigin;
	
	@Column(name = "airport_destination")
	private String airportDestination;
	
	@Column(name = "number_scales")
	private Integer numberScales;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "date_departure")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDeparture;
	
	@Column(name = "date_return")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateReturn;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Scan getScan() {
		return scan;
	}

	public void setScan(Scan scan) {
		this.scan = scan;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getAirportOrigin() {
		return airportOrigin;
	}

	public void setAirportOrigin(String airportOrigin) {
		this.airportOrigin = airportOrigin;
	}

	public String getAirportDestination() {
		return airportDestination;
	}

	public void setAirportDestination(String airportDestination) {
		this.airportDestination = airportDestination;
	}

	public Integer getNumberScales() {
		return numberScales;
	}

	public void setNumberScales(Integer numberScales) {
		this.numberScales = numberScales;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateDeparture() {
		return dateDeparture;
	}

	public void setDateDeparture(Date dateDeparture) {
		this.dateDeparture = dateDeparture;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

}
