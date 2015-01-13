package com.ge.listit.services;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ge.listit.dto.LIItemDto;
import com.ge.listit.entity.LIItem;
import com.ge.listit.helper.LIHelper;
import com.ge.listit.repository.LIItemRepository;
//import org.apache.cxf.jaxrs.ext.multipart.Attachment;



@Transactional(readOnly = true)
@Path("/listit")
@Component
public class LIServiceImpl {
	
	@Autowired
	private LIHelper liHelper;
	
	public LIHelper getLiHelper() {
		return liHelper;
	}

	public void setLiHelper(LIHelper liHelper) {
		this.liHelper = liHelper;
	}

	@Resource
	private LIItemRepository listItRepository;
	
	public LIItemRepository getListItRepository() {
		return listItRepository;
	}

	public void setListItRepository(LIItemRepository listItRepository) {
		this.listItRepository = listItRepository;
	}
	
	@POST
	@Path("/saveitem")
	@Consumes({MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveItem(/*Attachment attachment,*/ LIItemDto aItem) {
		System.out.print("\n In saveItem");
		LIItem item = new LIItem();
		item.setCategory(aItem.getCategory());
		item.setDescriptionText(aItem.getDescriptionText());
		item.seteMail(aItem.geteMail());
		item.setPhoneNumber(aItem.getPhoneNumber());
		item.setTimeStamp(String.valueOf(System.currentTimeMillis()));
		item.setUser(aItem.getUserid());
		item.setPrice(aItem.getPrice());
		item.setTitle(aItem.getPostTitle());
		listItRepository.save(item);
		
		return getResponse(Status.OK, null);
	}
	
	@GET
	@Path("/getitems")
	@Consumes({ MediaType.APPLICATION_JSON })
	 @Produces({ MediaType.APPLICATION_JSON })
	public Response getItems(@QueryParam("category") String category) {
		System.out.print("getItems :"+category);
		
		List<LIItem> items = listItRepository.findByCategory(category);
		
		return getResponse(Status.OK, items);
	
	}
	
	@GET
	@Path("/getitem")
	@Consumes({ MediaType.APPLICATION_JSON })
	 @Produces({ MediaType.APPLICATION_JSON })
	public Response getItem(@QueryParam("itemid") Long id) {
		System.out.print("getItem Id :"+id);
		
		LIItem item = listItRepository.findOne(id);
		return getResponse(Status.OK, item);
	
	}
 
 
	public  <T> Response getResponse(Status status, Object result) {		
		return Response.status(status).entity(result).build();
	}

}
