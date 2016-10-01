package com.atfuture.dao;

import com.atfuture.domain.Test;

public interface TestDao {

	public Test loginByNumAndPassword(String num,String password);
}
