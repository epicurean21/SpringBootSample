package com.example.service;

import com.example.domain.TestMessage;

public interface BasicService {

	String test(int flag);

	TestMessage jsonTest();

	String test2(int flag);
}
