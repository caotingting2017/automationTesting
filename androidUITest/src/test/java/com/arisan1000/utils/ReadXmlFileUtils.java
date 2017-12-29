package com.arisan1000.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;

public class ReadXmlFileUtils {

	private static Map<String, Object> element = new HashMap<String, Object>();
	File classpathRoot = new File(System.getProperty("user.dir"));
	File XmlDir = new File(classpathRoot, "elementsXmlFiles");

	/**
	 * 读取文档的要元素节点
	 * @param filename
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Element getRootElement(String filename) throws Exception{
		File xmlFile = new File(XmlDir, filename);

		// 读取文件
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document;
		document = saxBuilder.build(xmlFile);

		Element classElement = document.getRootElement();
		
		return classElement;
	}
	
	/**
	 * 获取filename文档中的,class标签的name值为id的结构体中的所有子节点
	 * 
	 * @param filename
	 * @param id:
	 *            element标签属性name的值，参考<element name="start"> ,id 为 "start"
	 * @return Map<tag, value> 存在所有子节点的Map对象
	 * @throws Exception
	 */
	public Map<String, Object> getElement(String filename, String id) throws Exception {
//		File xmlFile = new File(XmlDir, filename);
//
//		// 读取文件
//		SAXBuilder saxBuilder = new SAXBuilder();
//		Document document;
//		document = saxBuilder.build(xmlFile);
//
//		Element classElement = document.getRootElement();
		Element classElement = getRootElement(filename);
		
		List<Element> elementIndex = classElement.getChildren("element");
		if (!elementIndex.isEmpty()) {
			for (Element elt : elementIndex) {
				if(!id.equals(elt.getAttribute("name").getValue())){
					continue;
				}
//				if (id.equals(elt.getAttribute("name").getValue())) {// 查找name值为id的index标签
					List<Element> children = elt.getChildren();
					for (Element child : children) {
						if (child.getChildren().isEmpty()) {
							element.put(child.getName(), child.getText());
						} else {
							Map<String, String> childrenElement = new HashMap<String, String>();
							for (Element childrenChild : child.getChildren()) {
								childrenElement.put(childrenChild.getAttribute("name").getValue(),
										childrenChild.getText());
							}
							element.put(child.getName(), childrenElement);
						}
					}
					break;
//				} 
			}
		}
		return element;
	}
	
	/**
	 * 获取定位标识相同的一组元素
	 * @param elementName
	 * @param filename
	 * @return
	 * @throws Exception
	 */
	public Element getListElemts(String elementName,String filename) throws Exception{
		Element desElement = null;
		Element classElement = getRootElement(filename);
		List<Element> elementsList = classElement.getChildren("elements");
		if (!elementsList.isEmpty()) {
			// 找出elementName匹配的elements元素块
			for (Element elt : elementsList) {
				if (elementName.equals(elt.getAttribute("name").getValue())) {
					desElement = elt;
					break;
				}
			}
		}
		return desElement;
	}
	
	public Map<String, Object> getListElementChild(String listElementName,String filename,String index) throws Exception{
		//TODO
		System.out.println("index:"+index);
		Element elements = getListElemts(listElementName,filename);//找到符合条件的<elements>
		List<Element> childrenOfElements = elements.getChildren();
		
//		if (childrenOfElements.isEmpty()) {
//			return element;
//		}
		if(!childrenOfElements.isEmpty()){//有子结点
			for(Element childElements :childrenOfElements ){
				System.out.println("index.equals(childElements.getAttributeValue(\"index\")):true or false:"+index.equals(childElements.getAttributeValue("index")));
				if(index.equals(childElements.getAttributeValue("index"))){//找到index匹配的<element>
					if (!childElements.getChildren().isEmpty()) {
						List<Element> childrenOfElement = childElements.getChildren();//<description><text>标签
						for(Element childOfElement:childrenOfElement){
							if(childrenOfElement.isEmpty()){//<description>标签没有子标签
								element.put(childOfElement.getName(), childOfElement.getText());
							}else {//遍历<text>标签，将子标签放入Map中
								Map<String, String> grandChildrenElement = new HashMap<String, String>();
								for (Element grandChildrenChild : childOfElement.getChildren()) {
									grandChildrenElement.put(grandChildrenChild.getAttribute("name").getValue(),
											grandChildrenChild.getText());
								}
								element.put(childOfElement.getName(), grandChildrenElement);
								
							}
							
						}
					} 
					break;
				}				
				else{
					continue;
				}
			}
		}else{
			System.out.println("标签下没有子元素");
		}
		
		return element;
	}

	/**
	 * 查找命名为elementName的一批元素
	 * 
	 * @param filename
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public String getElementsAccessibility( String elementName,String filename) throws Exception {
//		String accessbilityId = null;
//		Element classElement = getRootElement(filename);
//		List<Element> elementsList = classElement.getChildren("elements");
//		if (!elementsList.isEmpty()) {
//			// 找出id匹配的elements元素块
//			for (Element elt : elementsList) {
//				if (elementName.equals(elt.getAttribute("name").getValue())) {
//					accessbilityId = elt.getAttributeValue("id");//获取定位标识
//					break;
//				}
//					
//			}
//
//		}else{
//			System.err.println("无此元素");
//		}
//
//		
		return getListElemts(elementName,filename).getAttributeValue("id");
	}
}
