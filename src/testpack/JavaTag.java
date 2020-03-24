package testpack;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class JavaTag extends SimpleTagSupport {
	
private String color ;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		// auto created in source overide implement methods
		
		super.doTag();
		JspWriter out = getJspContext().getOut();
		out.println("<h1 style=color:green>");
		getJspBody().invoke(null);
		out.println("</h1>");
		
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
