package repository;

import org.springframework.data.repository.CrudRepository;

import entity.CrawlEntity;

public interface CrawlRepository extends CrudRepository<CrawlEntity, Integer>{
	
}
