package com.m2.idm.web.rest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2.idm.service.VideoService;

import services.PlaylistService;

@RestController
@RequestMapping("/api")
public class VideoRessource {
	
	private final Logger log = LoggerFactory.getLogger(VideoRessource.class);
	private final VideoService videoService;
	
	public VideoRessource( VideoService videoService )
	{
		this.videoService = videoService;
	}
	
	@GetMapping(path="/video",produces="video/mp4")
	public ResponseEntity<InputStreamResource> stream(@PathVariable("names") String names) throws FileNotFoundException{
		
		String[] tabNames = names.split(",");
		List<String> list = new ArrayList<>();
		for ( String file : tabNames){
			list.add(file+".mp4");
		}
		PlaylistService playlist = new PlaylistService("src/main/resources/specs.videogen");
		String outputPath = playlist.process(list);
		File file = new File(outputPath);
		//System.out.println(System.getProperty("user.dir"));
		InputStreamResource stream = new InputStreamResource( new FileInputStream(file));
		return new ResponseEntity<InputStreamResource>(stream, HttpStatus.OK);
		
	}
	@GetMapping(path="/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<String>("titi",HttpStatus.OK);
	}
	
	@GetMapping(path="/pic/{name}",produces="image/png")
	public ResponseEntity<InputStreamResource> streamPicture(@PathVariable("name") String name) throws FileNotFoundException{
		
		File picture = new File("src/main/resources/pic/"+name+".png");
		InputStreamResource stream = new InputStreamResource( new FileInputStream(picture));
		return new ResponseEntity<InputStreamResource>(stream,HttpStatus.OK);
		
	}
	
	
	

}
