package com.atfuture.service;

import java.util.List;

import com.atfuture.domain.RequestCode;

public interface RequestCodeService {

	//得到指定id的邀请码对象
	public RequestCode getSpecialRequestCode(Integer id);
	//得到所有的邀请码，如果为空则新建，如果有的话就更新，保证，邀请码只有一个
	public List<RequestCode> getAllRequestCodes();
	//更新邀请码
	public void updateSpecialRequestCode(RequestCode requestCode);
	//保存邀请码
	public void saveRequestCode(RequestCode requestCode);
	//保存或更新
	public void saveOrUpdateRequestCode(RequestCode requestCode);
}
