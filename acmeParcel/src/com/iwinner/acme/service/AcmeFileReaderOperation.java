package com.iwinner.acme.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.iwinner.acme.utils.AcmeConstants;
import com.iwinner.acme.vo.AcmeVO;

public class AcmeFileReaderOperation {

	public static Object fileRead(){
		List<AcmeVO> listOfParcelNames=new ArrayList<AcmeVO>();
		Map<String,String> aMap = new HashMap<String,String>();
		try{
		File file=new File(AcmeConstants.INPUT_SOURCE_FILE);
		FileReader fReader=new FileReader(file);
		BufferedReader br=new BufferedReader(fReader);
		String line="";
		
		while((line=br.readLine())!=null){
			AcmeVO aVO=new AcmeVO();
			String sp[]=line.split(",");
			String news=sp[4].trim();
			int size="PIN -".length();
			String s=news.substring(size, news.length());
			String pinCount = aMap.get(s);
			if(null!=pinCount)
			{
				pinCount = (Integer.parseInt(pinCount) + 1) + "";
			}			
			else
			{
				pinCount = "1";
				aMap.put(s, pinCount);
			}
			aVO.setPinId(Integer.parseInt(s));
			aVO.setCustName(sp[0]);
			aVO.setLocationName(sp[1]);
			aVO.setCustName(sp[2]);
			listOfParcelNames.add(aVO);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listOfParcelNames;
	}
	public static void main(String[] args) {
		List<AcmeVO> acmVO=(List<AcmeVO>)fileRead();

		Map<Integer,Integer> aMap=new HashMap<Integer, Integer>();
		for(AcmeVO aVO:acmVO){
			Integer count = aMap.get(aVO.getPinId());
			aMap.put(aVO.getPinId(), (count == null) ? 1 : count + 1);
		}
		int i=0;
		Map<Integer,Integer> sortOrder=SortMapByValue.sortByValues(aMap);
		try{
		File fileCreation=new File(AcmeConstants.OUTPUT_FILE);
		fileCreation.createNewFile();
		FileWriter fw=new FileWriter(fileCreation);
		BufferedWriter bw=new BufferedWriter(fw);
		  bw.write("ID"+" <<=====>>> " + "POSTID" + " <<<====>>>> "	+ "RANKID");
		for (Entry<Integer, Integer> entry : sortOrder.entrySet()) {
			i++;
			bw.newLine();
			bw.write(i+" <<=====>>> " + entry.getKey() + " <<<====>>>> "	+ entry.getValue());
			bw.flush();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
