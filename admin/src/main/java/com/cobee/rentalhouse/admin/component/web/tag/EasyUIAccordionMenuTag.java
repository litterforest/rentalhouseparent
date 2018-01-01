package com.cobee.rentalhouse.admin.component.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cobee.rentalhouse.core.entity.SecureResources;
import com.cobee.rentalhouse.core.entity.logical.SecureResourcesLogic;
import com.cobee.rentalhouse.core.util.NumericUtils;


public class EasyUIAccordionMenuTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8802195435868815621L;

	private static final Logger logger = LoggerFactory.getLogger(EasyUIAccordionMenuTag.class);
	
	private SecureResources menus;

	public void setMenus(SecureResources menus) {
		this.menus = menus;
	}

	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	public int doEndTag() throws JspTagException {
		
		try {
			JspWriter out = pageContext.getOut();
			if(menus != null)
			{
				StringBuilder sbuff = new StringBuilder();
				sbuff.append("<div class=\"easyui-accordion\" data-options=\"fit:true,border:false\">");
				buildWebContent(sbuff, (SecureResourcesLogic) menus);
				sbuff.append("</div>");
				out.print(sbuff.toString());
			}
			else
			{
				out.print("");
			}
			
		} catch (IOException e) {
			logger.error("", e);
		}
		
		return EVAL_PAGE;
	}
	
	private void buildWebContent(StringBuilder sbuff, SecureResourcesLogic resource) {
		String ctxPath = pageContext.getServletContext().getContextPath();
		if (!NumericUtils.equal(resource.getId(), 0)) {
			sbuff.append("<div title=\""+ resource.getName() +"\" style=\"padding:10px;\">");
			sbuff.append("<div style=\"margin-bottom: 5px;\" ><a href=\""+ ctxPath + resource.getSrcurl() +"\" target=\"myIframe\" >"+ resource.getName() + "</a></div>");
		}
		if (!CollectionUtils.isEmpty(resource.getMenuList())) {
			for (SecureResources po : resource.getMenuList()) {
				buildWebContent(sbuff, (SecureResourcesLogic) po);
			}
		}
		if (!NumericUtils.equal(resource.getId(), 0)) {
			sbuff.append("</div>");
		}
	}
	
}
