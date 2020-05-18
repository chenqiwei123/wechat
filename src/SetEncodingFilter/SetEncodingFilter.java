package SetEncodingFilter;

import javax.servlet.*;
import java.io.IOException;

public class SetEncodingFilter implements Filter {
    protected String encoding = null;//定义缺省字符编码方式
    protected boolean ignore = true;//定义客户端指定的编码方式是否应被忽略
    protected FilterConfig filterConfig = null;//定义过滤器配置对象,若为null,则说明过滤器未配置

    public void destroy()//停止过滤器的工作
    {
        this.encoding = null;
        this.filterConfig = null;
    }

    //设置字符编码
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        if (ignore || (req.getCharacterEncoding() == null)) {
            req.setCharacterEncoding(encoding);
        }
//        HttpServletRequest req1 = (HttpServletRequest)req;
//        HttpServletResponse resp = (HttpServletResponse)res;
////        UserInfo userInfo =new UserInfo();
//        UserInfo userInfo=(UserInfo)req1.getSession().getAttribute("userInfo");
//        //判断用户是否登录
//        if (userInfo.getOpenid()!=null) {
//            //放行请求
//            chain.doFilter(req, res);
//        } else {
//            //没有登录则跳转到登录页面
//            resp.sendRedirect("error/NoWechat.jsp");
//        }
        chain.doFilter(req, res);

    }

    //启动过滤器
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
        String value = filterConfig.getInitParameter("ignore");
        if (value == null) this.ignore = true;
        else this.ignore = value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("yes");
    }

}