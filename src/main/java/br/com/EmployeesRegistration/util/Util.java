//package br.com.EmployeesRegistration.util;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.BeanWrapper;
//import org.springframework.beans.BeanWrapperImpl;
//
//import java.beans.PropertyDescriptor;
//
//public class Util {
//
//    public static void copyNonNullProperties(Object source , Object target){
//        BeanUtils.copyProperties(source,target,getNullProperty(source));
//    }
//
//    public  static String[] getNullPropertyNames(Object source){
//        final BeanWrapper src = new BeanWrapperImpl(source);
//        PropertyDescriptor[] propertyDescriptor = src.getPropertyDescriptors();
//    }
//}
