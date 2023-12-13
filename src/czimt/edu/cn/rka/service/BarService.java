package czimt.edu.cn.rka.service;

import java.util.List;

import czimt.edu.cn.rka.entity.Bar;

public interface BarService {

	public int barAdd(Bar bar);
	/*
	 * bar add method
	 */
	
	public int barDel(Bar bar);
	/*
	 * bar delete method
	 */
	
	public int barEdit(Bar bar);
	/*
	 * bar edit method
	 */
	
	public List barSelect(Bar bar);
	
	public Bar barSelectbyid(Bar bar);
}