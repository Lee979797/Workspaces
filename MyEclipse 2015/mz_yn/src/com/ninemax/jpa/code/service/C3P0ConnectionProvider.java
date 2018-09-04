package com.ninemax.jpa.code.service;

import java.util.Properties;

import com.ninemax.jpa.util.Arithmetic;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Environment;

/**
 * 重写c3p0的configure方法，解决配置文件中密码加密的问题
 *
 * @author zhoupeng
 *         TODO
 *         2013-3-19上午10:03:18
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
