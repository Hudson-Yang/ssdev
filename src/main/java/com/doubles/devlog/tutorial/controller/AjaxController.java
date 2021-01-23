package com.doubles.devlog.tutorial.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubles.devlog.tutorial.vo.SampleVO;

@RestController
@RequestMapping( value = "/ajax/test")
public class AjaxController {
	
	@RequestMapping( value = "/sayhello")
	public String sayHello() {
		return "say hello";
	}
	
	@RequestMapping( value = "/sendvo")
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setSampleNo(1);
		sample.setFirstName("hong");
		sample.setLastName("seung");
		
		return sample;
	}
	
	@RequestMapping( value = "/sendlist")
	public List<SampleVO> sendList(){
		
		List<SampleVO> samples = new ArrayList<>();
		for(int i=0 ; i<10 ; i++) {
			SampleVO sample = new SampleVO();
			sample.setSampleNo(i);
			sample.setFirstName("hong");
			sample.setLastName("seung"+i);
			samples.add(sample);
		}
		
		return samples;
	}
	
	@RequestMapping( value = "/sendmap")
	public Map<Integer, SampleVO> sendMap(){
		
		Map<Integer, SampleVO> sampleMap = new HashMap<>();
		for(int i=0 ; i<10 ; i++) {
			SampleVO sample = new SampleVO();
			sample.setSampleNo(i);
			sample.setFirstName("hong");
			sample.setLastName("seung"+i);
			sampleMap.put(i,sample);
		}
		return sampleMap;
	}
	
	@RequestMapping( value = "/send-errorauth")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping( value = "/send-error-not")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		
		List<SampleVO> samples = new ArrayList<>();
		for(int i=0 ; i<10 ; i++) {
			SampleVO sample = new SampleVO();
			sample.setSampleNo(i);
			sample.setFirstName("hong");
			sample.setLastName("seung"+i);
			samples.add(i, sample);
		}
		return new ResponseEntity<>(samples, HttpStatus.NOT_FOUND);
	}

}
