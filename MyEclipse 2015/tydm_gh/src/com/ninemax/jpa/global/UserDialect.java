package com.ninemax.jpa.global;

import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;

import java.sql.Types;

public class UserDialect extends SQLServerDialect {
    public UserDialect() {
        super();
        //registerHibernateType(Types.LONGVARCHAR, 65535, "text");//.LONGVARCHAR
        registerHibernateType(Types.DECIMAL, Hibernate.BIG_DECIMAL.getName());
        registerHibernateType(Types.DATE, Hibernate.DATE.getName());
        registerHibernateType(-1, Hibernate.STRING.getName());
        registerHibernateType(-16, Hibernate.STRING.getName());
        registerHibernateType(-9, Hibernate.STRING.getName());
        registerHibernateType(Types.CHAR, Hibernate.STRING.getName());
    }


}
