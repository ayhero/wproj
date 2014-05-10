<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.beans.factory.FactoryBean"%>
<%@page import="org.springframework.security.web.access.intercept.FilterSecurityInterceptor"%>
<%@page import="org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource"%>
<%
    ApplicationContext ctx =  WebApplicationContextUtils.getWebApplicationContext(application);
    FactoryBean factoryBean = (FactoryBean) ctx.getBean("&filterInvocationSecurityMetadataSource");
    FilterInvocationSecurityMetadataSource fids = (FilterInvocationSecurityMetadataSource) factoryBean.getObject();
    FilterSecurityInterceptor filter = (FilterSecurityInterceptor) ctx.getBean("filterSecurityInterceptor");
    filter.setSecurityMetadataSource(fids);
%>
<jsp:forward page="/"/>
<div class="error ${param.error == true ? '' : 'hide'}">
  登陆失败<br>
  ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
</div>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" style="width:260px;text-align:center;">
  <fieldset>
    <legend>登陆</legend>
    用户： <input type="text" name="j_username" style="width:150px;" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/><br />
    密码： <input type="password" name="j_password" style="width:150px;" /><br />
    <input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆<br />
    <input type="submit" value="登陆"/>
    <input type="reset" value="重置"/>
  </fieldset>
</form>