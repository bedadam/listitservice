package com.ge.listit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ge.listit.entity.LIItem;

public interface LIItemRepository extends JpaRepository<LIItem, Long>{
	
	@Query("SELECT items FROM LIItem items WHERE LOWER(items.category)= LOWER(:category)")
	public List<LIItem> findByCategory(@Param("category") String category);
	
	@Query("SELECT items FROM LIItem items WHERE LOWER(items.user)= LOWER(:user)")
	public List<LIItem> findByUser(@Param("user") String user);
}
