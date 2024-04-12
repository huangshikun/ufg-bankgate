package com.hundsun.ufg.bankgate.cmbc.util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import cn.hutool.core.util.CharsetUtil;

public class JaxbUtil {
	
	private final static Map<String, JAXBContext> JAXB_CONTEXT_MAP = new HashMap<String, JAXBContext>();

	/**
	 * bean转换成xml 默认编码:UTF-8
	 * 
	 * @param obj
	 * @return
	 * @throws JAXBException 
	 */
	public static String beanToXml(Object obj) throws JAXBException {
		return beanToXml(obj, CharsetUtil.UTF_8);
	}

	/**
	 * bean转换成xml
	 * 
	 * @param obj
	 * @param encoding
	 * @return
	 * @throws JAXBException 
	 */
	public static String beanToXml(Object obj, String encoding) throws JAXBException {
		JAXBContext jaxbContext = JAXB_CONTEXT_MAP.get(obj.getClass().getName());
        if(jaxbContext == null){
            jaxbContext = JAXBContext.newInstance(obj.getClass());
            JAXB_CONTEXT_MAP.put(obj.getClass().getName(), jaxbContext);
        }
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		return writer.toString();
	}

	/**
	 * xml转换成bean
	 * 
	 * @param xml
	 * @param c
	 * @return
	 * @throws JAXBException 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlToBean(String xml, Class<T> c, Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = JAXB_CONTEXT_MAP.get(clazz.getName());
		if (jaxbContext == null) {
			jaxbContext = JAXBContext.newInstance(c, clazz);
			JAXB_CONTEXT_MAP.put(clazz.getName(), jaxbContext);
		}
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		return (T) unmarshaller.unmarshal(new StringReader(xml));
	}
}
