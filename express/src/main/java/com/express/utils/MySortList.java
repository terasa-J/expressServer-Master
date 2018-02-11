package com.express.utils;

import java.util.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * 这是一个自定义排序的类，专门针对列表（List）中的数据进行排序；可按指定方法进行。
 * 目前实现对字符串（String）、日期（Date）、整型（Integer）等三种对象进行排序。
 *
 * @param <E>
 */
public class MySortList<E> {
    
    /**
     * 对列表中的数据按指定字段进行排序。要求类必须有相关的方法返回字符串、整型、日期等值以进行比较。
     * @param list
     * @param method
     * @param reverseFlag
     */
    public void sortByMethod(List<E> list, final String method,final boolean reverseFlag) {
        Collections.sort(list, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
            public int compare(Object arg1, Object arg2) {
                int result = 0;
                try {
                    Method m1 = ((E) arg1).getClass().getMethod(method, null);
                    Method m2 = ((E) arg2).getClass().getMethod(method, null);
                    Object obj1 = m1.invoke(((E)arg1), null);
                    Object obj2 = m2.invoke(((E)arg2), null);
                    if(obj1 instanceof String) {
                        // 字符串
                        result = obj1.toString().compareTo(obj2.toString());
                    }else if(obj1 instanceof Date) {
                        // 日期
                        long l = ((Date)obj1).getTime() - ((Date)obj2).getTime();
                        if(l > 0) {
                            result = 1;
                        }else if(l < 0) {
                            result = -1;
                        }else {
                            result = 0;
                        }
                    }else if(obj1 instanceof Integer) {
                        // 整型（Method的返回参数可以是int的，因为JDK1.5之后，Integer与int可以自动转换了）
                        result = (Integer)obj1 - (Integer)obj2;
                    }else {
                        // 目前尚不支持的对象，直接转换为String，然后比较，后果未知
                        result = obj1.toString().compareTo(obj2.toString());
                        
                        System.err.println("MySortList.sortByMethod方法接受到不可识别的对象类型，转换为字符串后比较返回...");
                    }
                    
                    if (reverseFlag) {
                        // 倒序
                        result = -result;
                    }
                } catch (NoSuchMethodException nsme) {
                    nsme.printStackTrace();
                } catch (IllegalAccessException iae) {
                    iae.printStackTrace();
                } catch (InvocationTargetException ite) {
                    ite.printStackTrace();
                }

                return result;
            }
        });
    }

    // 测试函数
  /*  public static void main(String[] args) throws Exception {
        // 生成自定义对象，然后对它按照指定字段排序
        List<Member> listMember = new ArrayList<Member>();
        listMember.add(new Member(1, "wm123", 3, "1992-12-01"));
        listMember.add(new Member(2, "a234", 8, "1995-12-01"));
        listMember.add(new Member(3, "m456", 12, "1990-12-01"));
        System.out.println("Member当前顺序...");
        System.out.println(listMember);
        
       
        
        // 方式二排序输出
        MySortList<Member> msList = new MySortList<Member>();
        msList.sortByMethod(listMember, "getUsername", false);
        System.out.println("Member按字段用户名排序后...");
        System.out.println(listMember);

        msList.sortByMethod(listMember, "getLevel", false);
        System.out.println("Member按字段级别排序后...");
        System.out.println(listMember);

        msList.sortByMethod(listMember, "getBirthday", true);
        System.out.println("Member按字段出生日期倒序后...");
        System.out.println(listMember);
    }*/
}