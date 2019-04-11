package com.bes.corba.test;


/**
* com/bes/corba/test/CalcOperations.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hello.idl
* 2018年11月23日 星期五 下午03时20分53秒 GMT+08:00
*/

public interface CalcOperations 
{
  void add (int a, int b, org.omg.CORBA.IntHolder c);
  void sub (int a, int b, org.omg.CORBA.IntHolder c);
  void multi (int a, int b, org.omg.CORBA.IntHolder c);
  void div (int a, int b, org.omg.CORBA.IntHolder c);
} // interface CalcOperations
