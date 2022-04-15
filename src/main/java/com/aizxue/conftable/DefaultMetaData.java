package com.aizxue.conftable;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultMetaData implements IMetaData{
	private ITable table;
	private Map<String,IField> nameToFields;
	private Map<Integer,IField> indexToFields;
	private String primaryKey;
	
	public DefaultMetaData() {
		this.nameToFields = new LinkedHashMap<String,IField>();
		this.indexToFields = new LinkedHashMap<Integer, IField>();
	}
	
	@Override
	public void addField(IField field) {
		this.nameToFields.put(field.getName(),field);
		this.indexToFields.put(field.getIndex(), field);
	}
	
	public IField getField(int index) {
		return indexToFields.get(index);
	}

	@Override
	public IField getField(String name) {
		return this.nameToFields.get(name);
	}

	@Override
	public ITable getTable() {
		return this.table;
	}

	@Override
	public void setTable(ITable table) {
		this.table = table;
	}

	@Override
	public Collection<IField> fields() {
		return this.nameToFields.values();
	}

	@Override
	public String getPrimaryKey() {
		if(this.primaryKey != null) {
			return this.primaryKey;
		}
		IField field = this.getField(0);
		if(field != null) {
			return field.getName();
		}
		return null;
	}

	@Override
	public void setPrimaryKey(String key) {
		if(this.getField(key) != null) {
			this.primaryKey = key;
		}
	}
}
