package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Crawl")
public class CrawlEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CrawlID")
    private int CrawlID;
    
    @Column(name = "CrawlURL")
    private String CrawlURL;

	public CrawlEntity() {
	}

	public CrawlEntity(int crawlID, String crawlURL) {
		CrawlID = crawlID;
		CrawlURL = crawlURL;
	}

	public int getCrawlID() {
		return CrawlID;
	}

	public void setCrawlID(int crawlID) {
		CrawlID = crawlID;
	}

	public String getCrawlURL() {
		return CrawlURL;
	}

	public void setCrawlURL(String crawlURL) {
		CrawlURL = crawlURL;
	}
    
}
