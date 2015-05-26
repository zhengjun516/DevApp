/**
 * <p>Title: ClazzEntity.java</p>
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

/**
 * @author kajilen
 *
 */
@SuppressWarnings("unchecked")
public class ClazzEntity {

	private int fieldSize;
	private String[] fieldsName = null;
	private Class[] types = null;
	private Class clazz;
	/**
	 * 
	 */
	public ClazzEntity() {
	}
	public int getFieldIndex(String field)
	{
		int index = 0;
		int iRetIndex = -1;
		if(fieldsName.length > 0)
		{
		    for(index = 0; index < fieldsName.length; index ++)
		    {
		    	if(fieldsName[index].compareTo(field) == 0)
		    	{
		    		iRetIndex = index;
		    		break;
		    	}
		    }
		}
		
		return iRetIndex;
	}
	public String[] getFieldsName() {
		return fieldsName;
	}
	public void setFieldsName(String[] fieldsName) {
		this.fieldsName = fieldsName;
	}
	public Class[] getTypes() {
		return types;
	}
	public void setTypes(Class[] types) {
		this.types = types;
	}
	public int getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(int fieldSize) {
		this.fieldSize = fieldSize;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

}
