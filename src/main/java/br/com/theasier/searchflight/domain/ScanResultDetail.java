package br.com.theasier.searchflight.domain;

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
@Table(name = "scan_result_detail")
public class ScanResultDetail implements GenericEntitySearch {
	
	private static final long serialVersionUID = -8958679087377449512L;

	@Id
	@GeneratedValue(generator="seqGenerator")
	@GenericGenerator(name = "seqGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
				parameters = { @Parameter(name = "sequence_name", value = "scan_result_detail_id_seq") })
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_scan_result")
	private ScanResult scanResult;
	
	@Column(name = "airline_departure")
	private String airlineDeparture;
	
	@Column(name = "airline_return")
	private String airlineReturn;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time_departure")
	private Date timeDeparture;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "time_return")
	private Date timeReturn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ScanResult getScanResult() {
		return scanResult;
	}

	public void setScanResult(ScanResult scanResult) {
		this.scanResult = scanResult;
	}

	public String getAirlineReturn() {
		return airlineReturn;
	}

	public void setAirlineReturn(String airlineReturn) {
		this.airlineReturn = airlineReturn;
	}

	public Date getTimeDeparture() {
		return timeDeparture;
	}

	public void setTimeDeparture(Date timeDeparture) {
		this.timeDeparture = timeDeparture;
	}

	public Date getTimeReturn() {
		return timeReturn;
	}

	public void setTimeReturn(Date timeReturn) {
		this.timeReturn = timeReturn;
	}

}
