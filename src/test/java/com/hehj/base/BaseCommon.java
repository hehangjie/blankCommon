package com.hehj.base;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.hehj.dao.DemoDao;
import com.hehj.entity.Demo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BaseCommon {
	
	@Autowired
	private DemoDao demoDao;
	
	@Test
	public void testLoadAll(){
		List<Demo> list = demoDao.loadAll();
		
		if(list.size()==0){
			System.out.println("没有数据");
			return;
		}
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
	}
	
}
