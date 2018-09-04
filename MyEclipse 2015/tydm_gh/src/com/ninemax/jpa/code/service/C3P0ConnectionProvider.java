package com.ninemax.jpa.code.service;

import java.util.Properties;

import com.ninemax.jpa.util.Arithmetic;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Environment;

/**
 * ��дc3p0��configure��������������ļ���������ܵ�����
 *
 * @author zhoupeng
 *         TODO
 *         2013-3-19����10:03:18
 */
public class C3P0ConnectionProvider extends org.hibernate.connection.C3P0ConnectionProvider {
    public C3P0ConnectionProvider() {
        super();

    }

    @Override
    public void configure(Properties props) throws HibernateException {
        if (props.getProperty(Environment.PASS) != null)
            props.setProperty(Environment.PASS, Arithmetic.des(props.getProperty(Environment.PASS)));
        super.configure(props);
    }
}
