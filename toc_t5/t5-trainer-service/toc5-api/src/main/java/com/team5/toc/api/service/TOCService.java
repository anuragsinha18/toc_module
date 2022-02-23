package com.team5.toc.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.toc.api.beans.TOC;
import com.team5.toc.api.repo.TOCRepository;

/**
 * 
 * @author anurag
 * @see service methods of TOC.
 * @since feb 2022
 *
 */

@Service
public class TOCService {
	
	@Autowired
	private TOCRepository tocRepo;
	
	public TOC saveTOC(TOC toc) {
		return tocRepo.insert(toc);
	}
	
	public List<TOC> getAllTocs(){
		return tocRepo.findAll();
	}
	
	public Optional<TOC> getTocById(Integer id){
		return tocRepo.findById(id);
	}

	public TOC getTocByIdAsObject(Integer id){
		Optional<TOC> byId = tocRepo.findById(id);
		return byId.isPresent()?byId.get(): null;
	}
}
