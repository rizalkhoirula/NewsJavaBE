package czimt.edu.cn.rka.dao;

import czimt.edu.cn.rka.entity.*;
import java.util.*;

public interface BarDao {
	
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

