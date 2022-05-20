package br.com.theasier.searchflight.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import br.com.theasier.searchflight.infra.GenericEntitySearch;

@Entity
@Table(name = "scan")
public class Scan implements GenericEntitySearch{

	private static final long serialVersionUID = -5962632414056663352L;
	
	@Id
	@GeneratedValue(generator="seqGenerator")
	@GenericGenerator(name = "seqGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
				parameters = { @Parameter(name = "sequence_name", value = "scan_id_seq") })
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "date_scan")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateScan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateScan() {
		return dateScan;
	}

	public void setDateScan(Date dateScan) {
		this.dateScan = dateScan;
	}


}
