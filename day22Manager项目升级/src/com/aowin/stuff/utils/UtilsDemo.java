package com.aowin.stuff.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.aowin.stuff.dbconnection.PersonDao;
import com.aowin.stuff.exception.AddMoreException;
import com.aowin.stuff.model.Person;

public class UtilsDemo {
	private static PersonDao personDao = new PersonDao();

	// 将数据库中所有数据 以二位数组的形式返回
	public static String[][] getAllData(List<Person> list) {
		String[][] arr = new String[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			Person person = list.get(i);
			arr[i][0] = String.valueOf(person.getId());
			arr[i][1] = person.getName();
			if (person.getSex() == 1) {
				arr[i][2] = "男";
			} else if (person.getSex() == 0) {
				arr[i][2] = "女";
			}
			arr[i][3] = person.getDepartment();
			arr[i][4] = String.valueOf(person.getSalary());
		}
		return arr;
	}
	
	// 将数据库的信息存储为Xml
	public static void databaseToXML(File targetFile) throws IOException {
		List<Person> listPerson = personDao.getAll();
		System.out.println(listPerson);
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("Persons");
		document.setRootElement(root);
		for (Person Person : listPerson) {

			Element eleId = DocumentHelper.createElement("id");
			eleId.setText(String.valueOf(Person.getId()));

			Element eleName = DocumentHelper.createElement("name");
			eleName.setText(Person.getName());

			Element eleSex = DocumentHelper.createElement("sex");
			eleSex.setText(String.valueOf(Person.getSex()));

			Element eleDep = DocumentHelper.createElement("department");
			eleDep.setText(Person.getDepartment());

			Element eleSal = DocumentHelper.createElement("salary");
			eleSal.setText(String.valueOf(Person.getSalary()));

			Element elePerson = DocumentHelper.createElement("Person");
			elePerson.add(eleId);
			elePerson.add(eleName);
			elePerson.add(eleSex);
			elePerson.add(eleDep);
			elePerson.add(eleSal);

			root.add(elePerson);
		}
		write(document, targetFile);
		System.out.println("数据成功存入到XML文档中");
	}

	public static void write(Document document, File targetFile) throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileWriter(targetFile), format);
		writer.write(document);
		writer.flush();
		writer.close();
	}

	// 将集合中的数据装到 数据库中
	public static void setXmlToDatabase(File file) throws AddMoreException, SQLException, DocumentException {
		List<Person> list = getListByXML(file);
		personDao.addMore(list);
	}

	// xml封装到类中
	public static List<Person> getListByXML(File file) throws DocumentException {
		Document document = getDocument(file);
		Element PersonsXML = document.getRootElement();
		List<Person> listPerson = new ArrayList<Person>();
		Person Person = null;
		for (Iterator iterator1 = PersonsXML.elementIterator(); iterator1.hasNext();) {
			Person = new Person();
			Element PersonXML = (Element) iterator1.next();
			for (Iterator iterator2 = PersonXML.elementIterator(); iterator2.hasNext();) {
				Element ele = (Element) iterator2.next();
				if (ele.getName().equals("name")) {
					Person.setName(ele.getText());
				} else if (ele.getName().equals("id")) {
					Person.setId(Integer.valueOf(ele.getText()));
				} else if (ele.getName().equals("sex")) {
					Person.setSex(Integer.valueOf(ele.getText()));
				} else if (ele.getName().equals("department")) {
					Person.setDepartment(ele.getText());
				} else if (ele.getName().equals("salary")) {
					Person.setSalary(Integer.valueOf(ele.getText()));
				}
			}
			System.out.println(Person);
			listPerson.add(Person);
		}
		return listPerson;
	}

	// 将docuemnt 写入 file
	public static Document getDocument(File file) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		System.out.println(file);
		Document document = saxReader.read(file);
		System.out.println(11);
		return document;
	}


}
