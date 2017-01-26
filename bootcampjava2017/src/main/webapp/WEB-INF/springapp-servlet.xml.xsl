<?xml version="1.0" encoding="UTF-8"?>


    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:context="http://www.springframework.org/schema/context"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <bean id="DBConnection"  class="com.abugauch.bootcamp.Configuration.DBConnection">
        <property name="driver" value="com.mysql.jdbc.Driver"/>
        <property name="user" value="root"/>
        <property name="password" value="cuevana"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
    </bean>

    <bean id="atmosphere" class="com.abugauch.bootcamp.Persistence.AtmosphereDAO"/>
    <bean id="condition" class="com.abugauch.bootcamp.Persistence.ConditionDAO"/>
    <bean id="country" class="com.abugauch.bootcamp.Persistence.CountryDAO"/>
    <bean id="day" class="com.abugauch.bootcamp.Persistence.DayDAO"/>
    <bean id="state" class="com.abugauch.bootcamp.Persistence.StateDAO"/>
    <bean id="weather" class="com.abugauch.bootcamp.Persistence.WeatherDAO"/>
    <bean id="wind" class="com.abugauch.bootcamp.Persistence.WindDAO"/>

    <context:component-scan base-package="com.abugauch.bootcamp.Controller" />
</beans>