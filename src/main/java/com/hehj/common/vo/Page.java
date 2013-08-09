package com.hehj.common.vo;

public class Page<T> {
	private Model<T> model;
	// 初始参数
	private int currentPage;// 当前页码
	private int resultSize = 15;// 每页记录数
	// 计算产生参数
	private int totalsPage = 1;// 总页码
	private int perviousPageId;// 上一页页码
	private int nextPageId;// 下一页页码

	private int firstResult;
	private int maxResult;

	public Page() {

	}

	/**
	 * 初始值
	 * 
	 * @param currentPage
	 * @param resultSize
	 */
	public Page(int currentPage, int resultSize) {
		this.resultSize = resultSize;
		this.setCurrentPage(currentPage);
	}

	public Model<T> getModel() {
		return model;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getResultSize() {
		return resultSize;
	}

	public int getTotalsPage() {
		return totalsPage;
	}

	public int getPerviousPageId() {
		return perviousPageId;
	}

	public int getNextPageId() {
		return nextPageId;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setModel(Model<T> model) {
		this.model = model;
		// 计算总页数
		if (model.getResultCount() > this.resultSize
				&& model.getResultCount() % this.resultSize == 0) {
			this.totalsPage = model.getResultCount() / this.resultSize;
		} else {
			this.totalsPage = model.getResultCount() / this.resultSize + 1;
		}

		this.setCurrentPage(currentPage);// 总数改变后重置当前页
	}

	/**
	 * 设入当前页的同时修改上一页和下一页
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		if (currentPage == 0) {
			this.currentPage = 1;
		}
		this.perviousPageId = currentPage - 1;
		if (this.perviousPageId == 0) {
			this.perviousPageId = 1;
		}
		this.nextPageId = this.currentPage + 1;
		if (this.nextPageId > this.totalsPage) {
			this.nextPageId = this.totalsPage;
		}
		this.firstResult = (this.currentPage - 1) * this.resultSize;
		this.maxResult = this.resultSize;
	}

	public void setResultSize(int resultSize) {
		this.resultSize = resultSize;
	}

	@SuppressWarnings("unused")
	private void setTotalsPage(int totalsPage) {
		this.totalsPage = totalsPage;
	}

	/**
	 * 上一页与下一页页码不可设
	 * 
	 * @param perviousPageId
	 */
	@SuppressWarnings("unused")
	private void setPerviousPageId(int perviousPageId) {
		this.perviousPageId = perviousPageId;
	}

	@SuppressWarnings("unused")
	private void setNextPageId(int nextPageId) {
		this.nextPageId = nextPageId;
	}

	@SuppressWarnings("unused")
	private void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	@SuppressWarnings("unused")
	private void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

}
