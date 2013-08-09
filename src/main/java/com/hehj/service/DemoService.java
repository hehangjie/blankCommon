package com.hehj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hehj.common.PageConstants;
import com.hehj.common.vo.PageRequest;
import com.hehj.common.vo.PageResult;
import com.hehj.dao.DemoDao;
import com.hehj.entity.Demo;

@Service
public class DemoService {
	@Autowired
	private DemoDao demoDao;
	@Autowired
	private PageConstants constants;

	public PageResult<Demo> pageResault(Demo search,int currentPage) {
		// 是不是可以写成切面
		if (search == null) {
			search = new Demo();
		}
		if (currentPage == 0) {
			currentPage = 1;
		}
		
		PageRequest<Demo> request = new PageRequest<Demo>(search, currentPage,
				constants.getPageMax());
		List<Demo> list = demoDao.find(request.getHql(), request.getOffset(),
				request.getMax());
		int allPage = demoDao.getCount(request.getHql());
		PageResult<Demo> result = new PageResult<Demo>(list, allPage,
				currentPage, request.getMax());
		return result;
	}

}
