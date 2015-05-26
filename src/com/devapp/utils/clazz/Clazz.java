/**
 * <p>Title: Clazz.java</p>
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2011 by
 * Beijing freefly, Beijing, China
 * All rights reserved.</p>
 * <p>Company: freefly</p>
 * @author wangsq
 * @version 1.0
 * @see
 *
 * <PRE>
 * <U>Updated by:</U>   Lester wangsq, Nov 14, 2008
 * <U>Description:</U>  Update description
 * </PRE>
 */
package com.devapp.utils.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author kajilen
 * 
 */
@SuppressWarnings("unchecked")
public class Clazz {

	public final static String METHOD_GET_KEY = "get";

	public final static String METHOD_SET_KEY = "set";

	/**
	 * 
	 */
	public Clazz() {
	}

	/**
	 * Get entity and put fields value into entity, initialize entity
	 * 
	 * @param entityName:
	 *            entity name
	 * @param hashFields:
	 *            the value of the fields in hashtable
	 * 
	 * @return Object: the entity object
	 * 
	 */
	public static Object getEntity(String entityName,
			Hashtable<String, Object> hashFields) {
		Object entity = null;
		Object objFieldVal = null;
		Class clazz = null;
		Method m = null;
		try {
			if(hashFields == null)
			{
				return entity;
			}
			// According to the entityName to get the corresponding class Object.
			clazz = Class.forName(entityName);
			
			if (clazz == null) {
				return entity;
			}
			// Return a new Instance represented by this class,created by invoking the default constructor.
			entity = clazz.newInstance();

			if (entity == null) {
				return entity;
			}
			// Get the field declared in the class represented by this Class.
			Field[] fields = clazz.getDeclaredFields();

			int len = fields.length;

			String[] fieldsName = new String[len];
			Class[] types = new Class[len];
			for (int i = 0; i < fields.length; i++) {
				fieldsName[i] = fields[i].getName();
				types[i] = fields[i].getType();
			}

			for (int j = 0; j < len; j++) {
				try {
					if (fieldsName[j] == null || types[j] == null) {
						continue;
					}

					m = clazz.getMethod(getSMNameByField(fieldsName[j]), types[j]);

					if (m == null) {
						continue;
					}

					objFieldVal = hashFields.get(fieldsName[j]);
					if (objFieldVal != null) {
						m.invoke(entity, objFieldVal);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		}

		return entity;
	}

	/**
	 * Get entity properties by entity name
	 * 
	 * @param entityName:
	 *            entity name
	 * 
	 * @return ClazzEntity: the entity object
	 * 
	 */
	public static ClazzEntity getClazzProperties(String entityName) {
		Class clazz = null;
		ClazzEntity clazzEntity = null;

		try {
			clazz = Class.forName(entityName);

			if (clazz == null) {
				return clazzEntity;
			}

			clazzEntity = new ClazzEntity();

			Field[] fields = clazz.getDeclaredFields();

			int len = fields.length;

			String[] fieldsName = new String[len];
			Class[] types = new Class[len];
			for (int i = 0; i < fields.length; i++) {
				fieldsName[i] = fields[i].getName();
				types[i] = fields[i].getType();
			}

			clazzEntity.setFieldsName(fieldsName);
			clazzEntity.setTypes(types);
			clazzEntity.setFieldSize(len);
			clazzEntity.setClazz(clazz);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return clazzEntity;
	}

	/**
	 * Get entity and put fields value into entity, initialize entity
	 * 
	 * @param entityName:
	 *            entity name
	 * @param hashFields:
	 *            the value of the fields in hashtable
	 * 
	 * @return Object: the entity object
	 * 
	 */
	public static Hashtable<String, Object> getEntity(String entityName,
			Object entity) {
		Hashtable<String, Object> hashEntity = null;
		Object objFieldVal = null;
		Class clazz = null;
		Method method = null;
		try {
			clazz = Class.forName(entityName);

			if (clazz == null) {
				return hashEntity;
			}

			hashEntity = new Hashtable<String, Object>();

			Field[] fields = clazz.getDeclaredFields();

			int len = fields.length;

			String[] fieldsName = new String[len];
			Class[] types = new Class[len];
			for (int i = 0; i < fields.length; i++) {
				fieldsName[i] = fields[i].getName();
				types[i] = fields[i].getType();
			}

			for (int j = 0; j < len; j++) {
				try {
					if (fieldsName[j] == null || types[j] == null) {
						continue;
					}

					method = clazz.getMethod(getGMNameByField(fieldsName[j]));

					if (method == null) {
						continue;
					}

					objFieldVal = method.invoke(entity);

					if (objFieldVal != null) {
						hashEntity.put(fieldsName[j], objFieldVal);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return hashEntity;
	}

	/**
	 * Get the method name of the parameter's getter
	 * 
	 * @param name:
	 *            gm name
	 * @return String method name
	 */
	public static String getGMNameByField(String name) {
		String gmName = METHOD_GET_KEY + name.substring(0, 1).toUpperCase()
				+ name.substring(1, name.length());
		return gmName;
	}

	/**
	 * Get the method name of the parameter's setter
	 * 
	 * @param name:
	 *            sm name
	 * @return String method name
	 */
	public static String getSMNameByField(String name) {
		String smName = METHOD_SET_KEY + name.substring(0, 1).toUpperCase()
				+ name.substring(1, name.length());
		return smName;
	}

	public static boolean checkBasicalType(Class type) {
		boolean bRet = false;
		String name = type.getName();
		if ("java.lang.String".equals(name) || "java.lang.Long".equals(name)
				|| "java.lang.Integer".equals(name)
				|| "java.lang.Date".equals(name)
				|| "java.lang.Byte".equals(name)
				|| "java.lang.Short".equals(name)
				|| "java.lang.Float".equals(name)
				|| "java.lang.Double".equals(name)
				|| "java.lang.Character".equals(name)
				|| "java.lang.Boolean".equals(name)) {
			bRet = true;
		}

		return bRet;
	}

	public static boolean checkBasicalType(String typeName) {
		boolean bRet = false;
		if ("java.lang.String".equals(typeName)
				|| "java.lang.Long".equals(typeName)
				|| "java.lang.Integer".equals(typeName)
				|| "java.lang.Date".equals(typeName)
				|| "java.lang.Byte".equals(typeName)
				|| "java.lang.Short".equals(typeName)
				|| "java.lang.Float".equals(typeName)
				|| "java.lang.Double".equals(typeName)
				|| "java.lang.Character".equals(typeName)
				|| "java.lang.Boolean".equals(typeName)) {
			bRet = true;
		}

		return bRet;
	}

	public static Object getBasicalTypeVal(String typeName, String value) {
		Object object = null;
		if ("java.lang.String".equals(typeName)) 
		{
			object = value;
		}
		else if("java.lang.Long".equals(typeName))
		{
			object = Long.parseLong(value);
		}
		else if("java.lang.Integer".equals(typeName))
		{
			object = Integer.valueOf(value);
		}else if("java.lang.Date".equals(typeName))
		{
			object = Date.parse(value);
		}else if ("java.lang.Byte".equals(typeName))
		{
			object = Byte.valueOf(value);
		}else if("java.lang.Short".equals(typeName))
		{
			object = Short.valueOf(value);
		}else if("java.lang.Float".equals(typeName))
		{
			object = Float.valueOf(value);
		}
		else if("java.lang.Double".equals(typeName))
		{ 
			object = Double.valueOf(value);
		}else if("java.lang.Character".equals(typeName))
		{
			object = value.charAt(0);
		}
		else if("java.lang.Boolean".equals(typeName))
        {
			object = Boolean.parseBoolean(value);
		}

		return object;
	}
}
